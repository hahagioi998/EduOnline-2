package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import entity.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter",urlPatterns="/*")
public class LoginFilter implements Filter {

	@Autowired
	@Qualifier("systemUrl")
	private String url;
	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String requestURI = req.getRequestURI();
		if("/springApp/login/login".equals(requestURI) || "/springApp/login/image".equals(requestURI) || "/springApp/login/verifyAutoCode".equals(requestURI)) {	//如果是登录请求，直接放行
			chain.doFilter(request, response);
		}else {	//如果不是登录请求就判断session中是否有user。如果有就放行，如果没有就就跳转到登录界面
			User user = (User)req.getSession().getAttribute("user");	//获得session中的user
			if(user != null) {
				chain.doFilter(request, response);
			}else {
				request.setCharacterEncoding("utf-8");
				resp.setHeader("Access-Control-Allow-Origin", url);
				resp.setHeader("Access-Control-Allow-Credentials", "true");
				resp.setHeader("Content-Type", "text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("illegality");
			}
		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
