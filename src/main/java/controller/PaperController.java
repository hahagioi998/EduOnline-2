package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/paper")
public class PaperController {

	/**
	 * 处理创建试卷需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/paper/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理修改试卷需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/paper/update")
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理删除试卷需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/paper/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	/**
	 * 处理获得试卷列表需求
	 * @param request
	 * @param response
	 */
	@RequestMapping("/paper/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
