package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IScoreDao;
import entity.Score;

@Repository
@Component("scoreDao")
public class ScoreDaoImpl extends BaseDaoImpl<Score> implements IScoreDao {

}
