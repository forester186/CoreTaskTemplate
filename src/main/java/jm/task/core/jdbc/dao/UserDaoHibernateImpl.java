package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS people (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age INT)";
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery(sqlCreate);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        String sqlDelete = "DROP TABLE IF EXISTS people";
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery(sqlDelete).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(new User(name,lastName,age));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        User user = Util.getSessionFactory().openSession().get(User.class, id);
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>)  Util.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        for(User user : getAllUsers()){
            removeUserById(user.getId());
        }
        session.getTransaction().commit();
        session.close();

    }
}
