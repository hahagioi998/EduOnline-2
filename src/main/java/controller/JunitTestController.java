package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JunitTestController {

	@RequestMapping("/hello")
	public void hello(HttpServletRequest request, HttpServletResponse response) {
		String user = request.getParameter("user");
		System.out.println(user);
	}
}
