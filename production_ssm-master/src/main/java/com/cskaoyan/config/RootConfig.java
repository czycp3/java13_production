package com.cskaoyan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 *
 * @author CZY
 */
@Configuration
@ImportResource("classpath:application.xml")
@EnableTransactionManagement
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
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/project1?serverTimezone=GMT&useSSL=false&rewriteBatchedStatements=true&useServerPrepStmts=true&cachePrepStmts=true");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql520520");
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

	/**
	 * 事务管理器
	 * @param dataSource
	 * @return DataSourceTransactionManager
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
