package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/usersdb";
    private static final String username = "ILSUR26";
    private static final String password = "F7atx538ilsur";

    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static Statement getStatement() throws SQLException {
        return Util.getConnect().createStatement();
    }
}