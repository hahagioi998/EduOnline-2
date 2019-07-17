package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IStudentDao;
import entity.Student;

@Repository
@Component("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements IStudentDao {

}
