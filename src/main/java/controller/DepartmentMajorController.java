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

import entity.DepartmentMajor;
import entity.dto.DepartmentMajorDTO;
import service.inter.IDepartmentMajorService;

@Controller("departmentMajor")
public class DepartmentMajorController {

	@Autowired
	@Qualifier("departmentMajorService")
	private IDepartmentMajorService departmentMajorService;
	
	@Autowired
	@Qualifier("systemUrl")
	private String url;

	/**
	 * 处理创建院系专业需求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/departmentMajor/insert", method = RequestMethod.POST)
	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String sign = request.getParameter("sign");
		String parentId = request.getParameter("parentId");
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		if (number == null || number.equals("") || name == null || name.equals("")) {
			out.print("failure");
		} else {
			DepartmentMajor departmentMajor = new DepartmentMajor();
			departmentMajor.setName(name);
			departmentMajor.setNumber(number);
			departmentMajor.setSign(Integer.parseInt(sign));
			departmentMajor.setParentId(Integer.parseInt(parentId));
			int result = departmentMajorService.save(departmentMajor);
			if (result == 1) {
				out.print("ok");
			} else {
				out.print("failure");
			}
		}
	}

	/**
	 * 处理修改院系专业需求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/departmentMajor/update", method = RequestMethod.POST)
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		int sign = Integer.parseInt(request.getParameter("sign"));
		String name = request.getParameter("name");
		int state = departmentMajorService.update(id, name);
		if (state == 1) {
			List<DepartmentMajorDTO> list = departmentMajorService.listLikeName("");
			JSONArray result = toJsonDTO(list, sign);
			out.print(result.toString());
		}
	}

	/**
	 * 处理删除院系专业需求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/departmentMajor/delete", method = RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		int sign = Integer.parseInt(request.getParameter("sign"));
		int state = departmentMajorService.delete(id);
		if (state == 1) {
			List<DepartmentMajorDTO> list = departmentMajorService.listLikeName("");
			JSONArray result = toJsonDTO(list, sign);
			out.print(result.toString());
		}
	}

	/**
	 * 处理获得院系专业列表需求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/departmentMajor/list", method = RequestMethod.POST)
	public void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		int sign = Integer.parseInt(request.getParameter("sign"));
		List<DepartmentMajorDTO> list = departmentMajorService.listLikeName(name);
		JSONArray result = toJsonDTO(list, sign);
		out.print(result.toString());
	}

	/**
	 * 处理根据父ID获得子ID列表需求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/departmentMajor/listByParentId", method = RequestMethod.POST)
	public void listByParentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String parentId = request.getParameter("parentId");
		List<DepartmentMajor> list = departmentMajorService.listByParentId(Integer.parseInt(parentId));
		JSONArray result = toJson(list);
		out.print(result.toString());
	}

	/**
	 * 处理根据标记类型获得院系列表的请求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/departmentMajor/listBySign", method = RequestMethod.POST)
	public void listBySign(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String sign = request.getParameter("sign");
		List<DepartmentMajor> list = departmentMajorService.listBySign(Integer.parseInt(sign));
		JSONArray result = toJson(list);
		out.print(result.toString());
	}

	/**
	 * 将生成结果转换成JSON格式
	 * 
	 * @param list
	 * @return
	 */
	private JSONArray toJson(List<DepartmentMajor> list) {
		JSONArray result = new JSONArray();
		for (DepartmentMajor departmentMajor : list) {
			JSONObject departmentMajorJson = new JSONObject();
			departmentMajorJson.put("id", departmentMajor.getId());
			departmentMajorJson.put("name", departmentMajor.getName());
			departmentMajorJson.put("number", departmentMajor.getNumber());
			departmentMajorJson.put("parentId", departmentMajor.getParentId());
			departmentMajorJson.put("sign", departmentMajor.getSign());
			result.add(departmentMajorJson);
		}
		return result;
	}

	/**
	 * 将生成结果转换成JSON格式
	 * 
	 * @param list
	 * @return
	 */
	private JSONArray toJsonDTO(List<DepartmentMajorDTO> list, int sign) {
		JSONArray result = new JSONArray();
		for (DepartmentMajorDTO departmentMajor : list) {
			if (sign == departmentMajor.getSign()) {
				JSONObject departmentMajorJson = new JSONObject();
				departmentMajorJson.put("id", departmentMajor.getId());
				departmentMajorJson.put("name", departmentMajor.getName());
				departmentMajorJson.put("number", departmentMajor.getNumber());
				departmentMajorJson.put("parentName",
						departmentMajor.getParentName() == null ? "无" : departmentMajor.getParentName());
				departmentMajorJson.put("sign", departmentMajor.getSign());
				result.add(departmentMajorJson);
			}
		}
		return result;
	}
}
