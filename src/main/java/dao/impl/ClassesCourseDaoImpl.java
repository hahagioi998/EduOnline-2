package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IClassesCourseDao;
import entity.ClassesCourse;

@Repository
@Component("classesCourseDao")
public class ClassesCourseDaoImpl extends BaseDaoImpl<ClassesCourse> implements IClassesCourseDao {

}
