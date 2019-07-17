package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.inter.IClassesCourseService;

@Controller("/classes")
public class ClassesController {
	
	@Autowired
	@Qualifier("classesCourseService")
	private IClassesCourseService classesCourseService;
	@Autowired
	@Qualifier("systemUrl")
	private String url = "127.0.0.1:8848";
	
	/**
	 * 处理创建课程需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/classes/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理修改课程需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/classes/update")
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理删除课程需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/classes/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理获得课程列表需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/classes/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
