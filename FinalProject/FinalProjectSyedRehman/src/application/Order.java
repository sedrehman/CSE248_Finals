package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Order {
	
	private final String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(
			Calendar.getInstance().getTime());
	private double price;
	private ArrayList<CartItem> items;
	private User user;
	
	public Order() {
		super();
	}
	public Order(User user, double price, ArrayList<CartItem> items) {
		super();
		this.price = price;
		this.items = items;
		this.user = user;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<CartItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [timeStamp=" + timeStamp + ", User=" + user.toString()+ ", price=" + price + ", items=" + items + "]";
	}
	
	
	
	
}
