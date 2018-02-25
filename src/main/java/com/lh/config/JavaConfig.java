package com.lh.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * java代码方式配置spring数据库事务
 * @author liuhao
 * @date 2018-01-04 10:50:19
 */
@Configuration
@EnableTransactionManagement  //使用事务驱动管理器
public class JavaConfig implements TransactionManagementConfigurer {
	
	private DataSource dataSource = null;//数据源
	
	/**
	 * 配置数据源
	 * @return
	 */
	@Bean(name = "dataSource")
	public DataSource initDataSource() {
		if(dataSource != null ) {
			return dataSource;
		}
		Properties props = new Properties();
		props.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		props.setProperty("url", "jdbc:msql://127.0.0.1:3306/mybatis");
		props.setProperty("username", "root");
		props.setProperty("password", "1234");
		props.setProperty("maxActive", "200");
		props.setProperty("maxIdle", "20");
		props.setProperty("maxWait", "30000");
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return dataSource;
	}
	/**
	 * 配置jdbcTemplate
	 * 
	 */
	@Bean(name="jdbcTemplate")
	public JdbcTemplate initJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(initDataSource());
		return jdbcTemplate;
	}
	/**
	 * 实现接口方法 ，返回数据库事务
	 */
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(initDataSource());
		return transactionManager;
	}

}
