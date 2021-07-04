package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public static Transaction transaction = null;

    public void createUsersTable() {
        String sql = new StringBuilder().append("create table if not exists myusers")
                .append("(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,")
                .append("name VARCHAR(45),")
                .append("lastName VARCHAR(45),")
                .append("age INTEGER(3))")
                .toString();
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("drop table if exists myusers").executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            System.out.println("User с именем " + name + " добавлен в базу данных");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("delete from myusers where id = " + id + ";").executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public List<User> getAllUsers() {
        List<User> newResult = new ArrayList<>();

        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User");
            newResult = query.getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
        return newResult;
    }

    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("truncate table myusers").executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
