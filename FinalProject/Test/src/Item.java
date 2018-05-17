

public class Item {
	private String name;
	private double price;
	private int itemNumber;
	private String StockLocation;
	private int quantity;
	private String otherInfo;
	private String brand;
	private String safety;
	
	public Item(String name, double price, int itemNumber, String stockLocation, int quantity, String otherInfo,
			String brand, String safety) {
		super();
		this.name = name;
		this.price = price;
		this.itemNumber = itemNumber;
		StockLocation = stockLocation;
		this.quantity = quantity;
		this.otherInfo = otherInfo;
		brand = brand;
		this.safety = safety;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getStockLocation() {
		return StockLocation;
	}

	public void setStockLocation(String stockLocation) {
		StockLocation = stockLocation;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSafety() {
		return safety;
	}

	public void setSafety(String safety) {
		this.safety = safety;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", itemNumber=" + itemNumber + ", StockLocation="
				+ StockLocation + ", quantity=" + quantity + ", otherInfo=" + otherInfo + ", Brand=" + brand
				+ ", safety=" + safety + "]";
	}
	
	
}
