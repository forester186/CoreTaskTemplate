package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//        // Создание таблицы User(ов)
        userService.createUsersTable();
//        //  Добавление 4 User(ов) в таблицу
        userService.saveUser("Alexander","Pushkin",(byte)37);
        userService.saveUser("Fyodor", "Dostoevsky", (byte)59);
        userService.saveUser("Mikhail", "Lermontov", (byte)26);
        userService.saveUser("Sergey", "Yesenin", (byte)30);
        //Получение всех User из базы и вывод в консоль
        System.out.println(userService.getAllUsers());
        //Очистка таблицы User(ов)
        userService.cleanUsersTable();
        //Удаление таблицы
        userService.dropUsersTable();

//        userDaoJDBC.removeUserById(2);

    }
}
