package com.oillab.product.product.contorller;

import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.jfinal.ext.interceptor.PermissionInterceptor;
import com.jfinal.kit.StrKit;
import com.oillab.product.product.model.Product;
import com.oillab.product.product.model.ProductCondition;
import com.oillab.product.product.service.ProductService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/product", viewPath = "/view/backstage/product")
public class ProductController extends BaseViewController<Product> {
    public static final String TYPE_PAGE = "/view/default/product.html";
    public static final String PRODUCT_PAGE = "/view/default/product.html";
    public static final String CATEGORY_PAGE = "/view/default/product.html";
    @Inject private ProductService service;

    @Clear(PermissionInterceptor.class)
    public void index(){
        String[] flags = new String[3];
        for (int i = 0; i < 3; i++) {
            flags[i] = get(i);
        }

        String[] views = new String[]{CATEGORY_PAGE, TYPE_PAGE, PRODUCT_PAGE};

        setAttr("productId", flags[2]);
        setAttr("productTypeId", flags[1]);
        setAttr("productCategoryId", flags[0]);

        for (int i = 2; i >= 0; i--) {
            if(StrKit.notBlank(flags[i])){
                render(views[i]);
                return;
            }
        }

        render(CATEGORY_PAGE);
    }
    
    public void preview(String id) {
        super.preview(id);
    }

    public void view(String id) {
        if(super.processEntityById(id)){
            render("/view/default/temp/product/view.html");
            return;
        }
        renderError(404);
    }

    public void add(@Para("")ProductCondition condition) {
        super.add(condition);
    }

    public void update(@Para("")ProductCondition condition) {
        super.edit(condition);
    }

    public void list(@Para("")ProductCondition condition) {
        super.list(condition);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    protected BaseService<Product> getService() {
        return service;
    }
}
