package service;

import dao.TeacherDao;
import dao.UserDao;
import domain.Teacher;
import domain.User;

public class TeacherService {

    private TeacherDao teacherDao = new TeacherDao();

    public boolean registerTeacher(Teacher teacher){
        if(teacherDao.find(teacher.getTeacherName(),teacher.getTeacherPassword()) == null){
            teacherDao.add(teacher);
            return true;
        }
        else
            return false;
    }

    public Teacher loginTeacher(String teacherName , String teacherPassword){
        return teacherDao.find(teacherName,teacherPassword);
    }
}
