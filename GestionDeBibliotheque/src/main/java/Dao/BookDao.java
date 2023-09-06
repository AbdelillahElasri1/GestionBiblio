package Dao;

import Database.DatabaseConnectionManager;
import models.Book;
import models.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    DatabaseConnectionManager DB = new DatabaseConnectionManager();
    Connection connection = null;
    Status status = Status.AVAILABLE;
    public void saveBook(Book book){


        try {
                connection = DB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book(isbn,titre,author,status) VALUES (?,?,?,?)");
                preparedStatement.setInt(1,book.getIsbn());
                preparedStatement.setString(2,book.getTitre());
                preparedStatement.setString(3,book.getAuthor());
                preparedStatement.setString(4,status.name());

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
            preparedStatement.setString(3, String.valueOf(book.getStatus()));
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
                    Status status = Status.valueOf(resultSet.getString("status"));
                     book = new Book(isbn,titre,author,status);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return book;
    }
    public List<Book> getAllBooksAvailable(){
        connection = DB.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT isbn,titre,author,status FROM book WHERE status = 'AVAILABLE'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("isbn");
                String titre = resultSet.getString("titre");
                String author = resultSet.getString("author");
                Status status = Status.valueOf(resultSet.getString("status"));

                Book book = new Book(id,titre,author,status);
                books.add(book);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return books;

    }

    public List<Book> getAllBooksBorrow(){
        connection = DB.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT isbn,titre,author,status FROM book WHERE status = 'BORROWED'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int isbn = resultSet.getInt("isbn");
                String titre = resultSet.getString("titre");
                String author = resultSet.getString("author");
                Status status = Status.valueOf(resultSet.getString("status"));
                Book book = new Book(isbn,titre,author,status);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public List<Book> searchBookByTitre(String titre){
        connection = DB.getConnection();
        List<Book> books = new ArrayList<>();
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE titre LIKE ?");
            preparedStatement.setString(1, "%" +titre+ "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int isbn = resultSet.getInt("isbn");
                String titre1 = resultSet.getString("titre");
                String author = resultSet.getString("author");
                Status status = Status.valueOf(resultSet.getString("status"));
                book = new Book(isbn,titre1,author,status);
                books.add(book);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public List<Book> searchBookByAuthor(String author){
        connection = DB.getConnection();
        List<Book> books = new ArrayList<>();
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE author LIKE ?");
            preparedStatement.setString(1, "%" +author+ "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int isbn = resultSet.getInt("isbn");
                String titre1 = resultSet.getString("titre");
                String author1 = resultSet.getString("author");
                Status status = Status.valueOf(resultSet.getString("status"));
                book = new Book(isbn,titre1,author1,status);
                books.add(book);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public void bookAvailable() {
        connection = DB.getConnection();
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM book WHERE status = 'AVAILABLE'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int countBookAvailable = resultSet.getInt(1);
                System.out.println(countBookAvailable);
            }else {
                System.out.println("no available book");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void bookBorrowed(){
        connection = DB.getConnection();
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM book WHERE status = 'BORROWED'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int countBookBorrowed = resultSet.getInt(1);
                System.out.println(countBookBorrowed);
            }else {
                System.out.println("no Borrowed book");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void bookLost(){
        connection = DB.getConnection();
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM book WHERE status = 'Lost'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int countBookLost = resultSet.getInt(1);
                System.out.println(countBookLost);
            }else {
                System.out.println("no Lost book");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void allBooksInLibrary(){
        connection = DB.getConnection();
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM book");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int allBook = resultSet.getInt(1);
                System.out.println(allBook);
            }else {
                System.out.println("no book in library");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
