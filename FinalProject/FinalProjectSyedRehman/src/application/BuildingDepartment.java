package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BuildingDepartment {
	private ArrayList <Item> itemList = new ArrayList<>();
	Connection conn = SQLConnection.connect();
	private LoadItems li = new LoadItems();
	
	public void LoadTheItems() {
		String sql = "SELECT * FROM Building_Items";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				Item item = li.getItem(name);
//				String contains = rs.getString("contains");
//				String purpose = rs.getString("purpose");
//				String warning = rs.getString("warning");
//				String other = "Contains: " + contains+ "\n" + "Purpose: " + purpose + "\n" + "Warning: "+ warning;
			//	item.setOtherInfo(other);
				itemList.add(item);
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
}
