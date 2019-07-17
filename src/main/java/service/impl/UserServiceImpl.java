package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IUserDao;
import entity.User;
import service.inter.IUserService;

@Component("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	@Qualifier("userDao")
	IUserDao userDao;
	
	@Override
	public int save(User user) {
		
		int flag = 0;
		try {
			userDao.insert(user);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int update(User user) {
		int flag = 0;
		try{
			userDao.update(user);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int delete(int id) {
		int flag = 0;
		try{
			userDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}


	@Override
	public User login(String username,String password,int role) {
		User user = null;
		try {
			user = userDao.loadByUsername(username);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		String pwd = user.getPassword();
		int r = user.getRole();
		if(password.equals(pwd) && r == role) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public List<User> list() {
		
		return userDao.list();
	}

	@Override
	public List<User> listByRole(int role) {
		List<User> users = userDao.list();
		List<User> users1 = null;
		List<User> users2 = null;
		List<User> users3 = null;
		for(int i=0;i<users.size();i++){
			if(users.get(i).getRole()==1){
				users1.add(users.get(i));
			}else if(users.get(i).getRole()==2){
				users2.add(users.get(i));
			}else if(users.get(i).getRole()==3){
				users3.add(users.get(i));
			}
		}
		if(role == 1){
			return users1;						//users1表示管理员列表
		}
		if(role == 2){							
			return users2;						//users2代表教师列表
		}	
		if(role == 3){
			return users3;						//users3代表学生列表
		}else{
			return users;						//users代表所有列表
		}
		
	}

	@Override
	public List<User> listByNickname(String nickname, int role) {
		String[] split = nickname.split(" ");
		if(split.length == 1) {
			List<User> users = new ArrayList<User>();
			List<User> list = userDao.listLikeNickname(nickname);
			for(User user : list) {
				if(user.getRole() == role) {
					users.add(user);
				}
			}
			return users;
		}else {
			System.out.println("sql注入");
		}
		return null;
		
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		User user = userDao.load(id);
		return user;
	}

}
