package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteConnection {
	public static Connection connect() {
		try {
			//connection to the database;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:habitatForHumanity.sqlite");
			return connection;
		}catch(Exception e) {
			System.out.println("error connecting sqliteConnection");
			return null;
		}
	}
}
