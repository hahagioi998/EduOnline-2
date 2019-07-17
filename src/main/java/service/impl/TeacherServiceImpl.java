package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.ITeacherDao;
import entity.Teacher;
import service.inter.ITeacherService;

@Component("teacherService")
public class TeacherServiceImpl implements ITeacherService{
	
	@Autowired
	@Qualifier("teacherDao")
	ITeacherDao teacherDao;
	
	@Override
	public int save(Teacher teacher) {
		
		int flag = 0;
		try {
			teacherDao.insert(teacher);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Teacher teacher) {
		int flag = 0;
		try{
			teacherDao.update(teacher);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int delete(int id) {
		int flag = 0;
		try{
			teacherDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<Teacher> list() {
		
		return teacherDao.list();
	}



}
