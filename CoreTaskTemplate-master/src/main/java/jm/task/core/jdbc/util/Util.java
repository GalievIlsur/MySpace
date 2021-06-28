package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/usersdb?serverTimezone=UTC";
        String username = "ILSUR26";
        String password = "F7atx538ilsur";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

}
