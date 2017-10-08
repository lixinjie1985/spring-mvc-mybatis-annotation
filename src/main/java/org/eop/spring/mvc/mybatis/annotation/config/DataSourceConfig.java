package org.eop.spring.mvc.mybatis.annotation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author lixinjie
 * @since 2017-10-06
 */
@Configuration
@PropertySource("classpath:db/db.properties")
public class DataSourceConfig {

	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${initialSize}")
	private int initialSize;
	
	@Value("${maxActive}")
	private int maxActive;
	
	@Value("${minIdle}")
	private int minIdle;
	
	@Value("${maxWait}")
	private int maxWait;
	
	@Value("${validationQuery}")
	private String validationQuery;
	
	@Value("${poolPreparedStatements}")
	private boolean poolPreparedStatements;
	
	@Value("${maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
	
	@Value("${timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	
	@Value("${minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	
	@Bean
	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxActive(maxActive);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxWait(maxWait);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setPoolPreparedStatements(poolPreparedStatements);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		return dataSource;
	}
}
