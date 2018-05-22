package application;

import java.util.ArrayList;

public class SearchControl {
	public LoadItems li = new LoadItems();
	
	public ArrayList<String> getItems(String search){
		li.loadTheItems();
		int size = li.getItemNames().size();
		if(size == 0) {
			System.out.println("size is 0");
		}
		ArrayList<String> sr = new ArrayList<>();
		for(int i = 0; i< size; i++) {
			String temp = li.getItemNames().get(i);
			String[] tempChar = temp.split("");
			String[] searchChar = search.split("");
			if(searchChar.length>=2) {
				if(tempChar[0].equals(searchChar[0]) && tempChar[1].equals(searchChar[1])) {
					sr.add(temp);
				}
			}
			
		}
		return sr;
	}
}
