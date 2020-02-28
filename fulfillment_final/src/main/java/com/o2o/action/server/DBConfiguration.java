package com.o2o.action.server;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DBConfiguration {
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource1")
	public DataSourceProperties dataSource1Prop() {
		return new DataSourceProperties();
	}

	@ConfigurationProperties(prefix = "spring.datasource1.configuration")
	@Bean
	@Primary
	public DataSource dataSource1() {
		return dataSource1Prop().initializeDataSourceBuilder().build();
	}
}