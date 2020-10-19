package com.jfinal.ext.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import java.util.Set;
import java.util.HashSet;

/*
    author: Timor
    date: 2020/1/16 0016
*/
public class MyRestful implements Interceptor {
    private static final String isRestfulForwardKey = "_isRestfulForward";
    private Set<String> set = new HashSet<String>() {
        private static final long serialVersionUID = 2717581127375143508L;

        {
            this.add("get");
            this.add("add");
            this.add("update");
            this.add("delete");
        }
    };

    public MyRestful() {}

    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        Boolean isRestfulForward = (Boolean)controller.getAttr("_isRestfulForward");
        String methodName = inv.getMethodName();
        if (this.set.contains(methodName) && isRestfulForward == null) {
            inv.getController().renderError(404);
        } else if (isRestfulForward != null && isRestfulForward) {
            inv.invoke();
        } else {
            String controllerKey = inv.getControllerKey();
            String method = controller.getRequest().getMethod().toUpperCase();
            String urlPara = controller.getPara();
            if ("GET".equals(method)) {
                if (urlPara != null && !"edit".equals(methodName)) {
                    controller.setAttr("_isRestfulForward", Boolean.TRUE);
                    controller.forwardAction(controllerKey + "/get/" + urlPara);
                    return;
                }
            } else {
                if ("POST".equals(method)) {
                    controller.setAttr("_isRestfulForward", Boolean.TRUE);
                    controller.forwardAction(controllerKey + "/add");
                    return;
                }

                if ("PUT".equals(method)) {
                    controller.setAttr("_isRestfulForward", Boolean.TRUE);
                    controller.forwardAction(controllerKey + "/update/" + urlPara);
                    return;
                }

                if ("DELETE".equals(method)) {
                    controller.setAttr("_isRestfulForward", Boolean.TRUE);
                    controller.forwardAction(controllerKey + "/delete/" + urlPara);
                    return;
                }
            }

            inv.invoke();
        }
    }
}

