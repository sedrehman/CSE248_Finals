package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import p1.SQLConnection;

public class OutdoorDepartment {
	private ArrayList <String> outdoorItemList = new ArrayList<>();
	Connection conn = SQLConnection.connect();
	
	public void LoadTheItems() {
		String sql = "SELECT * FROM Outdoor_Items";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				outdoorItemList.add(name);
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}

	public ArrayList<String> getOutdoorItemList() {
		return outdoorItemList;
	}

	public void setOutdoorItemList(ArrayList<String> outdoorItemList) {
		this.outdoorItemList = outdoorItemList;
	}
	
}
