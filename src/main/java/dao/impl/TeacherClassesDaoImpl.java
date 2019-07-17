package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.ITeacherClassesDao;
import entity.TeacherClasses;

@Repository
@Component("teacherClassesDao")
public class TeacherClassesDaoImpl extends BaseDaoImpl<TeacherClasses> implements ITeacherClassesDao {

}
