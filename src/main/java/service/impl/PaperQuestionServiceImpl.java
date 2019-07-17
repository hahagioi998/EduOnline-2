package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IPaperQuestionDao;
import entity.PaperQuestion;
import service.inter.IPaperQuestionService;

@Component("paperQuestionService")
public class PaperQuestionServiceImpl implements IPaperQuestionService{
	
	@Autowired
	@Qualifier("paperQuestionDao")
	IPaperQuestionDao paperQuestionDao;
	
	@Override
	public int save(PaperQuestion paperQuestion) {
		
		int flag = 0;
		try {
			paperQuestionDao.insert(paperQuestion);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(PaperQuestion paperQuestion) {
		int flag = 0;
		try{
			paperQuestionDao.update(paperQuestion);
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
			paperQuestionDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<PaperQuestion> list() {
		
		return paperQuestionDao.list();
	}

	
}
