package com.kxf.springdemo.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserBeanDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UserBean userBean = new UserBean();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = userBean.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = userBean.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> pw = userBean.pw;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> info = userBean.info;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UserBean extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> pw = column("pw", JDBCType.VARCHAR);

        public final SqlColumn<String> info = column("info", JDBCType.VARCHAR);

        public UserBean() {
            super("user_table");
        }
    }
}