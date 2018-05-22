package application2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import application.Order;
import application.SQLConnection;

public class LoadOrders {
	
	private Map <Integer, Order> orderMap = new HashMap<Integer, Order>();
	private ArrayList<Order> orderList = new ArrayList<>();
	Connection conn;
	
	public void loadTheOrders() {
		if(orderList.size()> 0) {
			orderList.clear();
		}
		if(orderMap.size()> 0) {
			orderMap.clear();
		}
		
		String sql = "SELECT * FROM OrderList";
		
		try {
			conn = SQLConnection.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//orderNumber,items,time,fullName,userAddress,creditCardNumber,Total
			while(rs.next()) {
				Order temp = new Order(rs.getInt("orderNumber"), rs.getString("items"), rs.getString("time"),
						rs.getString("fullName"), rs.getString("userAddress"), rs.getDouble("creditCardNumber"),
						 rs.getDouble("Total"));
				orderMap.put(temp.getOrderNum(), temp);
				orderList.add(temp);
			}
			stmt.close();
			conn.close();	// closing the connection to be ready for the next use just in case;
			
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}
	
	public Order getOrder(int orderNum) {
		if(orderMap.isEmpty()) {
			loadTheOrders();
			if (orderMap.isEmpty()){
				return null;
				}
			Order temp = orderMap.get(orderNum);
			return temp;
		}else {
			Order temp = orderMap.get(orderNum);
			return temp;
		}
	}

	public Map<Integer, Order> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<Integer, Order> orderMap) {
		this.orderMap = orderMap;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	
	
}
