package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.ITeacherDTODao;
import entity.dto.TeacherDTO;

@Repository
@Component("teacherDTODao")
public class TeacherDTODaoImpl implements ITeacherDTODao {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jt;
	private String sql = null;
	
	@Override
	public TeacherDTO loadByTeacherId(int teacherId) {
		sql = "SELECT teacher.id AS teacher_id, USER .nickname AS nickname FROM t_teacher AS teacher LEFT JOIN t_user AS USER ON teacher.user_id = USER .id WHERE teacher.id = ?";
		return jt.queryForObject(sql, new Object[] {teacherId},new BeanPropertyRowMapper<TeacherDTO>(TeacherDTO.class));
	}

}
