package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.ITestDao;
import entity.Test;

@Repository
@Component("testDao")
public class TestDaoImpl extends BaseDaoImpl<Test> implements ITestDao {

}
