package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class Util {
    public static Properties getProperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/usersdb");
        properties.setProperty("hibernate.connection.username", "ILSUR26");
        properties.setProperty("hibernate.connection.password", "F7atx538ilsur");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");

        return properties;
    }

    public static SessionFactory sessionFactory = new Configuration().addProperties(Util.getProperties())
                                                                     .addAnnotatedClass(User.class).buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}