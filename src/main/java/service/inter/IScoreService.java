package service.inter;

import java.util.List;

import entity.Score;

public interface IScoreService {

	/**
	 * 添加课程/章/节/知识点
	 * @param score
	 * @return
	 */
	public int save(Score score);
	/**
	 * 修改课程信息
	 * @param score
	 * @return
	 */
	public int update(Score score);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);

	
	public List<Score> list();
}
