package application;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CartModel {
	private ArrayList<Item> itemList = new ArrayList<>();
	
	
	public void addtoCart(Item item) {
		if(item.getQuantity()>= 0){
			itemList.add(item);
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Opps!!");
			alert.setHeaderText(null);
			alert.setContentText("Out of inventory! SORRY !");

			alert.showAndWait();
		}
	}
	public void removeItem(Item item) {
		for(int i = 0; i< itemList.size() ; i++) {
			if(itemList.get(i).getName().equals(item.getName())) {
				itemList.remove(i);
			}
		}
	}
	// just add items to itemList as you hit add on the itemList.. 
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "CartModel [Items=" + itemList + "]";
	}
	
	
}
