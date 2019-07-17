package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.User;
import service.inter.IUserService;

@Controller("/login")
public class LoginController {

	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("systemUrl")
	private String url;
	
	/**
	 * 处理用户登录
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="/login/login",method=RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		request.getSession(false).setAttribute("username", username);
		int sum = (int)request.getSession().getAttribute("wrongSum");
		int count = (int)request.getSession().getAttribute("wrongCount");
		User user = null;
		if(sum == count) {
			out.print("用户名或密码错误");
		}else {
			user = userService.login(username, password,Integer.parseInt(role));
		}
		if(user == null) {
			count = (int)request.getSession().getAttribute("wrongCount");
			if(count < sum) {
				request.getSession().setAttribute("wrongCount", 1+count);
				out.print("用户名或密码错误");
			}
		}else if(request.getServletContext().getAttribute(""+user.getId()) == null){
			request.getServletContext().setAttribute(""+user.getId(), 1);
			request.getSession().removeAttribute("wrongCount");
			request.getSession().removeAttribute("wrongSum");
			request.getSession().setAttribute("user", user);
			out.print("ok");
		}else {
			out.print("此用户已经在线");
		}
	}
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/login/image")
	public void image(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int width = 100;
		int height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);
		String text = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm1234567890";
		Random random = new Random();
		g.setColor(Color.YELLOW);
		//存储生成的验证码字符串
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<5;i++) {
			int index = random.nextInt(text.length());
			char ch = text.charAt(index);
			sb.append(ch);
			g.drawString(ch+"", width/5*i, height/2);
		}
		//将生成的验证码存储到session中，用于验证用户输入是否正确
		request.getSession().setAttribute("authCode", sb.toString());
		request.getSession().setAttribute("wrongSum", 3+(int)(Math.random()*4));
		request.getSession().setAttribute("wrongCount", 0);
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
	
	@RequestMapping(value="/login/verifyAutoCode",method=RequestMethod.POST)
	public void verifyAutoCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		String authCodeServer = (String)request.getSession().getAttribute("authCode");
		String authCodeClient = request.getParameter("authCode");
		
		PrintWriter out = response.getWriter();
		if(authCodeServer.equalsIgnoreCase(authCodeClient)) {
			out.print("ok");
		}else {
			out.print("failure");
		}
	}
	
	@RequestMapping(value="login/loginSuccess",method=RequestMethod.POST)
	public void loginSuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		PrintWriter out = response.getWriter();
		User user = (User)request.getSession().getAttribute("user");
		out.print(user.getNickname());
	}
	
	/**
	 * 处理用户退出
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/login/exit")
	public void exit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		PrintWriter out = response.getWriter();
		User user = (User)request.getSession().getAttribute("user");
		//移除userid
		request.getServletContext().removeAttribute(""+user.getId());
		//移除"user"
		request.getSession().removeAttribute("user");
		//销毁session
		request.getSession().invalidate();
		out.print("ok");
	}
}
