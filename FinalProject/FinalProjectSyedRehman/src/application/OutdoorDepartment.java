package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OutdoorDepartment {
	private ArrayList <Item> itemList = new ArrayList<>();
	Connection conn = SQLConnection.connect();
	private LoadItems li = new LoadItems();
	
	public void LoadTheItems() {
		String sql = "SELECT * FROM Outdoor_Items";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
//				String purpose = rs.getString("purpose");
//				String material = rs.getString("materials");
//				String other = "Purpose: " + purpose +"\n" +"Materials: " + material;
				Item item = li.getItem(name);
				//item.setOtherInfo(other);
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
