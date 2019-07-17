package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IStudentDTODao;
import entity.dto.StudentDTO;
import service.inter.IStudentDTOService;

@Component("studentDTOService")
public class StudentDTOServiceImpl implements IStudentDTOService{
	
	@Autowired
	@Qualifier("studentDTODao")
	IStudentDTODao studentDTODao;
	
	@Override
	public int save(StudentDTO studentDTO) {

		return 0;
	}

	@Override
	public int update(StudentDTO studentDTO) {

		return 0;
	}

	@Override
	public int delete(int id) {

		return 0;
	}


	@Override
	public StudentDTO loadByStudentId(int studentId) {
		
		return studentDTODao.loadByStudentId(studentId);
	}

	@Override
	public List<StudentDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
