package application;

public class HardwareItems extends Item{
	private String purpose;

	public HardwareItems(String name, double price, int itemNumber, String stockLocation, int quantity,
			String otherInfo, String brand, String safety, String purpose) {
		super(name, price, itemNumber, stockLocation, quantity, otherInfo, brand, safety);
		this.purpose = purpose;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public String toString() {
		return super.toString() + "HardwareItems [purpose=" + purpose + "]";
	}
	
	
}
