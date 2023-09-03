import Database.ConnectionDatabase;
import Database.DatabaseConnectionManager;
import utils.InputReader;
import utils.OutputWriter;

import java.sql.*;

public class GestionDeBiblio {
	static InputReader i = new InputReader(System.in);
	static OutputWriter o = new OutputWriter(System.out);
	public static final String Url = "com.mysql.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = DatabaseConnectionManager.getConnection();
		while (true) {
			o.println("Welcome to library system management");
			o.println("1- add books to library");
			o.println("2- search for book inside library");
			o.println("3- take book from library");
			o.println("4- return book to library");
			o.println("5- exit");
			o.print("enter your choice:  ");
			int choice = i.readInt();
			switch (choice){
				case 1:
					o.println("book added");
					break;
				case 2:
					o.println("book is here");
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from user");
					while (resultSet.next()){
						String name = resultSet.getString("name");
//						String email = resultSet.getString("email");
						String status = resultSet.getString("status");
						o.println(name);
//						o.println(email);
						o.println(status);
					}
					break;
				case 3:
					o.println("book is taked by abdelillah");
					break;
				case 4:
					o.println("book is returned by abdelillah");
					break;
				case 5:
					o.println("exit");
					System.exit(1);
					break;
				default:
					o.println("invalid choice");
					break;
			}

		}
	}

}
