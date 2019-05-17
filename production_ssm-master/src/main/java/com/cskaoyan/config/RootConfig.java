package com.cskaoyan.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *
 * @author CZY
 */
@Configuration
@ComponentScan(basePackages = "com.cskaoyan",
		excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class,EnableWebMvc.class})})
public class RootConfig {
	/**
	 * sqlSessionFactoryBean
	 * @param dataSource
	 * @return sqlSessionFactoryBean
	 */
	@Bean("sqlSessionFactoryBean")
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setTypeAliasesPackage("com.cskaoyan.bean");
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}

	/**
	 * datasource
	 * @return dataSource
	 */
	@Bean
	public DataSource dataSource() {
		//ComboPooledDataSource dataSource = new ComboPooledDataSource();
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/production_ssm?useSSL=false&rewriteBatchedStatements=true&useServerPrepStmts=true&cachePrepStmts=true");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		return dataSource;
	}

	/**
	 * MapperScannerConfigurer
	 * @return MapperScannerConfigurer
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		mapperScannerConfigurer.setBasePackage("com.cskaoyan.mapper");
		return mapperScannerConfigurer;
	}
}
