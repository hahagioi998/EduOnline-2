package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置系统对象
 * @author SongPengJie
 *
 */
@Configuration
@PropertySource("classpath:system.properties")
public class SystemConfig {

	@Value("${systemUrl}")
	private String url;			//域名
	
	
	/**
	 * 获得前端服务器域名
	 * @return
	 */
	@Bean(name="systemUrl")
	public String getUrl() {
		return url;
	}
}
