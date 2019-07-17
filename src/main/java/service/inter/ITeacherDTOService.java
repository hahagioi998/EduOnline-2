package service.inter;

import java.util.List;

import entity.dto.TeacherDTO;

public interface ITeacherDTOService {

	/**
	 * 添加课程/章/节/知识点
	 * @param teacherDTO
	 * @return
	 */
	public int save(TeacherDTO teacherDTO);
	/**
	 * 修改课程信息
	 * @param teacherDTO
	 * @return
	 */
	public int update(TeacherDTO teacherDTO);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);


	public List<TeacherDTO> list();
	
	public TeacherDTO loadByTeacherId(int TeacherId);
}
