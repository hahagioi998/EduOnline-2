package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/question")
public class QuestionController {

	/**
	 * 处理创建试题需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/question/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理修改试题需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/question/update")
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理删除试题需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/question/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理获得试题列表需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/question/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
}
