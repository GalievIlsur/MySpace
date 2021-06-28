package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        Connection connection = Util.getConnect();
        try(Statement statement = connection.createStatement()) {
            String sql;
            sql = "CREATE TABLE myUsers " +
                    "(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                        " name VARCHAR(45), " +
                        " lastName VARCHAR(45), " +
                        " age INTEGER(3)) ";

            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void dropUsersTable() throws SQLException {
        
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Connection connection = Util.getConnect();
        try(Statement statement = connection.createStatement()) {
            String sql = new StringBuilder().append("insert into myusers (name, lastName, age) values ('").append(name).append("', '").append(lastName).append("', ").append(age).append(")").toString();
            statement.execute(sql);
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
