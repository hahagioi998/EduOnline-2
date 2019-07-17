package service.inter;

import java.util.List;

import entity.Paper;

public interface IPaperService {

	/**
	 * 添加试卷
	 * @param paper
	 * @return
	 */
	public int save(Paper paper);
	/**
	 * 修改试卷信息
	 * @param paper
	 * @return
	 */
	public int update(Paper paper);
	/**
	 * 删除试卷
	 * @param id
	 * @return
	 */
	public int delete(int id);

	public List<Paper> list();
}
