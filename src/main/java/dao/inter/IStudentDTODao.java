package dao.inter;

import entity.dto.StudentDTO;

public interface IStudentDTODao {

	public StudentDTO loadByStudentId(int studentId);
}
