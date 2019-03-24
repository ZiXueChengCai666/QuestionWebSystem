package dao;

import domain.User;
import util.Conn;

import java.sql.*;

public class UserDao {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public User find(String userName,String userPassword){
        User user = null;
        try{

            connection = new Conn().getConnection();
            String select = "select * from t_user where user_name=? and user_password=?";
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUserNiCheng(resultSet.getString("nicheng"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserPassword(resultSet.getString("user_password"));
                connection.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public boolean add(User user){
        try{
            connection = new Conn().getConnection();
            String strSQL =  "INSERT INTO t_user(nicheng,user_name,user_password) VALUES ('"
                    +user.getUserNiCheng()+"','"
                    +user.getUserName()+"','"
                    +user.getUserPassword()+"')";
            Statement statement = connection.createStatement();
            statement.execute(strSQL);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
