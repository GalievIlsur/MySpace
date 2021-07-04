package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl(){

    }

    public void createUsersTable() {
        try(Statement statement = Util.getStatement()) {
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

    public void dropUsersTable() {
        try(Statement statement = Util.getStatement()) {
            statement.execute("drop table if exists myusers");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Statement statement = Util.getStatement()) {
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

    public void removeUserById(long id) {
        try(Statement statement = Util.getStatement()) {
            statement.execute("delete from myusers where id = " + id + ";");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> result = new ArrayList<>();
            try (ResultSet res = Util.getStatement().executeQuery("select * from myusers")) {
                while (res.next()) {
                    User user = new User();
                    user.setId(res.getLong("id"));
                    user.setName(res.getString("name"));
                    user.setLastName(res.getString("lastName"));
                    user.setAge(res.getByte("age"));
                    result.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public void cleanUsersTable() {
        try(Statement statement = Util.getStatement()) {
            statement.execute("truncate table myusers");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
