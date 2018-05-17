package application;

public class BathroomItem extends Item{
	private String purpose;
	private String material;
	
	public BathroomItem(String name, double price, int itemNumber, String stockLocation, int quantity,
			String otherInfo, String brand, String safety, String purpose, String material) {
		super(name, price, itemNumber, stockLocation, quantity, otherInfo, brand, safety);
		this.purpose = purpose;
		this.material = material;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return super.toString()+ "BathroomItem [purpose=" + purpose + ", material=" + material + "]";
	}

	
	
}