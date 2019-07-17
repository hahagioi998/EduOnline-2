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
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(filterName="AdminFilter",urlPatterns= {"/user/*","/departmentMajor/*","/course/*","/classes/*"})
public class AdminFilter implements Filter {

	@Autowired
	@Qualifier("systemUrl")
	private String url;
	
    /**
     * Default constructor. 
     */
    public AdminFilter() {
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
		User user = (User)req.getSession().getAttribute("user");
		if(user != null) {
			if(user.getRole() == 1) {
				chain.doFilter(request, response);
			}else {
				System.out.println("正在越权");
				resp.setContentType("text/html;charset=utf-8");
				resp.setHeader("Access-Control-Allow-Origin", url);
				resp.setHeader("Access-Control-Allow-Credentials", "true");
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
