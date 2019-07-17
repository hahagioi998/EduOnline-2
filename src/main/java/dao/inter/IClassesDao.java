package dao.inter;

import java.util.List;

import entity.Classes;

public interface IClassesDao extends IBaseDao<Classes> {

	/**
	 * 根据父ID查找全部的子项
	 * @param praentId
	 * @return
	 */
	public List<Classes> listByParentId(int praentId);
}
