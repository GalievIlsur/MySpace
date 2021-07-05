package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Alex", "Niko", (byte)37);
        userService.saveUser("John", "Kramer", (byte)55);
        userService.saveUser("Alice", "Karter", (byte)34);
        userService.saveUser("Bin", "Mister", (byte)60);

        List<User> userList = userService.getAllUsers();
        for(User u : userList) {
            System.out.println(u.toString());
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}