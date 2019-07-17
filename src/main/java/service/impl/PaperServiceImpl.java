package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.inter.IPaperDao;
import entity.Paper;
import service.inter.IPaperService;

@Component("paperService")
public class PaperServiceImpl implements IPaperService{
	
	@Autowired
	@Qualifier("paperDao")
	IPaperDao paperDao;
	
	@Override
	public int save(Paper paper) {
		
		int flag = 0;
		try {
			paperDao.insert(paper);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Paper paper) {
		int flag = 0;
		try{
			paperDao.update(paper);
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
			paperDao.delete(id);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<Paper> list() {
		
		return paperDao.list();
	}

}
