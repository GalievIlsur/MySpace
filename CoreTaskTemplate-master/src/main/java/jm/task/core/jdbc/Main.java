package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();

        userDao.saveUser("Alex", "Niko", (byte)37);
        userDao.saveUser("John", "Kramer", (byte)55);
        userDao.saveUser("Alice", "Karter", (byte)34);
        userDao.saveUser("Bin", "Mister", (byte)60);

        List<User> userList2 = userDao.getAllUsers();
        for(User u : userList2) {
            System.out.println(u.toString());
        }

        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
