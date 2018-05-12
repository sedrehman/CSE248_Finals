package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import p1.SQLConnection;

public class KitchenDepartment {
	private ArrayList <String> kitchenItemList = new ArrayList<>();
	Connection conn = SQLConnection.connect();
	
	public void LoadTheItems() {
		String sql = "SELECT * FROM Kitchen_Items";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				kitchenItemList.add(name);
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}

	public ArrayList<String> getKitchenItemList() {
		return kitchenItemList;
	}

	public void setKitchenItemList(ArrayList<String> kitchenItemList) {
		this.kitchenItemList = kitchenItemList;
	}
	
}
