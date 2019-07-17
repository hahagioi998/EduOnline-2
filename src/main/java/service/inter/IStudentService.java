package service.inter;

import java.util.List;

import entity.Student;

public interface IStudentService {

	/**
	 * 添加课程/章/节/知识点
	 * @param student
	 * @return
	 */
	public int save(Student student);
	/**
	 * 修改课程信息
	 * @param student
	 * @return
	 */
	public int update(Student student);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	
	public List<Student> list();
	
}
