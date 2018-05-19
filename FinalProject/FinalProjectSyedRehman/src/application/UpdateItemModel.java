package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateItemModel {
	Connection conn;
	private Item item;
	
	public void update(String name, double price, int itemNumber, String stockLocation, int quantity, String otherInfo,
			String brand, String safety) {
		String query = "UPDATE ItemList SET price = ?, "
                + "itemNumber = ?, "
                + "stockLocation = ?, "
                + "quantity = ?, "
                + "otherInfo = ?, "
                + "brand = ? "
                + "safety = ? "
                + "WHERE name = ?";
		try {
			Connection conn = SQLConnection.connect();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, price);
			pstmt.setInt(2, itemNumber);
			pstmt.setString(3, stockLocation);
			pstmt.setInt(4, quantity);
			pstmt.setString(5, otherInfo);
			pstmt.setString(6, brand);
			pstmt.setString(7, safety);
			pstmt.setString(8, name);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
