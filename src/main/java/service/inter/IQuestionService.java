package service.inter;

import java.util.List;

import entity.Question;

public interface IQuestionService {

	/**
	 * 添加课程/章/节/知识点
	 * @param question
	 * @return
	 */
	public int save(Question question);
	/**
	 * 修改课程信息
	 * @param question
	 * @return
	 */
	public int update(Question question);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	public List<Question> list();
}
