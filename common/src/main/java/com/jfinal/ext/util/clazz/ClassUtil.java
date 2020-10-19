package com.jfinal.ext.util.clazz;

import com.jfinal.aop.Aop;
import com.jfinal.ext.annotation.StaticConstruct;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;

import java.lang.reflect.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类实例创建者创建者
 * Created by michael on 17/3/21.
 */
@SuppressWarnings("uncheck")
public class ClassUtil {

    public static Log log = Log.getLog(ClassUtil.class);
    private static final Map<Class<?>, Object> singletons = new ConcurrentHashMap<>();


    /**
     * 获取单例
     */
    public static <T> T singleton(Class<T> clazz) {
        Object object = singletons.get(clazz);
        if (object == null) {
            synchronized (clazz) {
                object = singletons.get(clazz);
                if (object == null) {
                    object = newInstance(clazz);
                    if (object != null) {
                        singletons.put(clazz, object);
                    } else {
                        Log.getLog(clazz).error("cannot new newInstance!!!!");
                    }

                }
            }
        }

        return (T) object;
    }

    /**
     * 创建新的实例
     */
    public static <T> T newInstance(Class<T> clazz) {
        return newInstance(clazz, true);
    }


    /**
     * 创建新的实例，并传入初始化参数
     */
    public static <T> T newInstance(Class<T> clazz, Object... paras) {
        return newInstance(clazz, true, paras);
    }


    /**
     * 是否通过 AOP 来实例化
     */
    public static <T> T newInstance(Class<T> clazz, boolean createByAop) {
        if (createByAop) {
            return Aop.get(clazz);
        } else {
            try {
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                return (T) constructor.newInstance();
            } catch (Exception e) {
                log.error("can not newInstance class:" + clazz + "\n" + e.toString(), e);
            }

            return null;
        }
    }


    public static <T> T newInstance(Class<T> clazz, boolean createByAop, Object... paras) {
        try {
            Class<?>[] classes = new Class[paras.length];
            for (int i = 0; i < paras.length; i++) {
                Object data = paras[i];
                if (data == null) {
                    throw new IllegalArgumentException("paras must not null");
                }
                classes[i] = data.getClass();
            }
            Constructor<?> constructor = clazz.getDeclaredConstructor(classes);
            constructor.setAccessible(true);
            Object ret = constructor.newInstance(paras);
            if (createByAop) {
                Aop.inject(ret);
            }
            return (T) ret;
        } catch (Exception e) {
            log.error("can not newInstance class:" + clazz + "\n" + e.toString(), e);
        }

        return null;
    }


    public static <T> T newInstanceByStaticConstruct(Class<T> clazz) {
        StaticConstruct staticConstruct = clazz.getAnnotation(StaticConstruct.class);
        if (staticConstruct == null) {
            return null;
        }

        return newInstanceByStaticConstruct(clazz, staticConstruct);
    }


    public static <T> T newInstanceByStaticConstruct(Class<T> clazz, StaticConstruct staticConstruct) {

        Method method = getStaticConstruct(staticConstruct.value(), clazz);

        if (method == null) {
            throw new RuntimeException("can not new instance by static constrauct for class : " + clazz);
        }

        try {
            return (T) method.invoke(null, (Object) null);
        } catch (Exception e) {

            log.error("can not invoke method:" + method.getName()
                    + " in class : "
                    + clazz + "\n"
                    + e.toString(), e);

            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            } else {
                throw new RuntimeException(e);
            }
        }
    }


    private static Method getStaticConstruct(String name, Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers())
                    && Modifier.isPublic(method.getModifiers())
                    && method.getReturnType() == clazz) {
                if (StrKit.isBlank(name)) {
                    return method;
                } else if (name.equals(method.getName())) {
                    return method;
                }
            }
        }
        return null;
    }

    /**
     * 创建新的实例
     */
    public static <T> T newInstance(String clazzName) {
        return newInstance(clazzName, true);
    }

    /**
     * 创建新的实例
     */
    public static <T> T newInstance(String clazzName, boolean createByAop) {
        return newInstance(clazzName, createByAop, Thread.currentThread().getContextClassLoader());
    }


    /**
     * 创建新的实例
     */
    public static <T> T newInstance(String clazzName, boolean createByAop, ClassLoader classLoader) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(clazzName, false, classLoader);
            return newInstance(clazz, createByAop);
        } catch (Exception e) {
            log.error("can not newInstance class:" + clazzName + "\n" + e.toString(), e);
        }

        return null;
    }


    private static final String ENHANCER_BY = "$$EnhancerBy";

    public static Class<?> getUsefulClass(Class<?> clazz) {
        //ControllerTest$ServiceTest$$EnhancerByGuice$$40471411#hello
        //com.demo.blog.Blog$$EnhancerByCGLIB$$69a17158
        return !clazz.getName().contains(ENHANCER_BY) ? clazz : clazz.getSuperclass();
    }


    public static Class<?> getGenericClass(Class<?> clazz) {
        Type type = getUsefulClass(clazz).getGenericSuperclass();
        return (Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }


    public static String buildMethodString(Method method) {

        StringBuilder sb = new StringBuilder()
                .append(method.getDeclaringClass().getName())
                .append(".")
                .append(method.getName())
                .append("(");

        Class<?>[] params = method.getParameterTypes();
        int in = 0;
        for (Class<?> clazz : params) {
            sb.append(clazz.getName());
            if (++in < params.length) {
                sb.append(",");
            }
        }
        return sb.append(")").toString();

    }

}
