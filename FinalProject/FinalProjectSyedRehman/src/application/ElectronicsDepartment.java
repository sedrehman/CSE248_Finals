package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import p1.SQLConnection;

public class ElectronicsDepartment {
	private ArrayList <String> electronicItemList = new ArrayList<>();
	Connection conn = SQLConnection.connect();
	
	public void LoadTheItems() {
		String sql = "SELECT * FROM Electronics_Items";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				electronicItemList.add(name);
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}

	public ArrayList<String> getElectronicItemList() {
		return electronicItemList;
	}

	public void setElectronicItemList(ArrayList<String> electronicItemList) {
		this.electronicItemList = electronicItemList;
	}
	
}
