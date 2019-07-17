package dao.inter;

import java.util.List;

/**
 * 基础dao接口
 * @author SongPengJie
 *
 * @param <T>
 */
public interface IBaseDao<T> {

	/**
	 * 添加
	 * @param t
	 */
	public void insert(T t);
	/**
	 * 修改
	 * @param t
	 */
	public void update(T t);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 */
	public T load(int id);
	/**
	 * 获取全部列表
	 * @return
	 */
	public List<T> list();
}
