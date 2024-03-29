package application2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import application.Item;
import application.SQLConnection;

public class LoadItems {
	
	private Map <String, Item> itemList = new HashMap<String, Item>();
	private ArrayList<String> itemNames = new ArrayList<>();
	Connection conn;
	
	public void loadTheItems() {
		if(itemNames.size()> 0) {
			itemNames.clear();
		}
		if(itemList.size()> 0) {
			itemList.clear();
		}
		
		String sql = "SELECT * FROM ItemList";
		
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			conn = SQLConnection.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Item temp = new Item(rs.getString("name"), rs.getDouble("price"), rs.getInt("itemNumber"), rs.getString("stockLocation"), rs.getInt("quantity"), rs.getString("otherInfo")
						, rs.getString("brand"), rs.getString("safety"));
				itemList.put(temp.getName(), temp);
				itemNames.add(temp.getName());
			}
			stmt.close();
			conn.close();	// closing the connection to be ready for the next use just in case;
			
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}
	
	public Item getItem(String title) {
		//before using this you have to make sure that lkoadTheItems() was callded.
		if(itemList.isEmpty()) {
			loadTheItems();
			if (itemList.isEmpty()){
				//if itemList is empty even after loading the items then that means there was -
				// - a problem in loading the items;
				return null;
				}
			Item temp = itemList.get(title);
			return temp;
		}else {
			Item temp = itemList.get(title);
			return temp;
		}
	}

	public Map<String, Item> getItemList() {
		return itemList;
	}

	public void setItemList(Map<String, Item> itemList) {
		this.itemList = itemList;
	}

	public ArrayList<String> getItemNames() {
		return itemNames;
	}

	public void setItemNames(ArrayList<String> itemNames) {
		this.itemNames = itemNames;
	}
	
	
}
