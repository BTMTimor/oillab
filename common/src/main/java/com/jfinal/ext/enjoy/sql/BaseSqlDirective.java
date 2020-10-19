package com.jfinal.ext.enjoy.sql;

import com.jfinal.plugin.activerecord.SqlPara;
import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.TemplateException;
import com.jfinal.template.expr.ast.Const;
import com.jfinal.template.expr.ast.Expr;
import com.jfinal.template.expr.ast.ExprList;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.ParseException;
import com.jfinal.template.stat.Scope;

/*
    模块描述：[sql模版,通过指令扩展,参照ParaDirective]
    author: Timor
    date: 2020/7/15 0015
*/
public class BaseSqlDirective extends Directive {
    private int index = -1;

    @Override
    public void setExprList(ExprList exprList) {
        if (exprList.length() == 1) {
            Expr expr = exprList.getExpr(0);
            if (expr instanceof Const && ((Const) expr).isInt()) {
                this.index = ((Const) expr).getInt();
                if (this.index < 0) {
                    throw new ParseException("The index of para array must greater than -1", this.location);
                }
            }
        }

        this.exprList = exprList;
    }

    @Override
    public void exec(Env env, Scope scope, Writer writer) {
        SqlPara sqlPara = (SqlPara) scope.get("_SQL_PARA_");
        if (sqlPara == null) {
            throw new TemplateException("#para or #p directive invoked by getSqlPara(...) method only", this.location);
        } else {
            this.write(writer, "?");
            if (this.index == -1) {
                sqlPara.addPara("%" + this.exprList.eval(scope) + "%");
            } else {
                Object[] paras = (Object[]) scope.get("_PARA_ARRAY_");
                if (paras == null) {
                    throw new TemplateException("The #paraLike(" + this.index + ") directive must invoked by getSqlPara(String, Object...) method", this.location);
                }

                if (this.index >= paras.length) {
                    throw new TemplateException("The index of #paraLike directive is out of bounds: " + this.index, this.location);
                }

                sqlPara.addPara(paras[this.index]);
            }

        }
    }
}
