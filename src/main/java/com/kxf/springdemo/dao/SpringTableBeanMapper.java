package com.kxf.springdemo.dao;

import static com.kxf.springdemo.dao.SpringTableBeanDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.kxf.springdemo.entity.SpringTableBean;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface SpringTableBeanMapper {

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	BasicColumn[] selectList = BasicColumn.columnList(id, name, info);

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	long count(SelectStatementProvider selectStatement);

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	@DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
	int delete(DeleteStatementProvider deleteStatement);

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	@InsertProvider(type = SqlProviderAdapter.class, method = "insert")
	int insert(InsertStatementProvider<SpringTableBean> insertStatement);

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	@InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
	int insertMultiple(MultiRowInsertStatementProvider<SpringTableBean> multipleInsertStatement);

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("SpringTableBeanResult")
	Optional<SpringTableBean> selectOne(SelectStatementProvider selectStatement);

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(id = "SpringTableBeanResult", value = {
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "info", property = "info", jdbcType = JdbcType.VARCHAR) })
	List<SpringTableBean> selectMany(SelectStatementProvider selectStatement);

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	@UpdateProvider(type = SqlProviderAdapter.class, method = "update")
	int update(UpdateStatementProvider updateStatement);

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default long count(CountDSLCompleter completer) {
		return MyBatis3Utils.countFrom(this::count, springTableBean, completer);
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default int delete(DeleteDSLCompleter completer) {
		return MyBatis3Utils.deleteFrom(this::delete, springTableBean, completer);
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default int deleteByPrimaryKey(Integer id_) {
		return delete(c -> c.where(id, isEqualTo(id_)));
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default int insert(SpringTableBean record) {
		return MyBatis3Utils.insert(this::insert, record, springTableBean,
				c -> c.map(id).toProperty("id").map(name).toProperty("name").map(info).toProperty("info"));
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default int insertMultiple(Collection<SpringTableBean> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, springTableBean,
				c -> c.map(id).toProperty("id").map(name).toProperty("name").map(info).toProperty("info"));
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default int insertSelective(SpringTableBean record) {
		return MyBatis3Utils.insert(this::insert, record, springTableBean,
				c -> c.map(id).toPropertyWhenPresent("id", record::getId).map(name)
						.toPropertyWhenPresent("name", record::getName).map(info)
						.toPropertyWhenPresent("info", record::getInfo));
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default Optional<SpringTableBean> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, springTableBean, completer);
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default List<SpringTableBean> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, springTableBean, completer);
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default List<SpringTableBean> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, springTableBean, completer);
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default Optional<SpringTableBean> selectByPrimaryKey(Integer id_) {
		return selectOne(c -> c.where(id, isEqualTo(id_)));
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, springTableBean, completer);
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	static UpdateDSL<UpdateModel> updateAllColumns(SpringTableBean record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(id).equalTo(record::getId).set(name).equalTo(record::getName).set(info).equalTo(record::getInfo);
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	static UpdateDSL<UpdateModel> updateSelectiveColumns(SpringTableBean record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(id).equalToWhenPresent(record::getId).set(name).equalToWhenPresent(record::getName).set(info)
				.equalToWhenPresent(record::getInfo);
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default int updateByPrimaryKey(SpringTableBean record) {
		return update(c -> c.set(name).equalTo(record::getName).set(info).equalTo(record::getInfo).where(id,
				isEqualTo(record::getId)));
	}

	@Generated("org.mybatis.generator.api.MyBatisGenerator")
	default int updateByPrimaryKeySelective(SpringTableBean record) {
		return update(c -> c.set(name).equalToWhenPresent(record::getName).set(info).equalToWhenPresent(record::getInfo)
				.where(id, isEqualTo(record::getId)));
	}
}