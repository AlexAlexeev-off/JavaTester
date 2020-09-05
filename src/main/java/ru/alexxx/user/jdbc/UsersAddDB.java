package ru.alexxx.user.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersAddDB{
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        PreparedStatement pstatement;
        ResultSet resultSet = null;

        try {
            DataSource dataSource = createDataSource();
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            statement.execute("INSERT INTO users (name, email) VALUES ('Tom', 'tom@mail.ru')");
            statement.execute("INSERT INTO users (name, email) VALUES ('Fred', 'fred@mail.ru')");
//            for (int i = 0; i < 10; i++) {
//                statement.addBatch("INSERT INTO users (name, email) VALUES ('Bob', 'bob@mail.ru')");
//            }
//            statement.executeBatch();

            pstatement = connection.prepareStatement("SELECT * FROM users");
            resultSet = pstatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                Long id = user.setId(resultSet.getLong("id"));
                String name = user.setName(resultSet.getString("name"));
                String email = user.setEmail(resultSet.getString("email"));
                users.add(user);
                System.out.printf("Id: %d, Name: %s, Email: %s %n", id, name, email);
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
        dataSource.setUrl("jdbc:mysql://192.168.1.2:3306/gbusers");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }

}