package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Order {
	private ArrayList<Item> itemList;
	private final String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(
			Calendar.getInstance().getTime());
	private double price;
	
	
}
