package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModel {
	private Connection connection;
	
	public LoginModel() {
		connection = SqliteLogInConnection.connect();
		if (connection == null) {
			//if the connection is null then there is no point in continuing the application. 
			// it will exit out of the application.
			System.exit(1);
		}
	}
	
	public boolean isConnected() {
		try {
			return !connection.isClosed();	//so here it will come out true if the connection is open.
		} catch (SQLException e) {
			System.out.println("error connecting to the database!");
			return false;
		}
	}
	
	public boolean isLogin(String userName, String password) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from UserList where email = ? and password = ?";
		try {
			//ResultSet is the row in the data-structure table it goes row by row till the end
			//preparedStatement can load a query (sql command) and execute it.
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			System.out.println("problem in is login...");
			return false;
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public User getUser(String emailAddress) {
		String sql = "SELECT firstName, lastName, email, password, address, cart, orders FROM UserList WHERE email = ?";
		User user = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql) ;

			// loop through the result set
			while (rs.next()) {
				//this should work.
				user = new User(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), 
						rs.getString("password"), rs.getString("address"), rs.getString("cartItems"), 
						rs.getString("orders"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return user;
	}
	
	
}
