package Database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static String url = "jdbc:mysql://localhost:3306/librarymanagement";
    private static String username = "root";
    private static String password = "Abdelillah123@";
    private static Connection connection;
    private static DataSource dataSource;

    private DatabaseConnectionManager() {

    }


    public static Connection getConnection(){
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
