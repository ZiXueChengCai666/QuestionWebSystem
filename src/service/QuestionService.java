package service;

import dao.MyQuestionDao;
import domain.MyQuestion;

import java.util.ArrayList;

public class QuestionService {

    private MyQuestionDao myQuestionDao = new MyQuestionDao();

    public ArrayList<Integer> SearchMyQuestionList(){
        return myQuestionDao.findQuestionIdList();
    }

    public MyQuestion SearchMyQuestion(int id){
        return myQuestionDao.findQuestion(id);
    }

    public void addMyQuestion(MyQuestion myQuestion){
        myQuestionDao.addQuestion(myQuestion);
    }

    public void deleteQuestion(int id){
        myQuestionDao.deleteQuestion(id);
    }

    public void updateQuestion(int op,int questionId, String value){
        myQuestionDao.updateQuestion(op,questionId,value);
    }

    public boolean CheckQuestion(int questionId,String userAnswer){
        return myQuestionDao.findQuestion(questionId).getAnswer_correct().equals(userAnswer);
    }

    public ArrayList<MyQuestion> selectQuestion(String string){
        return myQuestionDao.selectQuestion(string);
    }

}
