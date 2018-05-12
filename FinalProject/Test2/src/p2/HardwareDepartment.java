package p2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import p1.SQLConnection;

public class HardwareDepartment {
	private ArrayList <String> hardwareItemList = new ArrayList<>();
	Connection conn = SQLConnection.connect();
	
	public void LoadTheItems() {
		String sql = "SELECT * FROM Hardware_Items";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				hardwareItemList.add(name);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}

	public ArrayList<String> getHardwareItemList() {
		return hardwareItemList;
	}

	public void setHardwareItemList(ArrayList<String> hardwareItemList) {
		this.hardwareItemList = hardwareItemList;
	}
	
}
