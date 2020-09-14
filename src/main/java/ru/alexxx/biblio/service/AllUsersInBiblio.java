package ru.alexxx.biblio.service;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jetbrains.annotations.NotNull;
import ru.alexxx.biblio.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllUsersInBiblio extends User {
    public AllUsersInBiblio(Long userid, String username) {
        super(userid, username);
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            DataSource dataSource = createDataSource();
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Users");
            //statement = connection.prepareStatement("SELECT * FROM users where id = ?");
            //statement.setLong(1, 1L);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                Long id = user.setUserid(resultSet.getLong("id"));
                String name = user.setUsername(resultSet.getString("name"));
                users.add(user);
                System.out.printf("Id: %d, Name: %s\n", id, name);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        //System.out.println(users);

    }


    @NotNull
    private static DataSource createDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://192.168.1.2:3306/gbbiblio");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }

}