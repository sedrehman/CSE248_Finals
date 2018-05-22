package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application2.SQLConnection;

public class SaveOrders {
private Connection conn;
	
	public void saveOrder(Order order) {
		String sql = "INSERT INTO OrderList(items, time, fullName, userAddress, creditCardNumber, total)"
				+ " VALUES(?,?,?,?,?,?)";
		try {
			conn = SQLConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, order.getItems());
            pstmt.setString(2, order.getTimeStamp());
            pstmt.setString(3, order.getFullName());
            pstmt.setString(4, order.getUserAddress());
            pstmt.setDouble(5, order.getCreditCardNumber());
            pstmt.setDouble(6, order.getTotal());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();	// closing the connection to be ready for the next use just in case
		} catch (SQLException e) {
			System.out.println("problem at the OrderList");
			e.printStackTrace();
		}
	}
}
