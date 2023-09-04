package Dao;

import Database.DatabaseConnectionManager;
import models.Book;
import models.Membre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembreDao {
    DatabaseConnectionManager DB = new DatabaseConnectionManager();
    Connection connection = null;
    public void saveMember(Membre membre){
        connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO member (numMember, name, cin) VALUES(?,?,?)");
            preparedStatement.setInt(1,membre.getNumMember());
            preparedStatement.setString(2,membre.getName());
            preparedStatement.setString(3,membre.getCin());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
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
    public void updateMember(Membre membre){
        connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE member SET name = ?, cin = ? WHERE numMember = ?");
            preparedStatement.setString(1,membre.getName());
            preparedStatement.setString(2,membre.getCin());
            preparedStatement.setInt(3,membre.getNumMember());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void deleteMember(int numberMember){
        connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM book WHERE numMember = ?");
            preparedStatement.setInt(1,numberMember);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Membre getMemberByNumMember(int memberId){
        Membre membre = null;
        connection = DB.getConnection();
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
    public List<Membre> getAllMembers(){
        connection = DB.getConnection();
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
}
