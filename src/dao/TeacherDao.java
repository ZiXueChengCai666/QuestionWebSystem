package dao;

import domain.Teacher;
import util.Conn;

import java.sql.*;

public class TeacherDao {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Teacher find(String teacherName, String teacherPassword){
        Teacher teacher = null;
        try{

            connection = new Conn().getConnection();
            String select = "select * from t_teacher where teacher_name=? and teacher_password=?";
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1, teacherName);
            preparedStatement.setString(2, teacherPassword);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("id"));
                teacher.setTeacherName(resultSet.getString("teacher_name"));
                teacher.setTeacherPassword(resultSet.getString("teacher_password"));
                connection.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacher;
    }

    public boolean add(Teacher teacher) {
        try {
            connection = new Conn().getConnection();
            String strSQL = "INSERT INTO t_teacher(teacher_name,teacher_password) VALUES ('"
                    + teacher.getTeacherName() + "','"
                    + teacher.getTeacherPassword() + "')";
            Statement statement = connection.createStatement();
            statement.execute(strSQL);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

    }
}
