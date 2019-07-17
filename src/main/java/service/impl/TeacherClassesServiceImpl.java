package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.ITeacherClassesDao;
import entity.TeacherClasses;
import service.inter.ITeacherClassesService;

@Component("teacherClassesService")
public class TeacherClassesServiceImpl implements ITeacherClassesService{
	
	@Autowired
	@Qualifier("teacherClassesDao")
	ITeacherClassesDao teacherClassesDao;
	
	@Override
	public int save(TeacherClasses teacherClasses) {
		
		int flag = 0;
		try {
			teacherClassesDao.insert(teacherClasses);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(TeacherClasses teacherClasses) {
		int flag = 0;
		try{
			teacherClassesDao.update(teacherClasses);
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
			teacherClassesDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<TeacherClasses> list() {
		
		return teacherClassesDao.list();
	}

}
