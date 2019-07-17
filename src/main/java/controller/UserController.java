package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import entity.User;
import service.inter.IUserService;
import util.MD5;

@Controller("/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("systemUrl")
	private String url;

	/**
	 * 处理添加用户请求
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/input", method = RequestMethod.POST)
	public void input(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getSession().getAttribute("user") != null) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Access-Control-Allow-Origin", url);
			response.setHeader("Access-Control-Allow-Credentials", "true");
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			String nickname = request.getParameter("nickname");
			if(username == null || username.equals("") || password == null || password.equals("") || nickname == null || nickname.equals("")) {
				out.print("failure");
			}else {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setNickname(nickname);
				user.setRole(Integer.parseInt(role));
				user.setTitle("default.jpg");
				int result = userService.save(user);
				if (result == 1) {
					out.print("ok");
				} else {
					out.print("failure");
				}
			}
		}
	}

	/**
	 * 处理修改用户请求
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getSession().getAttribute("user") != null) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Access-Control-Allow-Origin", url);
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Content-Type", "application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String role = request.getParameter("role");
			String userId = request.getParameter("userId");
			User user = userService.findById(Integer.parseInt(userId));
			user.setPassword(MD5.md5Password(password));
			user.setNickname(nickname);
			int state = userService.update(user);
			if (state == 1) {
				List<User> list = userService.listByNickname("", Integer.parseInt(role));
				JSONArray result = new JSONArray();
				for (User u : list) {
					JSONObject userJson = new JSONObject();
					userJson.put("id", u.getId());
					userJson.put("username", u.getUsername());
					userJson.put("password", u.getPassword());
					userJson.put("role", u.getRole());
					userJson.put("nickname", u.getNickname());
					result.add(userJson);
				}
				out.print(result.toString());
			} else {}
		}
	}

	/**
	 * 处理查询用户请求
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/list", method = RequestMethod.POST)
	public void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getSession().getAttribute("user") != null) {
			request.setCharacterEncoding("utf-8");
			response.setHeader("Access-Control-Allow-Origin", url);
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Content-Type", "application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			String role = request.getParameter("role");
			String nickname = request.getParameter("username");
			List<User> list = userService.listByNickname(nickname, Integer.parseInt(role.equals("") ? "0" : role));
			JSONArray result = new JSONArray();
			for (User user : list) {
				JSONObject userJson = new JSONObject();
				userJson.put("id", user.getId());
				userJson.put("username", user.getUsername());
				userJson.put("password", user.getPassword());
				userJson.put("role", user.getRole());
				userJson.put("nickname", user.getNickname());
				result.add(userJson);
			}
			out.print(result.toString());
		}
	}

	/**
	 * 处理删除用户请求
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getSession().getAttribute("user") != null) {
			request.setCharacterEncoding("utf-8");
			response.setHeader("Access-Control-Allow-Origin", url);
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Content-Type", "application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			String id = request.getParameter("userId");
			String role = request.getParameter("role");
			int state = userService.delete(Integer.parseInt(id));
			if (state == 1) {
				List<User> list = userService.listByNickname("", Integer.parseInt(role));
				JSONArray result = new JSONArray();
				for (User user : list) {
					JSONObject userJson = new JSONObject();
					userJson.put("id", user.getId());
					userJson.put("username", user.getUsername());
					userJson.put("password", user.getPassword());
					userJson.put("role", user.getRole());
					userJson.put("nickname", user.getNickname());
					result.add(user);
				}
				out.print(result.toString());
			}
		}
	}
}
