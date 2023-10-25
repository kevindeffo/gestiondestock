package com.desktech.gestiondestock.interceptor;



import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;


public class CustomInterceptor implements StatementInspector {
    @Override
    public String inspect(String sql) {
        if (StringUtils.hasLength(sql) && sql.startsWith("select")){
            if(sql.contains("where")){
                sql = sql + " and idEntreprise = 2";
            }else {
                sql = sql + " where idEntreprise = 2";
            }
        }
        System.out.println(sql);

        return sql;
    }

}
