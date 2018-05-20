package application2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FurnitureDepartment {
	Connection conn = SQLConnection.connect();
	private LoadItems li = new LoadItems();
	
	public void saveFurnitureItems(String name) {
		String sql = "INSERT INTO Furniture_Items(name) VALUES(?)";
		try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            conn.close();
            } catch (SQLException e) {
			System.out.println("problem at the FurnitureItemList");
			e.printStackTrace();
		}
	}
}
