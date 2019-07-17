package dao.inter;

import java.util.List;

import entity.Course;

public interface ICourseDao extends IBaseDao<Course> {

	/**
	 * 根据父ID查找全部的子项
	 * @param parentId
	 * @return
	 */
	public List<Course> listByParentId(int parentId);
	/**
	 * 批量添加
	 * @param list
	 */
	public void saveMore(List<Course> list);
}
