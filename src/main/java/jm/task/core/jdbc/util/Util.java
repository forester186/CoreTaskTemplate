package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost/project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "6K$-4#Pw";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void getBasaDate() {
        try{
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            getConnection();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();

    }

}
