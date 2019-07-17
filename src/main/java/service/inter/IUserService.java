package service.inter;

import java.util.List;

import entity.User;

public interface IUserService {

	/**
	 * 处理用户登录
	 * @param username
	 * @return
	 */
	public User login(String username, String password, int role);
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	public int save(User user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int update(User user);
	/**
	 * 获取全部用户信息
	 * @return
	 */
	public List<User> list();
	/** 
	 * 通过角色获取指定角色的全部用户
	 * @return
	 */
	public List<User> listByRole(int role);
	/**
	 * 通过用户名和角色来模糊查询
	 * @param nickname
	 * @param role
	 * @return
	 */
	public List<User> listByNickname(String nickname, int role);
	/**
	 * 通过id查找用户
	 * @param id
	 * @return
	 */
	public User findById(int id);
}
