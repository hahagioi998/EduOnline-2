package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/test")
public class TestController {

	/**
	 * 处理创建测试需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理修改测试需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test/update")
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理删除测试需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理获得测试列表需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
}
