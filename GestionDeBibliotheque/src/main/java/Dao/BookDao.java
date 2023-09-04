package Dao;

import Database.DatabaseConnectionManager;
import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    DatabaseConnectionManager DB = new DatabaseConnectionManager();
    Connection connection = null;
    public void saveBook(Book book){


        try {
                connection = DB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book(isbn,titre,author,status) VALUES (?,?,?,?)");
                preparedStatement.setInt(1,book.getIsbn());
                preparedStatement.setString(2,book.getTitre());
                preparedStatement.setString(3,book.getAuthor());
                preparedStatement.setString(4,book.getStatus());
                preparedStatement.executeUpdate();



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the connection in a finally block to ensure it's always closed
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Handle any exceptions that may occur during closing the connection
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
    public void updateBook(Book book){

        try {
            connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE book SET titre = ?, author = ?, status = ? WHERE isbn = ?");
            preparedStatement.setString(1,book.getTitre());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setString(3,book.getStatus());
            preparedStatement.setInt(4,book.getIsbn());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void deleteBook(int bookId){
        try {
            connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM book WHERE isbn = ?");
            preparedStatement.setInt(1,bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Book getBookByIsbn(int bookId){
        Book book = null;
        connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT isbn, titre, author, status FROM book WHERE isbn = ?");
            preparedStatement.setInt(1, bookId);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int isbn = resultSet.getInt("isbn");
                    String titre = resultSet.getString("titre");
                    String author = resultSet.getString("author");
                    String status = resultSet.getString("status");
                     book = new Book(isbn,titre,author,status);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return book;
    }
    public List<Book> getAllBooks(){
        connection = DB.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT isbn,titre,author,status FROM book WHERE status = 'disponible'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("isbn");
                String titre = resultSet.getString("titre");
                String author = resultSet.getString("author");
                String status = resultSet.getString("status");

                Book book = new Book(id,titre,author,status);
                books.add(book);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return books;

    }
}
