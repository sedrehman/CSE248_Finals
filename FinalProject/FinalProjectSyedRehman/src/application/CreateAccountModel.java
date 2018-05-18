package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountModel {
	Connection conn;
	private User user;

	public void incert(String firstName, String lastName, String email, String password, String address,
			String cartItems, String orders) {
		String query = "INSERT INTO UserList (firstName, lastName, email, password, address, cartItems, orders) VALUES(?,?,?,?,?,?,?)";
		try {
			Connection conn = SQLConnection.connect();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, address);
			pstmt.setString(6, cartItems);
			pstmt.setString(7, orders);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
