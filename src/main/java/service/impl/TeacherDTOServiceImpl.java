package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.ITeacherDTODao;
import entity.dto.TeacherDTO;
import service.inter.ITeacherDTOService;

@Component("teacherDTOService")
public class TeacherDTOServiceImpl implements ITeacherDTOService{
	
	@Autowired
	@Qualifier("teacherDTODao")
	ITeacherDTODao teacherDTODao;
	
	@Override
	public int save(TeacherDTO teacherDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TeacherDTO teacherDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public TeacherDTO loadByTeacherId(int TeacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeacherDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
