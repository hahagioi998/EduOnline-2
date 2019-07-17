package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 总配置文件对象
 * @author SongPengJie
 */
@Configuration
@ComponentScan({"dao","service","controller"})
@Import({WebConfig.class,DruidJDBCConfig.class,SystemConfig.class})
public class AppConfig {}
