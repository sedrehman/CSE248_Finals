package application;

import java.util.ArrayList;

public class Orderlist {
	private ArrayList<Order> orderList;
	
	public Orderlist(ArrayList<Order> orderList) {
		super();
		this.orderList = orderList;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		String allOrders = "";
		for(int i = 0; i< orderList.size(); i++) {
			allOrders += orderList.get(i).toString() + "\n";
		}
		return allOrders;
	}
	
}
