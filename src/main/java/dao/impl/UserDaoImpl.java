package dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IUserDao;
import entity.User;

@Repository
@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{

	@Override
	public User loadByUsername(String username) {
		sql = "select * from t_user where username = ?";
		return jt.queryForObject(sql, new Object[] {username}, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> listLikeNickname(String nickname) {
		sql = "select * from t_user where nickname like '%"+nickname+"%'";
		return jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

}
