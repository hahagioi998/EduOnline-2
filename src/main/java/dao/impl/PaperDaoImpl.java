package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IPaperDao;
import entity.Paper;

@Repository
@Component("paperDao")
public class PaperDaoImpl extends BaseDaoImpl<Paper> implements IPaperDao {

}
