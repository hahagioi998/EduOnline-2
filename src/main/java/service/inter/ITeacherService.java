package service.inter;

import java.util.List;

import entity.Teacher;

public interface ITeacherService {

	/**
	 * 添加课程/章/节/知识点
	 * @param teacher
	 * @return
	 */
	public int save(Teacher teacher);
	/**
	 * 修改课程信息
	 * @param teacher
	 * @return
	 */
	public int update(Teacher teacher);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);

	
	public List<Teacher> list();
}
