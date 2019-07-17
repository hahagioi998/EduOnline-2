package service.inter;

import java.util.List;

import entity.Test;

public interface ITestService {

	/**
	 * 添加课程/章/节/知识点
	 * @param test
	 * @return
	 */
	public int save(Test test);
	/**
	 * 修改课程信息
	 * @param test
	 * @return
	 */
	public int update(Test test);
	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	public int delete(int id);

	
	public List<Test> list();
}
