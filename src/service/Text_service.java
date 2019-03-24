package service;

import domain.MyQuestion;

public class Text_service {

    MyQuestion myQuestion = new MyQuestion();
    QuestionService questionService = new QuestionService();
    public void add(){
        myQuestion.setQuestion_name("123456?");
        myQuestion.setAnswer_A("AAAA");
        myQuestion.setAnswer_B("BBBB");
        myQuestion.setAnswer_C("CCCC");
        myQuestion.setAnswer_D("DDDD");
        myQuestion.setAnswer_correct("B");
        questionService.addMyQuestion(myQuestion);
    }
    public void delete(){
        questionService.deleteQuestion(9);
    }

    public void update(){
        questionService.updateQuestion(1,10,"7777");
    }
}
