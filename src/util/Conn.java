package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private Connection connection = null;

    public Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功！");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wf?user=root&password=123654789wufan&useUnicode=true&characterEncoding=UTF-8");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
