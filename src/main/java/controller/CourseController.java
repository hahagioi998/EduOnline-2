package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import entity.Course;
import service.inter.ICourseService;

@Controller("course")
public class CourseController {
	@Autowired
	@Qualifier("courseService")
	private ICourseService courseService;
	@Autowired
	@Qualifier("systemUrl")
	private String url;
	/**
	 * 处理创建课程需求
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/course/insert",method=RequestMethod.POST)
	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		int length = Integer.parseInt(request.getParameter("length"));
		int sign = Integer.parseInt(request.getParameter("sign"));
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		List<Course> courseList = new ArrayList<Course>();
		for(int i=1;i<=length;i++) {
			String tableData = request.getParameter("tableData"+i);
			String[] datas = tableData.split("_");
			Course course = new Course();
			course.setSign(sign);
			course.setParentId(parentId);
			course.setName(datas[0].substring(1, datas[0].length()));
			course.setDescription(datas[1].substring(0, datas[1].length()-1));
			courseList.add(course);
		}
		int state = courseService.saveMore(courseList);
		if(state == 1) {
			out.print("ok");
		}else {
			out.print("添加失败");
		}
	}
	
	/**
	 * 处理修改课程需求
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/course/update",method=RequestMethod.POST)
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
	}
	
	/**
	 * 处理删除课程需求
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/course/delete",method=RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
	}
	
	/**
	 * 处理获得课程列表需求
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/course/list",method=RequestMethod.POST)
	public void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
	}
	
	/**
	 * 根据父ID获取子列表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/course/listByFatherId",method=RequestMethod.POST)
	public void listByFatherId(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		List<Course> list = courseService.listByParentId(parentId);
		JSONArray result = toJson(list);
		out.print(result.toString());
	}
	
	/**
	 * 根据sign（类型）获得列表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/course/listBySign",method=RequestMethod.POST)
	public void listBySign(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int sign = Integer.parseInt(request.getParameter("sign"));
		List<Course> list = courseService.listBysign(sign);
		JSONArray result = toJson(list);
		out.print(result.toString());
	}
	
	
	/**
	 * 将生成结果转换成JSON格式
	 * 
	 * @param list
	 * @return
	 */
	private JSONArray toJson(List<Course> list) {
		JSONArray result = new JSONArray();
		for (Course course : list) {
			JSONObject courseJson = new JSONObject();
			courseJson.put("id", course.getId());
			courseJson.put("name", course.getName());
			courseJson.put("parentId", course.getParentId());
			courseJson.put("sign", course.getSign());
			courseJson.put("description", course.getDescription());
			result.add(courseJson);
		}
		return result;
	}

	
	
	
	
}
