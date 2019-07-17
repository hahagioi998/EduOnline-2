package dao.inter;

import entity.dto.TeacherDTO;

public interface ITeacherDTODao {

	public TeacherDTO loadByTeacherId(int teacherId);
}
