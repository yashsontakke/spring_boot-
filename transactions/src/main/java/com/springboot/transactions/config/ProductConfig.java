package com.springboot.transactions.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.springboot.transactions")   //  in Spring Boot, you typically don’t need to specify @ComponentScan manually 
@EnableTransactionManagement 
@EnableAspectJAutoProxy
public class ProductConfig {
	
	@Bean
	public DataSource getDataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/productnew",
				"root",
				"M1D7P27@dec");
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	 @Bean
	    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
	        return new DataSourceTransactionManager(dataSource);
	    }
}
