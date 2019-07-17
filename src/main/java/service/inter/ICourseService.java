package service.inter;

import java.util.List;

import entity.Course;

public interface ICourseService {

	/**
	 * 添加课程/章/节/知识点
	 * @param course
	 * @return
	 */
	public int save(Course course);
	/**
	 * 修改课程信息
	 * @param course
	 * @return
	 */
	public int update(Course course);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 根据父ID获取子项列表
	 * @param parentId
	 * @return
	 */
	public List<Course> listByParentId(int parentId);
	/**
	 * 根据sign获取列表
	 * @param sign
	 * @return
	 */
	public List<Course> listBysign(int sign);
	/**
	 * 批量添加
	 * @param list
	 */
	public int saveMore(List<Course> list);
}
