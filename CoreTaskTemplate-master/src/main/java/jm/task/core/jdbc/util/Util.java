package jm.task.core.jdbc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {

    public static Properties getConnection() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/usersdb");
        properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.connection.username", "ILSUR26");
        properties.setProperty("hibernate.connection.password", "F7atx538ilsur");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        return properties;
    }

    public static Connection getConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/usersdb";
        String username = "ILSUR26";
        String password = "F7atx538ilsur";
        return DriverManager.getConnection(url, username, password);


    }

}
