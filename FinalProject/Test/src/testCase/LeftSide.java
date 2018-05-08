package testCase;

import java.util.ArrayList;

public class LeftSide {
	//this is how the departments need to be
	
	private ArrayList<String> items = new ArrayList<>();
	
	public void setItems() {
		items.clear();
		items.add("_one");
		items.add("_two");
		items.add("_three");
		items.add("_four");
		items.add("_five");
		
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}
	
	
	
}
