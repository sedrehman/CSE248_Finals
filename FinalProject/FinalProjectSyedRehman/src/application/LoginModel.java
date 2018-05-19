package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class LoginModel implements Initializable{
	private Connection connection= SQLConnection.connect();
	private User user;
	
	public boolean isLogin(String userName, String password) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String query = "select * from UserList where email = ? and password = ?";
		try {
			//ResultSet is the row in the data-structure table it goes row by row till the end
			//preparedStatement can load a query (sql command) and execute it.
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				  user = new User(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), 
						rs.getString("password"), rs.getString("address"), rs.getString("cartItems"), 
						rs.getString("orders"));
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			System.out.println("problem is in login...");
			return false;
		}finally {
			try {
				rs.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public User getUser() {
		return this.user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
