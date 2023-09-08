package Database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private String url = "jdbc:mysql://localhost:3306/librarymanagement";
    private String username = "root";
    private String password = "Abdelillah123@";
    private  Connection connection;
    private static DataSource dataSource;

    public DatabaseConnectionManager() {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    public Connection getConnection(){
        System.out.println("db connected");

        if (connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
    public void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
