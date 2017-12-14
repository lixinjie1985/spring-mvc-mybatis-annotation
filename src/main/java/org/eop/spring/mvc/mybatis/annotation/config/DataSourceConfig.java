package org.eop.spring.mvc.mybatis.annotation.config;

import java.sql.SQLException;

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
	//cmd进入jar包目录，使用下面命令行生产加密密码和公钥，放入配置文件即可
	//java -cp druid-1.0.20.jar com.alibaba.druid.filter.config.ConfigTools 000000
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
	
	@Value("${validationQueryTimeout}")
	private int validationQueryTimeout;
	
	@Value("${testOnBorrow}")
	private boolean testOnBorrow;
	
	@Value("${testOnReturn}")
	private boolean testOnReturn;
	
	@Value("${testWhileIdle}")
	private boolean testWhileIdle;
	
	@Value("${poolPreparedStatements}")
	private boolean poolPreparedStatements;
	
	@Value("${maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
	
	@Value("${keepAlive}")
	private boolean keepAlive;
	
	@Value("${timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	
	@Value("${minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	
	@Value("${filters}")
	private String filters;
	
	@Value("${connectionProperties}")
	private String connectionProperties;
	
	@Bean(initMethod = "init", destroyMethod = "close")
	public DruidDataSource dataSource() throws SQLException {
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
		dataSource.setValidationQueryTimeout(validationQueryTimeout);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setTestWhileIdle(testWhileIdle);
		dataSource.setPoolPreparedStatements(poolPreparedStatements);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		dataSource.setKeepAlive(keepAlive);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSource.setFilters(filters);
		dataSource.setConnectionProperties(connectionProperties);
		return dataSource;
	}
}
