package com.oillab.common.config;

import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.*;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.enjoy.sql.ParaLikeDirective;
import com.jfinal.ext.handel.*;
import com.jfinal.ext.interceptor.ExceptionInterceptor;
import com.jfinal.ext.interceptor.PermissionInterceptor;
import com.jfinal.ext.kit.*;
import com.jfinal.ext.plugin.route.AutoBindRequestKit;
import com.jfinal.ext.plugin.tablebind.AutoBindTablePlugin;
import com.jfinal.ext.plugin.tabledesc.TableDescPlugin;
import com.jfinal.ext.util.Console;
import com.jfinal.ext.util.clazz.scan.ClassScanUtil;
import com.jfinal.ext.util.rand.MyUUIDUtil;
import com.jfinal.i18n.I18nInterceptor;
import com.jfinal.json.FastJsonFactory;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.tx.TxByActionKeyRegex;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.template.Engine;
import com.oillab.common.filter.MyDruidFilter;
import com.oillab.common.handel.WebHandler;
import org.apache.log4j.Logger;
import xyz.xpman.system.config.model.SettingManager;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class AppConfig extends JFinalConfig {
    private static final Logger log = Logger.getLogger(AppConfig.class);
    public static final String BASE_CONFIG_PATH = PathKit.getRootClassPath();
    public static final String LOCAL_CONFIG_FILE =  "application-local.yml";
    public static final String LOCAL_TEST_CONFIG_FILE =  "application-local-test.yml";
    public static final String SERVER_CONFIG_FILE = "application-server.yml";
    public static final String BASE_TEMPLATE_PATH = "webapp";

    private ConfigKit configKit;
    private ClassScanKit classScanKit;

    private void init() {
        YamlProp yamlProp = YamlPropKit.useFirstFound(LOCAL_CONFIG_FILE, LOCAL_TEST_CONFIG_FILE, SERVER_CONFIG_FILE);
        configKit = new ConfigKit(PropKit.append(yamlProp));

        // 需要扫描的jar包名称
        String[] scanJars = configKit.getScanJars().split("\\|");
//        String[] scanPackages = configKit.getScanPackages().split("\\|");
        String scanPackages = configKit.getScanPackages();
        Console.info("scanJars: %s", Arrays.toString(scanJars));

        // 启动线程扫描：Model、Controller
        Class<?>[] scanClass = {RequestMapping.class, TableBind.class};
        classScanKit = new ClassScanKit(true)
                .addJars(scanJars).scan(scanPackages, scanClass);

        Console.info("WebRootPath: %s", PathKit.getWebRootPath());
        Console.info("RootClassPath: %s", PathKit.getRootClassPath());
        Console.info("JavaClassPaths: %s", Arrays.toString(ClassScanUtil.getJavaClassPaths()));
    }

    @Override
    public void onStart() {
        super.onStart();
        // 让虚拟机可以回收
        classScanKit = null;
        SettingManager.init(configKit.getBaseTemplatePath());
    }

    public void initBaseTemplatePath(Engine engine){
        initBaseTemplatePath(engine, null);
    }

    public void initBaseTemplatePath(Engine engine, String baseTemplatePath){
        if(StrKit.notBlank(baseTemplatePath)){
            engine.setBaseTemplatePath(baseTemplatePath);
        }

        // 生产模式使用fatjar，so……templatePath --> ClassPathSourceFactory
        if(configKit.isTemplateInClassPath()){
            engine.setToClassPathSourceFactory();
        }
    }

    @Override
    public void configConstant(Constants constants) {
        init();
        constants.setEncoding(configKit.getEncoding());
        constants.setDevMode(configKit.isDevMode());
        constants.setUrlParaSeparator(configKit.getUrlParaSeparator());

        // 不配置JFinal默认为10M
        constants.setMaxPostSize(configKit.getMaxPostSize());

        // 上传与下载
        constants.setBaseUploadPath(configKit.getBaseUploadPath());
        constants.setBaseDownloadPath(configKit.getBaseDownloadPath());

        constants.setJsonFactory(new FastJsonFactory());
        constants.setReportAfterInvocation(false);

        // 开启对 jfinal web 项目组件 Controller、Interceptor、Validator 的注入
        constants.setInjectDependency(true);
        // 开启对超类的注入。不开启时可以在超类中通过 Aop.get(...) 进行注入
        constants.setInjectSuperClass(true);
    }

    @Override
    public void configRoute(Routes routes) {
        // 这里会等待扫描线程结束
        new AutoBindRequestKit().
                bind(routes, classScanKit.getResult(RequestMapping.class));
    }

    @Override
    public void configEngine(Engine engine) {
        initBaseTemplatePath(engine, configKit.getBaseTemplatePath());

        engine.setDevMode(configKit.isDevMode());
        engine.addSharedMethod(StrKit.class);
        engine.addSharedMethod(MyUUIDUtil.class);
    }

    @Override
    public void configPlugin(Plugins plugins) {
        // 配置 druid 数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(configKit.getJdbcUrl(),
                configKit.getJdbcUsername(), configKit.getJdbcPassword());

        // 配置防火墙加强数据库安全
        WallFilter wallFilter = new WallFilter();
        wallFilter.setDbType(JdbcConstants.MYSQL);
        druidPlugin.addFilter(wallFilter);
        // 配置监控
        StatFilter statFilter = new StatFilter();
        statFilter.setMergeSql(true);
        statFilter.setLogSlowSql(true);
        statFilter.setSlowSqlMillis(1500);
        // 添加 StatFilter 才会有统计数据
        druidPlugin.addFilter(statFilter);

        // 配置log日志过滤器: 可打印sql
        // 开发模式使用自定义的过滤器打印完整sql语句；生产模式使用druid自带的
        if (configKit.isDevMode()){
            druidPlugin.addFilter(new MyDruidFilter(true));
        }else{
            Log4jFilter logFilter = new Log4jFilter();
            logFilter.setStatementLogEnabled(false);
            logFilter.setStatementLogErrorEnabled(true);
            logFilter.setStatementExecutableSqlLogEnable(true);
            druidPlugin.addFilter(logFilter);
        }
        plugins.add(druidPlugin);


        // - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        // 自动扫描model并绑定table,要在ActiveRecordPlugin启动之前调用;
        plugins.add(new AutoBindTablePlugin(arp, classScanKit.getResult(TableBind.class)));
        plugins.add(new TableDescPlugin());

        // 配置并添加数据库sql模板
        Engine engine = arp.getEngine();
        initBaseTemplatePath(engine);
        System.out.println("[configPlugin] BaseTemplatePath: " + engine.getBaseTemplatePath());
        engine.setDevMode(configKit.isDevMode());
        arp.addSqlTemplate("sql/template/all.sql");
        // engine.addDirective("paraIn", ParaInDirective.class);
        engine.addDirective("paraLike", ParaLikeDirective.class);

        plugins.add(arp);

        // - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 配置任务调度插件
        Cron4jPlugin cp = new Cron4jPlugin();
        // 每两分钟调用一次
//        cp.addTask("*/2 * * * *", new MyTask());
        plugins.add(cp);

        // ehcache缓存: cache缓存反在当前项目web目录下,可改进 TODO
        /*String ehcacheDiskStorePath = PathKit.getWebRootPath();
        File pathFile = new File(ehcacheDiskStorePath, ".ehcache");
        Configuration cfg = ConfigurationFactory.parseConfiguration();
        cfg.addDiskStore(new DiskStoreConfiguration().path(pathFile.getAbsolutePath()));
        plugins.add(new EhCachePlugin(cfg));*/
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new ExceptionInterceptor());
        interceptors.add(new PermissionInterceptor());
        /*interceptors.add(new AuthInterceptor());*/
        /*interceptors.add(new UserInterceptor());*/
        interceptors.add(new I18nInterceptor("_lang", "res", false));
