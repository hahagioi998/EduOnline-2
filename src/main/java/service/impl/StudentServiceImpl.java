package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IStudentDao;
import entity.Student;
import service.inter.IStudentService;

@Component("studentService")
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	@Qualifier("studentDao")
	IStudentDao studentDao;
	
	@Override
	public int save(Student student) {
		
		int flag = 0;
		try {
			studentDao.insert(student);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Student student) {
		int flag = 0;
		try{
			studentDao.update(student);
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
			studentDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<Student> list() {
		
		return studentDao.list();
	}

	
}
