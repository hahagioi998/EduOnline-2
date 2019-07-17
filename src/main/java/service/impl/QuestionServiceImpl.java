package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IQuestionDao;
import entity.Question;
import service.inter.IQuestionService;

@Component("questionService")
public class QuestionServiceImpl implements IQuestionService{
	
	@Autowired
	@Qualifier("questionDao")
	IQuestionDao questionDao;
	
	@Override
	public int save(Question question) {
		
		int flag = 0;
		try {
			questionDao.insert(question);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Question question) {
		int flag = 0;
		try{
			questionDao.update(question);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int delete(int id) {
		int flag = 0;
		try{
			questionDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<Question> list() {
		
		return questionDao.list();
	}

}
