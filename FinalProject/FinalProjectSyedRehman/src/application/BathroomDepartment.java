package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BathroomDepartment {
	private ArrayList <String> bathroomItemList = new ArrayList<>();
	Connection conn = SQLConnection.connect();
	
	public void LoadTheItems() {
		String sql = "SELECT * FROM Bathroom_Items";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				bathroomItemList.add(name);
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}

	public ArrayList<String> getBathroomItemList() {
		return bathroomItemList;
	}

	public void setBathroomItemList(ArrayList<String> bathroomItemList) {
		this.bathroomItemList = bathroomItemList;
	}
	
	
}
