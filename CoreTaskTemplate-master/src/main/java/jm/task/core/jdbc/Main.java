package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();

        userDao.saveUser("Alex", "Niko", (byte)37);
        userDao.saveUser("John", "Kramer", (byte)55);
        userDao.saveUser("Alice", "Karter", (byte)34);
        userDao.saveUser("Bin", "Mister", (byte)60);

        List<User> userList = userDao.getAllUsers();
        for(User u : userList) {
            System.out.println(u.toString());
        }

        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
