package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    public static Connection getConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/usersdb";
        String username = "ILSUR26";
        String password = "F7atx538ilsur";

        return DriverManager.getConnection(url, username, password);
    }

    public static Statement getStatement() throws SQLException {
        return Util.getConnect().createStatement();
    }

}
