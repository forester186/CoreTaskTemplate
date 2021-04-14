package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//        // Создание таблицы User(ов)
        userDaoJDBC.createUsersTable();
//        //  Добавление 4 User(ов) в таблицу
        userDaoJDBC.saveUser("Alexander","Pushkin",(byte)37);
        userDaoJDBC.saveUser("Fyodor", "Dostoevsky", (byte)59);
        userDaoJDBC.saveUser("Mikhail", "Lermontov", (byte)26);
        userDaoJDBC.saveUser("Sergey", "Yesenin", (byte)30);
        //Получение всех User из базы и вывод в консоль
        System.out.println(userDaoJDBC.getAllUsers().toString());
        //Очистка таблицы User(ов)
        userDaoJDBC.cleanUsersTable();
        //Удаление таблицы
        userDaoJDBC.dropUsersTable();

//        userDaoJDBC.removeUserById(2);

    }
}
