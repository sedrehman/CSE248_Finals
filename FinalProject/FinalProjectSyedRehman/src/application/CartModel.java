package application;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CartModel {
	// private ListView<>
	private static ArrayList<CartItem> cartItemList = new ArrayList<>();
	private static ArrayList<Item> itemsForOrder = new ArrayList<>();
	private static double totalPrice = 0;
	
	public void addtoCart(Item item) {
		cartItemList.add(new CartItem(item.getName(), 1, item.getPrice()));
		totalPrice += item.getPrice();
		itemsForOrder.add(item);
	}

	public void removeItem(Item item) {
		for (int i = 0; i < cartItemList.size(); i++) {
			if (cartItemList.get(i).getName().equals(item.getName())) {
				cartItemList.remove(i);
			}
		}
	}


	public ArrayList<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(ArrayList<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		CartModel.totalPrice = totalPrice;
	}

	
	
	
}
