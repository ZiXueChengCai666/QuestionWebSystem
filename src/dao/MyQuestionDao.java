package dao;

import domain.MyQuestion;
import util.Conn;

import java.sql.*;
import java.util.ArrayList;

public class MyQuestionDao {

    public MyQuestion findQuestion(int id){
        Connection connection = new Conn().getConnection();
        MyQuestion myQuestion = new MyQuestion();

        try{
            String select = "select * from question_info where question_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                myQuestion.setQuestion_id(id);
                myQuestion.setQuestion_name(resultSet.getString("question_name"));
                myQuestion.setAnswer_A(resultSet.getString("answer_A"));
                myQuestion.setAnswer_B(resultSet.getString("answer_B"));
                myQuestion.setAnswer_C(resultSet.getString("answer_C"));
                myQuestion.setAnswer_D(resultSet.getString("answer_D"));
                myQuestion.setAnswer_correct(resultSet.getString("answer_correct"));
            }
            connection.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
        return myQuestion;
    }

    public ArrayList<Integer> findQuestionIdList(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Connection connection = new Conn().getConnection();
        try{
            String select = "select question_id from question_info";
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int i = resultSet.getInt("question_id");
                arrayList.add(i);
            }

            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return arrayList;
    }

    public boolean addQuestion(MyQuestion myQuestion){
        Connection connection = new Conn().getConnection();
        try{
            String strSQL =  "INSERT INTO question_info(question_name,answer_A,answer_B,answer_C,answer_D,answer_correct) VALUES ('"
                    +myQuestion.getQuestion_name()+"','"
                    +myQuestion.getAnswer_A()+"','"
                    +myQuestion.getAnswer_B()+"','"
                    +myQuestion.getAnswer_C()+"','"
                    +myQuestion.getAnswer_D()+"','"
                    +myQuestion.getAnswer_correct()+"')";
            Statement statement = connection.createStatement();
            statement.execute(strSQL);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteQuestion(int id){
        Connection connection = new Conn().getConnection();
        try{
            String SQLstr = "delete from question_info where question_id =" + id;
            Statement statement = connection.createStatement();
            statement.execute(SQLstr);
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public void updateQuestion(int op, int questionId,String value){
        Connection connection = new Conn().getConnection();
        try{
            String SQLstr = null;
            switch (op) {
                case 1: SQLstr = "update question_info set question_name ='"+ value + "'where question_id =" + questionId ;break;
                case 2: SQLstr = "update question_info set answer_A ='"+ value + "'where question_id =" + questionId ;break;
                case 3: SQLstr = "update question_info set answer_B ='"+ value + "'where question_id =" + questionId ;break;
                case 4: SQLstr = "update question_info set answer_C ='"+ value + "'where question_id =" + questionId ;break;
                case 5: SQLstr = "update question_info set answer_D ='"+ value + "'where question_id =" + questionId ;break;
                case 6: SQLstr = "update question_info set answer_correct ='"+ value + "'where question_id =" + questionId ;break;

            }
            Statement statement = connection.createStatement();
            statement.execute(SQLstr);
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<MyQuestion> selectQuestion(String str) {
        Connection connection = new Conn().getConnection();
        MyQuestion myQuestion = null;
        ArrayList<MyQuestion> arrayList = new ArrayList<>();
        try {
            String select = "select * from question_info where question_name LIKE '%" + str + "%'";
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                myQuestion = new MyQuestion();
                myQuestion.setQuestion_id(resultSet.getInt("question_id"));
                myQuestion.setQuestion_name(resultSet.getString("question_name"));
                myQuestion.setAnswer_A(resultSet.getString("answer_A"));
                myQuestion.setAnswer_B(resultSet.getString("answer_B"));
                myQuestion.setAnswer_C(resultSet.getString("answer_C"));
                myQuestion.setAnswer_D(resultSet.getString("answer_D"));
                myQuestion.setAnswer_correct(resultSet.getString("answer_correct"));
                arrayList.add(myQuestion);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
