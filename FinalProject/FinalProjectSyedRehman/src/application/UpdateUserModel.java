package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserModel {
	Connection conn;
	private User user;

	public void update(String firstName, String lastName, String email, String password, String address,
			String cartItems, String orders) {
		String query = "UPDATE UserList SET firstName = ?, "
                + "lastName = ?, "
                + "password = ?, "
                + "address = ?, "
                + "cartItems = ?, "
                + "orders = ? "
                + "WHERE email = ?";
		try {
			Connection conn = SQLConnection.connect();
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, password);
			pstmt.setString(4, address);
			pstmt.setString(5, cartItems);
			pstmt.setString(6, orders);
			pstmt.setString(7, email);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