//        interceptors.add(new I18nInterceptor("zh_CN", "Res"));
        interceptors.add(new TxByActionKeyRegex("(.*save.*|.*update.*|.*batch.*)"));

//        interceptors.addGlobalServiceInterceptor(new TxByActionKeyRegex("/trans.*"));

    }

    @Override
    public void configHandler(Handlers handlers) {
        // Web请求处理
        handlers.add(new WebHandler());
        // 全局主handler
        handlers.add(new GlobalHandler());
        // 用户认证
        handlers.add(new AuthHandler());
        // 权限控制
//        handlers.add(new PermissionHandler());
        handlers.add(new StaticRescuesHandler());
        // 路由分发
        handlers.add(new RouteDistributionHandel());
        // 前后端分离项目需要处理跨域请求问题
        handlers.add(new CrossDomainHandler());



        // 对Druid监控的配置与权限判断，后台需要分配权限给用户。
        DruidStatViewHandler dvh = new DruidStatViewHandler(configKit.getDruidMonitor(),//设置访问路径
                request -> {

                    //从session中拿到用户信息，如果使用ThreadLocal，就从ThreadLocal里拿
                    HttpSession hs = request.getSession(false);
                    // TODO 目前所有人都放行，待完善
                    return null != hs;

                /*
                //拿到用户userId
                Object userId=hs.getAttribute(SessionKey.ADMIN_USER_ID);
                if(userId==null||userId.toString().equals("0")) {
                    return false;
                }

                //通过权限判断工具类判断此用户是否有PermissionKey.DRUID_MONITOR这个权限
                return UserAuthKit.hasPermission(Integer.parseInt(userId.toString()), true, PermissionKey.DRUID_MONITOR);*/
                });
        handlers.add(dvh);
    }

}
