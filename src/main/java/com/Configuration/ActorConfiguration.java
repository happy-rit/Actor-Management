package com.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com/Dao")
@PropertySource("classpath:application.properties")
public class ActorConfiguration {
	
	@Autowired
	Environment environment;
	
	@Bean
	DataSource dataSource()
	{
		DriverManagerDataSource d = new DriverManagerDataSource();
		d.setDriverClassName(environment.getProperty("db.driver"));
		d.setUrl(environment.getProperty("db.url"));
		d.setUsername(environment.getProperty("db.username"));
		d.setPassword(environment.getProperty("db.password"));
		return d;
	}

	@Bean
	JdbcTemplate jdbcTemplate()
	{
		return new JdbcTemplate(dataSource());
	}
}
