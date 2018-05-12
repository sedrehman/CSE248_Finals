package application;

public class FurnitureItems extends Item{
	private String length;
	private String width;
	private String height;
	private String weight;
	private String material;
	
	public FurnitureItems(String name, double price, int itemNumber, String stockLocation, int quantity,
			String otherInfo, String brand, String safety, String length, String width, String height, String weight,
			String material) {
		super(name, price, itemNumber, stockLocation, quantity, otherInfo, brand, safety);
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.material = material;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return  super.toString()+ "FurnitureItems [length=" + length + ", width=" + width + ", height=" + height + ", weight=" + weight
				+ ", material=" + material + "]";
	}
	
	
}
