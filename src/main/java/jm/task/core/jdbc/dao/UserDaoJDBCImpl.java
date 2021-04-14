package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Util.getBasaDate();
            String sqlCommand = "CREATE TABLE people (Id INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(20), LastName VARCHAR(20), AGE INT)";
            Util.getStatement().executeUpdate(sqlCommand);

        }catch (Exception e){
            System.out.println("Таблица уже была создана, зачем нам повторно ее создавать?)");

        }

    }

    public void dropUsersTable() {
        Util.getBasaDate();
        String sqlDelete = "DROP TABLE people";
        try {
            Util.getStatement().executeUpdate(sqlDelete);
            System.out.println("Таблица успешно удалена");
        } catch (SQLException e) {
            System.out.println("Таблицы и не существовало");

        }

    }

    public void saveUser(String name, String lastName, byte age) {
        Util.getBasaDate();
        String sqlSave = "INSERT people(Name, LastName, AGE) VALUES (" + "'" + name + "'" +"," + "'" + lastName + "'"+ "," + age +")";
        try {
            Util.getStatement().executeUpdate(sqlSave);
            System.out.println(" User с именем – " + name + " добавлен в базу данных");

        } catch (SQLException e) {
            System.out.println("При сохранении User возникли проблемы " + e);
        }

    }

    public void removeUserById(long id) {
        Util.getBasaDate();
        String sqlRemove = "DELETE FROM people WHERE Id = " + id;
        try {
            Util.getStatement().executeUpdate(sqlRemove);
            System.out.println("User с Id – " + id + " удален из базы данных");
        } catch (SQLException e) {
            System.out.println("При удалении произошла ошибка " + e);
        }

    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try{
            ResultSet resultSet = Util.getStatement().executeQuery("SELECT * FROM people");
            while(resultSet.next()){
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String lastName = resultSet.getString("LastName");
                int age = resultSet.getInt("AGE");
                User user = new User(name,lastName,(byte) age);
                user.setId((long)id);
                userList.add(user);
            }
        }catch (SQLException e){
            System.out.println("При получение всех пользователей возникла ошибка" + e);

        }
        return userList;
    }

    public void cleanUsersTable() {
        Util.getBasaDate();
        String sqlClean = "DELETE FROM people ";
        try {
            Util.getStatement().executeUpdate(sqlClean);
            System.out.println("Очистили все данные");
        } catch (SQLException e) {
            System.out.println("При очистки таблицы возникло исключение" + e);

        }


    }
}
