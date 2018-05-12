package p1;
import java.sql.*;

public class SQLConnection {
	
	
	
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:habitatForHumanity.sqlite");
			System.out.println("coonected to DB");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
	
	
	
	
}
