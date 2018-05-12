package p1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LoadItems {
	
	private Map <String, Item> itemList = new HashMap<String, Item>();
	Connection conn = SQLConnection.connect();
	
	public void LoadTheItems() {
		String sql = "SELECT * FROM ItemList";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Item temp = new Item(rs.getString("name"), rs.getDouble("price"), rs.getInt("itemNumber"), rs.getString("stockLocation"), rs.getInt("quantity"), rs.getString("otherInfo")
						, rs.getString("brand"), rs.getString("safety"));
				itemList.put(temp.getName(), temp);
				System.out.println(temp.toString());
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}
}
