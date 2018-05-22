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
		if(isBathroomItem(name)) {
			deleteBathroomItem(name);
			return true;
		}
		if(isBuildingItem(name)) {
			deleteBuildingItem(name);
			return true;
		}
		if(isElectronicsItem(name)) {
			deleteElectronicsItem(name);
			return true;
		}
		if(isHardwareItem(name)) {
			deleteHardwareItem(name);
			return true;
		}
		if(isFurnitureItem(name)) {
			deleteFurnitureItem(name);
			return true;
		}
		if(isKitchenItem(name)) {
			deleteKitchenItem(name);
			return true;
		}
		if(isOutdoorItem(name)) {
			deleteOutdoorItem(name);
			return true;
		}
		return false;
		
	}
	
	public void deleteBathroomItem(String name) {
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

	}

	public void deleteBuildingItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "DELETE FROM Building_Items WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteElectronicsItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "DELETE FROM Electronics_Items WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteFurnitureItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "DELETE FROM Furniture_Items WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteKitchenItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "DELETE FROM Kitchen_Items WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteHardwareItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "DELETE FROM Hardware_Items WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteOutdoorItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "DELETE FROM Outdoor_Items WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

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
				conn.close();
				return false;
			}
		} catch (Exception e) {
			System.out.println("problem is in is isElectronicsItems...");
		}
		return false;
	}
	
	public boolean isHardwareItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "select * from Hardware_Items where name = ?";
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
			System.out.println("problem is in is isHardwareItems...");
		}
		return false;
	}
	public boolean isFurnitureItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "select * from Furniture_Items where name = ?";
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
			System.out.println("problem is in is isFurnitureItems...");
		}
		return false;
	}
	public boolean isKitchenItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "select * from Kitchen_Items where name = ?";
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
			System.out.println("problem is in is isKitchenItems...");
		}
		return false;
	}
	
	public boolean isOutdoorItem(String name) {
		conn = SQLConnection.connect();
		try {
			String query = "select * from Outdoor_Items where name = ?";
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
