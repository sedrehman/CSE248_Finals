package application2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateItems {
	Connection conn;

	public void update(String name, double price, int itemNumber, String stockLocation, int quantity, String otherInfo,
			String brand, String safety) {
		String query = "UPDATE ItemList SET name = ?, "
                + "price = ?, "
                + "stockLocation = ?, "
                + "quantity = ?, "
                + "otherInfo = ?, "
                + "brand = ?, "
                + "safety = ? "
                + "WHERE itemNumber = ?";
		try {
			Connection conn = SQLConnection.connect();
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setDouble(2, price);
			pstmt.setString(3, stockLocation);
			pstmt.setInt(4, quantity);
			pstmt.setString(5, otherInfo);
			pstmt.setString(6, brand);
			pstmt.setString(7, safety);
			pstmt.setInt(8, itemNumber);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
