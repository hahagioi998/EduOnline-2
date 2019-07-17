package service.inter;

import java.util.List;

import entity.PaperQuestion;

public interface IPaperQuestionService {

	/**
	 * 添加课程/章/节/知识点
	 * @param paperQuestion
	 * @return
	 */
	public int save(PaperQuestion paperQuestion);
	/**
	 * 修改课程信息
	 * @param paperQuestion
	 * @return
	 */
	public int update(PaperQuestion paperQuestion);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	public List<PaperQuestion> list();
	
}
