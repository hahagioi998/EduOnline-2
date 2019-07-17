package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IStudentDTODao;
import entity.dto.StudentDTO;

@Repository
@Component("studentDTODao")
public class StudentDTODaoImpl implements IStudentDTODao {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jt;
	private String sql = null;
	
	@Override
	public StudentDTO loadByStudentId(int studentId) {
		sql = "SELECT student.id AS student_id, USER .nickname AS nickname FROM t_student AS student LEFT JOIN t_user AS USER ON student.user_id = USER .id WHERE student.id = ?";
		return jt.queryForObject(sql, new Object[] {studentId},new BeanPropertyRowMapper<StudentDTO>(StudentDTO.class));
	}

}
