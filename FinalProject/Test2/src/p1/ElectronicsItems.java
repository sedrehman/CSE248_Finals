package p1;

public class ElectronicsItems extends Item{
	private String modelNumber;
	private String catagory;
	
	public ElectronicsItems(String name, double price, int itemNumber, String stockLocation, int quantity,
			String otherInfo, String brand, String safety, String modelNumber, String catagory) {
		super(name, price, itemNumber, stockLocation, quantity, otherInfo, brand, safety);
		this.modelNumber = modelNumber;
		this.catagory = catagory;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	@Override
	public String toString() {
		return  super.toString()+ "ElectronicsItems [modelNumber=" + modelNumber + ", catagory=" + catagory + "]";
	}

	
}
