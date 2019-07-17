package dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.ICourseDao;
import entity.Course;

@Repository
@Component("courseDao")
public class CourseDaoImpl extends BaseDaoImpl<Course> implements ICourseDao {

	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jt;
	
	@Override
	public List<Course> listByParentId(int parentId) {
		// TODO Auto-generated method stub
		sql = "select * from t_course where parent_id = ?";
		return jt.query(sql, new Object[] {parentId},new BeanPropertyRowMapper<Course>(Course.class));
	}

	@Override
	public void saveMore(List<Course> list) {
		// TODO Auto-generated method stub
		sql = "insert into t_course (name,parent_id,sign,description) values (?,?,?,?)";
		jt.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				Course course = list.get(i);
				ps.setString(1, course.getName());
				ps.setInt(2, course.getParentId());
				ps.setInt(3, course.getSign());
				ps.setString(4, course.getDescription());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
	}

}
