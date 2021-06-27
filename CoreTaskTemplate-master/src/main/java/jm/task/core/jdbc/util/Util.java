package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static void getConnect() {
        try{
            String url = "jdbc:mysql://localhost:3306/usersdb";
            String username = "ILSUR26";
            String password = "F7atx538ilsur";
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                System.out.println("Connection to DB success!");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

}
