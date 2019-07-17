package service.inter;

import java.util.List;

import entity.DepartmentMajor;
import entity.dto.DepartmentMajorDTO;

public interface IDepartmentMajorService {

	/**
	 * 保存院系/专业
	 * @param departmentMajor
	 * @return
	 */
	public int save(DepartmentMajor departmentMajor);
	/**
	 * 修改院系/专业的信息
	 * @param departmentMajor
	 * @return
	 */
	public int update(int id, String name);
	/**
	 * 取消院系/专业
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 根据选择的父ID获取指定的子列表
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
