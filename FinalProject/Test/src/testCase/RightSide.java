package testCase;

import java.util.ArrayList;

public class RightSide {
private ArrayList<String> items = new ArrayList<>();
	
	public void setItems() {
		items.clear();
		items.add("one_");
		items.add("two_");
		items.add("three_");
		items.add("four_");
		items.add("five_");
		
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}
	
}
