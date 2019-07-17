package dao.inter;

import java.util.List;

import entity.DepartmentMajor;
import entity.dto.DepartmentMajorDTO;

public interface IDepartmentMajorDao extends IBaseDao<DepartmentMajor> {

	/**
	 * 根据父ID查找全部的子项
	 * @param parentId
	 * @return
	 */
	public List<DepartmentMajor> listByParentId(int parentId);
	/**
	 * 根据标记获取列表
	 * @param sign
	 * @return
	 */
	public List<DepartmentMajor> listBySign(int sign);
	/**
	 * 根据名字模糊查询
	 * @param name
	 * @return
	 */
	public List<DepartmentMajorDTO> listLikeName(String name);
	/**
	 * 根据ID查找信息
	 * @param id
	 * @return
	 */
	public DepartmentMajorDTO loadById(int id);
}
