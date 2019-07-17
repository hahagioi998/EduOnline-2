package config;

import java.nio.charset.StandardCharsets;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import filter.AdminFilter;
import filter.LoginFilter;

/**
 * servlet启动的时候会找到此类并调用onStartup方法
 * 此类相当于web容器的入口方法，并取代web.xml
 * @author SongPengJie
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	/**
	 * Spring启动时会调用此方法
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//构造Spring容器
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		//spring容器加载配置
		ctx.register(AppConfig.class);
		//spring接管ServletContext应用上下文对象
		ctx.setServletContext(servletContext);
		//添加Servlet（至少添加一个Servlet，springMVC框架实现的入口Servlet）
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		//添加过滤器（处理字符编码）
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		encodingFilter.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.addMappingForUrlPatterns(null, false, "/*");
		//添加登录过滤器（拦截非法登录）
		servletContext.addFilter("loginFilter", LoginFilter.class);
		servletContext.addFilter("adminFilter", AdminFilter.class);
	}

}
