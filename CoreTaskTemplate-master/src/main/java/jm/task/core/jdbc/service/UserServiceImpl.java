package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() throws SQLException {
        Connection connection = Util.getConnect();
        try(Statement statement = connection.createStatement()) {
            String sql = new StringBuilder().append("create table if not exists myUsers")
                    .append("(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,")
                    .append("name VARCHAR(45),")
                    .append("lastName VARCHAR(45),")
                    .append("age INTEGER(3))")
                    .toString();

            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void dropUsersTable() throws SQLException {
        Connection connection = Util.getConnect();
        try(Statement statement = connection.createStatement()) {
            statement.execute("drop table if exists myusers");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Connection connection = Util.getConnect();
        try(Statement statement = connection.createStatement()) {
            String sql = new StringBuilder().append("insert into myusers (name, lastName, age) values ('")
                    .append(name).append("', '")
                    .append(lastName).append("', ")
                    .append(age).append(")")
                    .toString();
            statement.execute(sql);
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeUserById(long id) throws SQLException {
        Connection connection = Util.getConnect();
        try(Statement statement = connection.createStatement()) {
            statement.execute("delete from myusers where id = " + id + ";");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> result = new ArrayList<>();
        Connection connection = Util.getConnect();
        try(Statement statement = connection.createStatement()) {
            try (ResultSet res = statement.executeQuery("select * from myusers")) {
                while (res.next()) {
                    User user = new User();
                    user.setId(res.getLong("id"));
                    user.setName(res.getString("name"));
                    user.setLastName(res.getString("lastName"));
                    user.setAge(res.getByte("age"));
                    result.add(user);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public void cleanUsersTable() throws SQLException {
        Connection connection = Util.getConnect();
        try(Statement statement = connection.createStatement()) {
            statement.execute("truncate table myusers");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
