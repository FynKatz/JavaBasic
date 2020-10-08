package com.huyy.datasource.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.huyy.mapper.pgsql", sqlSessionFactoryRef = "pgsqlSqlSessionFactory")
public class PgsqlDataSourceConfig {
	
    @Autowired
    private Environment env;
    
	@Bean(name = "pgsqlDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.postgresql")
	public DataSource getDateSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "pgsqlSqlSessionFactory")
	public SqlSessionFactory pgsqlSqlSessionFactory(@Qualifier("pgsqlDataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(datasource);
		sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
		sqlSessionFactoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations_pgsql")));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name = "pgsqlTransactionManager")
	@Primary
	public DataSourceTransactionManager pgsqlTransactionManager(@Qualifier("pgsqlDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean("pgsqlSqlSessionTemplate")
	public SqlSessionTemplate pgsqlsqlsessiontemplate(
			@Qualifier("pgsqlSqlSessionFactory") SqlSessionFactory sessionfactory) {
		return new SqlSessionTemplate(sessionfactory);
	}
}
