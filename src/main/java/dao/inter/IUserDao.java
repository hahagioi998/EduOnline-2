package dao.inter;

import java.util.List;

import entity.User;

public interface IUserDao extends IBaseDao<User> {
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);
	
	/**
	 * 根据用户昵称进行模糊查询
	 * @param nickname
	 * @return
	 */
	public List<User> listLikeNickname(String nickname);
}
