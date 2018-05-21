package application2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.User;

public class DeleteItems {
	Connection conn;
	
	public void delete(int itemNumber) {
		String query = "DELETE FROM ItemList WHERE itemNumber = ?";
		try {
			Connection conn = SQLConnection.connect();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNumber);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean deleteFronDepartments(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "DELETE FROM Bathroom_Items WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean isBathroomItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "select * from Bathroom_Items where name = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}
		} catch (Exception e) {
			System.out.println("problem is in is BathroomItems...");
		}
		return false;
	}
	
	public boolean isBuildingItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "select * from Building_Items where name = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}
		} catch (Exception e) {
			System.out.println("problem is in is isBuildingItems...");
		}
		return false;
	}
	
	public boolean isElectronicsItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "select * from Electronics_Items where name = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				conn.close();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("problem is in is isElectronicsItems...");
		}
		return false;
	}
}
