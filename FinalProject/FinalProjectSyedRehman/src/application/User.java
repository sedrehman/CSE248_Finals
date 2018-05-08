package application;

import java.util.ArrayList;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private String cartItems;
	private String orders;
	public User(String firstName, String lastName, String email, String password, String address, String cartItems,
			String orders) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.cartItems = cartItems;
		this.orders = orders;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCartItems() {
		return cartItems;
	}
	public void setCartItems(String cartItems) {
		this.cartItems = cartItems;
	}
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", cartItems=" + cartItems + ", orders=" + orders + "]";
	}
	
	
}
