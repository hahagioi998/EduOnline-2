package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IScoreDao;
import entity.Score;
import service.inter.IScoreService;

@Component("scoreService")
public class ScoreServiceImpl implements IScoreService{
	
	@Autowired
	@Qualifier("scoreDao")
	IScoreDao scoreDao;
	
	@Override
	public int save(Score score) {
		
		int flag = 0;
		try {
			scoreDao.insert(score);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Score score) {
		int flag = 0;
		try{
			scoreDao.update(score);
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
			scoreDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<Score> list() {
		
		return scoreDao.list();
	}

}
