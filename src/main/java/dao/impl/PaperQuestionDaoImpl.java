package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IPaperQuestionDao;
import entity.PaperQuestion;

@Repository
@Component("paperQuestionDao")
public class PaperQuestionDaoImpl extends BaseDaoImpl<PaperQuestion> implements IPaperQuestionDao {

}
