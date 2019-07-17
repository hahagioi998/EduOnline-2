package service.inter;

import java.util.List;

import entity.ClassesCourse;

public interface IClassesCourseService {
	
	
	public int save(ClassesCourse classesCourse);
	
	
	public int update(ClassesCourse classesCourse);
	
	
	public int delete(int id);
	
	public List<ClassesCourse> list();
	
}
