package jm.task.core.jdbc;

//import jm.task.core.jdbc.service.UserServiceImpl;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        // Создание таблицы User(ов)
        userDaoHibernate.createUsersTable();
        //  Добавление 4 User(ов) в таблицу
        userDaoHibernate.saveUser("Alexander","Pushkin",(byte)37);
        userDaoHibernate.saveUser("Fyodor", "Dostoevsky", (byte)59);
        userDaoHibernate.saveUser("Mikhail", "Lermontov", (byte)26);
        userDaoHibernate.saveUser("Sergey", "Yesenin", (byte)30);
        //Получение всех User из базы и вывод в консоль
        System.out.println(userDaoHibernate.getAllUsers());
//        //Очистка таблицы User(ов)
        userDaoHibernate.cleanUsersTable();
//        //Удаление таблицы
         userDaoHibernate.dropUsersTable();

//        userDaoHibernate.removeUserById(2);















    }
}
