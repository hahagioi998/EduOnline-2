package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.ITestDao;
import entity.Test;
import service.inter.ITestService;

@Component("testService")
public class TestServiceImpl implements ITestService{
	
	@Autowired
	@Qualifier("testDao")
	ITestDao testDao;
	
	@Override
	public int save(Test test) {
		
		int flag = 0;
		try {
			testDao.insert(test);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Test test) {
		int flag = 0;
		try{
			testDao.update(test);
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
			testDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<Test> list() {
		
		return testDao.list();
	}

}
