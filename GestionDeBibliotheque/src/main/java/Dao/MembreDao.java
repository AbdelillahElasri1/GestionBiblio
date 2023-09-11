package Dao;

import Database.DatabaseConnectionManager;
import models.Book;
import models.BookBorrow;
import models.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDao implements MembreDaoInterface{
    Connection connection = DatabaseConnectionManager.getConnection();
    @Override
    public Membre saveMember(Membre membre){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO member (numMember, name, cin) VALUES(?,?,?)");
            preparedStatement.setInt(1,membre.getNumMember());
            preparedStatement.setString(2,membre.getName());
            preparedStatement.setString(3,membre.getCin());
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                return membre;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  null;

    }
    @Override
    public Membre updateMember(Membre membre){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE member SET name = ?, cin = ? WHERE numMember = ?");
            preparedStatement.setString(1,membre.getName());
            preparedStatement.setString(2,membre.getCin());
            preparedStatement.setInt(3,membre.getNumMember());
            int row = preparedStatement.executeUpdate();
            if (row < 0){
                return membre;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void deleteMember(int numberMember){
        try {
            PreparedStatement deleteBorrowRecords = connection.prepareStatement("DELETE FROM bookBorrow WHERE memberId = ?");
            deleteBorrowRecords.setInt(1,numberMember);
            deleteBorrowRecords.executeUpdate();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM member WHERE numMember = ?");
            preparedStatement.setInt(1,numberMember);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public Membre getMemberByNumMember(int memberId){
        Membre membre = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT numMember, name, cin FROM member WHERE numMember = ?");
            preparedStatement.setInt(1, memberId);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int numMember = resultSet.getInt("numMember");
                    String name = resultSet.getString("name");
                    String cin = resultSet.getString("cin");
                    membre = new Membre(numMember,name,cin);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return membre;
    }
    @Override
    public List<Membre> getAllMembers(){
        List<Membre> membres = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT numMember,name,cin FROM member");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("numMember");
                String name = resultSet.getString("name");
                String cin = resultSet.getString("cin");

                Membre membre = new Membre(id,name,cin);
                membres.add(membre);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return membres;
    }
    public List<BookBorrow> memberBorrowedBookWithInfo(int memberId){
        ArrayList<BookBorrow> bookBorrows = new ArrayList<>();
        MembreDao membreDao = new MembreDao();
        BookDao bookDao = new BookDao();
        Membre membre = membreDao.getMemberByNumMember(memberId);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT dateOfBorrow,dateOfReturn,bookId FROM bookBorrow WHERE memberId = ?");
            preparedStatement.setInt(1,memberId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Date dateBorrow = resultSet.getDate("dateOfBorrow");
                Date dateReturn = resultSet.getDate("dateOfReturn");
                Book book = bookDao.getBookByIsbn(resultSet.getInt("bookId"));
//                int member_id = resultSet.getInt("memberId");
                BookBorrow bookBorrow = new BookBorrow(dateBorrow,dateReturn,book,membre);
                bookBorrows.add(bookBorrow);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return bookBorrows;
    }
}
