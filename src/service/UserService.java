package service;

import dao.UserDao;
import domain.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public boolean registerUser(User user){
        if(userDao.find(user.getUserName(),user.getUserPassword()) == null){
            userDao.add(user);
            return true;
        }
        else
            return false;
    }

    public User loginUser(String userName , String password){
        return userDao.find(userName,password);
    }
}
