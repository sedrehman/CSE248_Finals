package p1;

public class BuildingItems extends Item{
	
	private String content;
	private String purpose;
	private String warning;
	
	public BuildingItems(String name, double price, int itemNumber, String stockLocation, int quantity,
			String otherInfo, String brand, String safety, String content, String purpose, String warning) {
		super(name, price, itemNumber, stockLocation, quantity, otherInfo, brand, safety);
		this.content = content;
		this.purpose = purpose;
		this.warning = warning;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	@Override
	public String toString() {
		return super.toString()+ "BuildingItems [content=" + content + ", purpose=" + purpose + ", warning=" + warning + "]";
	}

	
}
