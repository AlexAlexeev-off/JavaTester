package ru.alexxx.biblio.service;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jetbrains.annotations.NotNull;
import ru.alexxx.biblio.model.Author;
import ru.alexxx.biblio.model.Book;
import ru.alexxx.biblio.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserForReadBook extends Author {

    public static class Books extends Book {

        public Books(Long bookid, Long authorid, String bookname, Long bookswho) {
            super(bookid, authorid, bookname, bookswho);
        }
    }
    public UserForReadBook(Long authorid, String authorname) {
        super(authorid, authorname);
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<User> users = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        ResultSet resultSet3 = null;
        long i = 0;
        try {
            DataSource dataSource = createDataSource();
            connection = dataSource.getConnection();
            statement2 = connection.prepareStatement("SELECT * FROM Books");
            resultSet2 = statement2.executeQuery();
            while (resultSet2.next()) {
                Book book = new Book();
                Long id = book.setBookid(resultSet2.getLong("id"));
                String name = book.setBookname(resultSet2.getString("name"));
                Long who = book.setBookswho(resultSet2.getLong("who"));
                books.add(book);
                System.out.printf("Id: %d, Name: %s\n", id, name);

            }
            System.out.println("Получи пользователя, который читает книгу!");
            System.out.println("Выбири книгу написав ее ID");
            int setau = console.nextInt()-1;
            //int swho = books.get(books.indexOf(setau));
            statement = connection.prepareStatement("SELECT * FROM Users WHERE id IN (?)");
            statement.setInt(1, Math.toIntExact(books.get(setau).getBookswho(i)));
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