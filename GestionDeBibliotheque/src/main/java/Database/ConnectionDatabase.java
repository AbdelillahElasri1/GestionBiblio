package Database;

import java.net.URL;
import java.sql.*;

public class ConnectionDatabase {
    public static final String Url = "com.mysql.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "";

    public static void Connection() throws ClassNotFoundException, SQLException {
        Class.forName(Url);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", userName, password);
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from user");

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String status = resultSet.getString("status");
            System.out.println(name);
            System.out.println(email);
            System.out.println(status);
        }
    }
}
