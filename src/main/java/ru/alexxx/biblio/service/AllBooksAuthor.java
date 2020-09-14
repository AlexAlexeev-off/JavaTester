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

public class AllBooksAuthor extends Author {

    public class Books extends Book {

        public Books(Long bookid, Long authorid, String bookname, Long bookswho) {
            super(bookid, authorid, bookname, bookswho);
        }
    }
    public AllBooksAuthor(Long authorid, String authorname) {
        super(authorid, authorname);
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        try {
            DataSource dataSource = createDataSource();
            connection = dataSource.getConnection();
            statement2 = connection.prepareStatement("SELECT * FROM Author");
            resultSet2 = statement2.executeQuery();
            while (resultSet2.next()) {
                Author author = new Author();
                Long id = author.setAuthorid(resultSet2.getLong("id"));
                String name = author.setAuthorname(resultSet2.getString("name"));
                authors.add(author);
                System.out.printf("Id: %d, Name: %s\n", id, name);

            }
            System.out.println("Получи список книг, выбранного автора!");
            System.out.println("Выбири автора написав его ID");
            int setau = console.nextInt();
            statement = connection.prepareStatement("SELECT * FROM Books WHERE idAuthor IN (?)");
            statement.setInt(1,setau);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                Long id = book.setBookid(resultSet.getLong("id"));
                String name = book.setBookname(resultSet.getString("name"));
                books.add(book);
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