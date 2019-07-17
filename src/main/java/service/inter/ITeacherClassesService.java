package service.inter;

import java.util.List;

import entity.TeacherClasses;

public interface ITeacherClassesService {

	/**
	 * 添加课程/章/节/知识点
	 * @param teacherClasses
	 * @return
	 */
	public int save(TeacherClasses teacherClasses);
	/**
	 * 修改课程信息
	 * @param teacherClasses
	 * @return
	 */
	public int update(TeacherClasses teacherClasses);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	
	public List<TeacherClasses> list();
}
