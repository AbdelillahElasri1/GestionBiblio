package Dao;

import Database.DatabaseConnectionManager;
import models.Book;
import models.BookBorrow;
import models.Status;

import java.sql.*;

public class BookBorrowDao {
    DatabaseConnectionManager DB = new DatabaseConnectionManager();
    Connection connection = null;
    Status status = null;
    String available = String.valueOf(Status.AVAILABLE);
    String borrow = String.valueOf(Status.BORROWED);
    public void takeBookFromLibrary(int bookId, int memberId, BookBorrow bookBorrow){
        connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT INTO bookBorrow (dateOfBorrow,dateOfReturn,bookId, memberId) VALUES (?,?,?,?)"
            );
            java.util.Date utilDate = bookBorrow.getDateOfReturn();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Date borrowDate = new Date(System.currentTimeMillis());
            preparedStatement.setDate(1,borrowDate);
            preparedStatement.setDate(2,sqlDate);
            preparedStatement.setInt(3,bookId);
            preparedStatement.setInt(4,memberId);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void returnBookToLibrary(int bookIsbn, int memberNumber){
        connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT dateOfBorrow,dateOfReturn,bookId, memberId FROM bookBorrow WHERE bookId = ? AND memberId = ?");
            preparedStatement.setInt(1,bookIsbn);
            preparedStatement.setInt(2,memberNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Timestamp dateBorrow = resultSet.getTimestamp("dateOfBorrow");
                Date dateReturn = resultSet.getDate("dateOfReturn");
//                int bookIsbn1 = resultSet.getInt("bookId");
//                int memberNumber1 = resultSet.getInt("memberId");
                int comparisonResult = dateBorrow.compareTo(dateReturn);
                if (comparisonResult     < 0) {
//                    System.out.println("dateBorrow is earlier than dateReturn");
//                    PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE book SET status='BORROWED' WHERE isbn = ?");
//                    preparedStatement1.setInt(1,bookIsbn);
//                     preparedStatement1.executeUpdate();
                    System.out.println("book already Borrowed");
                } else if (comparisonResult > 0) {
//                    System.out.println("dateBorrow is later than dateReturn");
                    PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE book SET status='LOST' WHERE isbn = ?");
                    preparedStatement1.setInt(1,bookIsbn);
                    preparedStatement1.executeUpdate();
                    System.out.println("book is Lost");
                } else {
//                    System.out.println("dateBorrow is equal to dateReturn");
                    PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE book SET status='AVAILABLE' WHERE isbn = ?");
                    preparedStatement1.setInt(1,bookIsbn);
                    preparedStatement1.executeUpdate();
                    System.out.println("book is available now.");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
