package xyz.xpman.system.dict.model;

import com.jfinal.ext.common.model.PageCondition;

/*
    author: 江理网猿
    date: 2020/7/21 0021
*/
public class DictTypeCondition extends PageCondition {
    private Integer id;
    private String name;

    @Override
    public String check() {
        return "";
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - -

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
