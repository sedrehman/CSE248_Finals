package application2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteOrder {
	Connection conn;
	public void delete(int orderNumber) {
		String query = "DELETE FROM OrderList WHERE orderNumber = ?";
		try {
			Connection conn = SQLConnection.connect();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNumber);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
