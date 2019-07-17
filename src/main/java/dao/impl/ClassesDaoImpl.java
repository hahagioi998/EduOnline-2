package dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IClassesDao;
import entity.Classes;

@Repository
@Component("classesDao")
public class ClassesDaoImpl extends BaseDaoImpl<Classes> implements IClassesDao {

	@Override
	public List<Classes> listByParentId(int praentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
