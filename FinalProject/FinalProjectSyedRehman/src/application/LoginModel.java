package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
	private Connection connection;
	
	public LoginModel() {
		connection = SqliteConnection.connect();
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
}
