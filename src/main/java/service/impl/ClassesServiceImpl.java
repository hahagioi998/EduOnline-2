package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IClassesDao;
import entity.Classes;
import service.inter.IClassesService;

@Component("classesService")
public class ClassesServiceImpl implements IClassesService{
	
	@Autowired
	@Qualifier("classesDao")
	IClassesDao classesDao;
	
	@Override
	public int save(Classes classes) {
		
		int flag = 0;
		try {
			classesDao.insert(classes);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Classes classes) {
		int flag = 0;
		try{
			classesDao.update(classes);
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
			classesDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}


	@Override
	public List<Classes> listByParentId(int parentId) {
		
		return classesDao.listByParentId(parentId);
	}
	
}
