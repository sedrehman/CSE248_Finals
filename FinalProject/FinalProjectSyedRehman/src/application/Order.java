package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Order {
	
	private int orderNum;
	private String items;
	private final String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(
			Calendar.getInstance().getTime());
	private String fullName;
	private String userAddress;
	private double creditCardNumber;
	private double total;
	public Order(String items, String fullName, String userAddress, double creditCardNumber,
			double total) {
		super();
		this.items = items;
		this.fullName = fullName;
		this.userAddress = userAddress;
		this.creditCardNumber = creditCardNumber;
		this.total = total;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public double getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(double creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	@Override
	public String toString() {
		return "Order [orderNum=" + orderNum + ", items=" + items + ", timeStamp=" + timeStamp + ", fullName="
				+ fullName + ", userAddress=" + userAddress + ", creditCardNumber=" + creditCardNumber + ", total="
				+ total + "]";
	}
	
	
}