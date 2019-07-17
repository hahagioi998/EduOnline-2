package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.ITeacherDao;
import entity.Teacher;

@Repository
@Component("teacherDao")
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements ITeacherDao {

	
}
