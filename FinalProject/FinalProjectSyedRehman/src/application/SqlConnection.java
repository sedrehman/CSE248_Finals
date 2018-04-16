package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {
	public static Connection connect() {
		try {
			//connecting to the database. 
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:habitalForHumanity.sqlite");
			return connection;
		}catch(Exception e) {
			System.out.println("trouble at SqliteConnection.connect()");
			return null;
		}
	}
}
