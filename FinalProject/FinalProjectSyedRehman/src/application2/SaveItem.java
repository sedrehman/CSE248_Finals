package application2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import application.Item;

public class SaveItem {
	
	private Map <String, Item> itemList = new HashMap<String, Item>();
	private Connection conn = SQLConnection.connect();
	
	public void saveTheItems(String name, double price, String StockLocation, int quantity, 
			String otherInfo, String brand, String safety ) {
		String sql = "INSERT INTO ItemList(name, price, stockLocation, quantity, otherInfo, brand, safety)"
				+ " VALUES(?,?,?,?,?,?,?)";
		try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, StockLocation);
            pstmt.setInt(4, quantity);
            pstmt.setString(5, otherInfo);
            pstmt.setString(6, brand);
            pstmt.setString(7, safety);
            pstmt.executeUpdate();
            conn.close();	// closing the connection to be ready for the next use just in case
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}
	
	

}
