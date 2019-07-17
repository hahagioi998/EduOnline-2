package service.inter;

import java.util.List;

import entity.Classes;

public interface IClassesService {

	/**
	 * 注册班级
	 * @param classes
	 * @return
	 */
	public int save(Classes classes);
	/**
	 * 修改班级信息
	 * @param classes
	 * @return
	 */
	public int update(Classes classes);
	/**
	 * 注销班级
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 根据父ID获取全部子项
	 * @param parentId
	 * @return
	 */
	public List<Classes> listByParentId(int parentId);
	
}
