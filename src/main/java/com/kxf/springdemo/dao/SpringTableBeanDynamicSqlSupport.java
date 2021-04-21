package com.kxf.springdemo.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SpringTableBeanDynamicSqlSupport {

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	public static final SpringTableBean springTableBean = new SpringTableBean();
	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	public static final SqlColumn<Integer> id = springTableBean.id;
	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	public static final SqlColumn<String> name = springTableBean.name;
	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	public static final SqlColumn<String> info = springTableBean.info;

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	public static final class SpringTableBean extends SqlTable {
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);
		public final SqlColumn<String> info = column("info", JDBCType.VARCHAR);

		public SpringTableBean() {
			super("spring_table");
		}
	}
}