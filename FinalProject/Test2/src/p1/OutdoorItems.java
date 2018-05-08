package p1;

public class OutdoorItems extends Item{
	private String material;
	private String purpose;
	
	public OutdoorItems(String name, double price, int itemNumber, String stockLocation, int quantity, String otherInfo,
			String brand, String safety, String material, String purpose) {
		super(name, price, itemNumber, stockLocation, quantity, otherInfo, brand, safety);
		this.material = material;
		this.purpose = purpose;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public String toString() {
		return super.toString()+ "OutdoorItems [material=" + material + ", purpose=" + purpose + "]";
	}
	
	
}
