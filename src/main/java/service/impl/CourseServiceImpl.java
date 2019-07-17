package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.ICourseDao;
import entity.Course;
import service.inter.ICourseService;

@Component("courseService")
public class CourseServiceImpl implements ICourseService{
	
	@Autowired
	@Qualifier("courseDao")
	ICourseDao courseDao;
	
	@Override
	public int save(Course course) {
		
		int flag = 0;
		try {
			courseDao.insert(course);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Course course) {
		int flag = 0;
		try{
			courseDao.update(course);
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
			courseDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<Course> listByParentId(int parentId) {
	
		return courseDao.listByParentId(parentId);
	}

	@Override
	public List<Course> listBysign(int sign) {
		List<Course> listAll = courseDao.list();
		List<Course> list = new ArrayList<Course>();
		for(Course course : listAll) {
			if(course.getSign() == sign) {
				list.add(course);
			}
		}
		return list;
	}

	@Override
	public int saveMore(List<Course> list) {
		int resoult = 0;
		
		try {
			courseDao.saveMore(list);
			resoult = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resoult;
	}
	
}
