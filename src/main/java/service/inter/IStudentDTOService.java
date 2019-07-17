package service.inter;

import java.util.List;

import entity.dto.StudentDTO;

public interface IStudentDTOService {

	/**
	 * 添加课程/章/节/知识点
	 * @param course
	 * @return
	 */
	public int save(StudentDTO studentDTO);
	/**
	 * 修改课程信息
	 * @param course
	 * @return
	 */
	public int update(StudentDTO studentDTO);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 根据父ID获取子项列表
	 * @param parentId
	 * @return
	 */
	public List<StudentDTO> list();
	
	
	public StudentDTO loadByStudentId(int studentId);
}
