package xyz.xpman.route;

import com.jfinal.core.ActionKey;
import com.jfinal.core.ApiModel;
import com.jfinal.core.Controller;
import com.jfinal.core.MyRouteManager;
import com.jfinal.ext.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

/*
    author: Timor
    date: 2020/3/14 0014
*/
@RequestMapping(value = "/routes", viewPath = "/doc")
public class RouteController extends Controller {
    private final MyRouteManager myRouteManager = MyRouteManager.me();
    private String html = null;

    public void index() throws NoSuchFieldException, IllegalAccessException {
        boolean refresh = getParaToBoolean("refresh", false);
        if(null == html || refresh){
            Map<String, ApiModel> routes = myRouteManager.getAllRoutes();
            setAttr("routes", new ArrayList<>(routes.values()));
            html = renderToString("api.md.html", getParaMap());
        }
        renderHtml(html);
    }

    public void test() {
        renderJson("routes");
    }

    @ActionKey("/debug")
    public void debug() {
        renderJson("debug");
    }
}

