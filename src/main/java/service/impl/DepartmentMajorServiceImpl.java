package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IDepartmentMajorDao;
import entity.DepartmentMajor;
import entity.dto.DepartmentMajorDTO;
import service.inter.IDepartmentMajorService;

@Component("departmentMajorService")
public class DepartmentMajorServiceImpl implements IDepartmentMajorService{
	
	@Autowired
	@Qualifier("departmentMajorDao")
	IDepartmentMajorDao departmentMajorDao;
	
	@Override
	public int save(DepartmentMajor departmentMajor) {
		
		int flag = 0;
		try {
			departmentMajorDao.insert(departmentMajor);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int update(int id, String name) {
		int flag = 0;
		try{
			DepartmentMajor departmentMajor = departmentMajorDao.load(id);
			departmentMajor.setName(name);
			departmentMajorDao.update(departmentMajor);
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
			departmentMajorDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<DepartmentMajor> listByParentId(int parentId) {
		return departmentMajorDao.listByParentId(parentId);
	}

	@Override
	public List<DepartmentMajor> listBySign(int sign) {
		return departmentMajorDao.listBySign(sign);
	}

	@Override
	public List<DepartmentMajorDTO> listLikeName(String name) {
		// TODO Auto-generated method stub
		String[] split = name.split(" ");
		if(split.length == 1) {
			return departmentMajorDao.listLikeName(name);
		}else {
			System.out.println("sql注入");
		}
		return null;
	}

	@Override
	public DepartmentMajorDTO loadById(int id) {
		// TODO Auto-generated method stub
		return departmentMajorDao.loadById(id);
	}
	
}
