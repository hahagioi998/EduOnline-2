package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dao.inter.IQuestionDao;
import entity.Question;

@Repository
@Component("questionDao")
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements IQuestionDao {

}
