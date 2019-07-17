package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IClassesCourseDao;
import entity.ClassesCourse;
import service.inter.IClassesCourseService;

@Component("classesCourseService")
public class ClassesCourseServiceImpl implements IClassesCourseService{
	
	@Autowired
	@Qualifier("classesCourseDao")
	IClassesCourseDao classesCourseDao;
	
	@Override
	public int save(ClassesCourse classesCourse) {
		
		int flag = 0;
		try {
			classesCourseDao.insert(classesCourse);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(ClassesCourse classesCourse) {
		int flag = 0;
		try{
			classesCourseDao.update(classesCourse);
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
			classesCourseDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<ClassesCourse> list() {
		
		return classesCourseDao.list();
	}
	
}
