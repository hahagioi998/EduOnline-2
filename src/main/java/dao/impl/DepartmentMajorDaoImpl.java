package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IDepartmentMajorDao;
import entity.DepartmentMajor;
import entity.dto.DepartmentMajorDTO;

@Repository
@Component("departmentMajorDao")
public class DepartmentMajorDaoImpl extends BaseDaoImpl<DepartmentMajor> implements IDepartmentMajorDao {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jt;
	
	@Override
	public List<DepartmentMajor> listByParentId(int parentId) {
		sql = "select * from t_department_major where parent_id = ?";
		return jt.query(sql, new Object[] {parentId}, new BeanPropertyRowMapper<DepartmentMajor>(DepartmentMajor.class));
	}

	@Override
	public List<DepartmentMajor> listBySign(int sign) {
		sql = "select * from t_department_major where sign = ?";
		return jt.query(sql, new Object[] {sign}, new BeanPropertyRowMapper<DepartmentMajor>(DepartmentMajor.class));
	}

	@Override
	public List<DepartmentMajorDTO> listLikeName(String name) {
		sql = "SELECT t1.id AS id, t1.number AS number, t1.`name` AS NAME, t2. NAME AS parent_name, t1.sign AS sign FROM t_department_major t1 LEFT JOIN t_department_major t2 ON t1.parent_id = t2.id WHERE t1.`name` LIKE '%"+name+"%'";
		return jt.query(sql, new BeanPropertyRowMapper<DepartmentMajorDTO>(DepartmentMajorDTO.class));
	}

	@Override
	public DepartmentMajorDTO loadById(int id) {
		// TODO Auto-generated method stub
		sql = "SELECT t1.id AS id, t1.number AS number, t1.`name` AS NAME, t2. NAME AS parent_name, t1.sign AS sign FROM t_department_major t1 LEFT JOIN t_department_major t2 ON t1.parent_id = t2.id WHERE t1.id = ?";
		return jt.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<DepartmentMajorDTO>(DepartmentMajorDTO.class));
	}

}
