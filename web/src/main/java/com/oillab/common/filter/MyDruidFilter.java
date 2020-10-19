package com.oillab.common.filter;

import com.alibaba.druid.filter.FilterAdapter;
import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.proxy.jdbc.JdbcParameter;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.jfinal.log.Log;
import com.jfinal.log.Log4jLog;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    author: Timor
    date: 2020/7/12 0012
*/
public class MyDruidFilter extends FilterAdapter {
    private static final Log log = Log4jLog.getLog(MyDruidFilter.class);
    private boolean formatSQL = true;
    private final boolean printSQLBeforeExecute = false;


    public MyDruidFilter() {}

    public MyDruidFilter(boolean formatSQL) {
        this.formatSQL = formatSQL;
    }

    @Override
    public boolean preparedStatement_execute(FilterChain chain, PreparedStatementProxy statement) throws SQLException {
        if(printSQLBeforeExecute) printSQL(statement.getBatchSql(), statement);
        return super.preparedStatement_execute(chain, statement);
    }

    @Override
    public void statement_close(FilterChain chain, StatementProxy statement) throws SQLException {
        super.statement_close(chain, statement);
        if(!printSQLBeforeExecute) printSQL(statement.getBatchSql(), statement);
    }

    public void printSQL(String sql, StatementProxy statement){
        // 不输出无意义的内容
        if(sql.isEmpty()) return;

        int parametersSize = statement.getParametersSize();
        List<Object> parameters = new ArrayList<>(parametersSize);
        if (parametersSize > 0) {
            for(int i = 0; i < parametersSize; ++i) {
                JdbcParameter jdbcParam = statement.getParameter(i);
                parameters.add(jdbcParam != null ? jdbcParam.getValue() : null);
            }
        }

        // 这里可以使用数据库类型常量
        String dbType = JdbcConstants.MYSQL;
        // String dbType = statement.getConnectionProxy().getDirectDataSource().getDbType();
        if(this.formatSQL) sql = SQLUtils.format(sql, dbType, parameters);

        // 打印sal
        printSQL(sql);
    }

    public void printSQL(String sql){
        String sb = "\n"
                + "MyDruidFilter SQL report ---------- " + new Date().toString() + " ---------------\n"
                + sql.trim()
                + "\n--------------------------------------------------------------------------------\n";
        // 这会输出一些看着不爽的信息……
        // log.info(sb);
        System.out.println(sb);
    }
}
