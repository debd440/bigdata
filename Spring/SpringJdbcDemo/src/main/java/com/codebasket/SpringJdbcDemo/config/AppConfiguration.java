package com.codebasket.SpringJdbcDemo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class AppConfiguration {

	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.driver}")
	private String driver;

	@Bean
	DataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setUrl(url);
		source.setUsername(username);
		source.setPassword(password);
		source.setMinIdle(5);
		source.setMaxIdle(10);
		source.setMaxOpenPreparedStatements(100);
		source.setDriverClassName(driver);
		return source;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSourceTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
