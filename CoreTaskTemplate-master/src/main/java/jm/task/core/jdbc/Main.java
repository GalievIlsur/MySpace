package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Kelly", "Nelly", (byte)34);
        userService.saveUser("Din", "Dadly", (byte)45);
        userService.saveUser("Ben", "Freak", (byte)28);

        userService.removeUserById(1);

        List<User> userList = userService.getAllUsers();
        for(User u : userList) {
            System.out.println(u);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}