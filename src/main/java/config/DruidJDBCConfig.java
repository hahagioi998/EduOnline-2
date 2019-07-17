package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 配置连接池对象
 * @author SongPengJie
 */
@Configuration
@PropertySource("classpath:druid.properties")
public class DruidJDBCConfig {

	@Value("${driverClassName}")
	private String driver;			//驱动
	@Value("${url}")
	private String url;				//数据库地址
	@Value("${user}")
	private String user;			//数据库登录用户名
	@Value("${password}")
	private String password;		//数据库登录密码
	@Value("${initialSize}")
	private String initialSize;		//初始化连接数
	@Value("${maxActive}")
	private String maxActive;		//最大连接数
	@Value("${maxWait}")
	private String maxWait;			//最长等待时间
	
	/**
	 * 获得数据源对象
	 * @return
	 */
	@Bean(name="dataSource")
	public DataSource createDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setInitialSize(Integer.parseInt(initialSize));
		dataSource.setMaxActive(Integer.parseInt(maxActive));
		dataSource.setMaxWait(Long.parseLong(maxWait));
		return dataSource;
	}
	
	/**
	 * 获得连接池对象
	 * @param dataSource
	 * @return
	 */
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
