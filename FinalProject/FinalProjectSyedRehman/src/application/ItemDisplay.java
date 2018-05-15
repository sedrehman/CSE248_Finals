package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ItemDisplay {
	private Label name;
	private Label price;
	private Label itemNumber;
	private Label stockLocation;
	private Label quantity;
	private Label otherInfo;
	private Label brand;
	private Label safety;
	private Button add;
	private VBox pane = new VBox();
	
	public ItemDisplay() {
		//empty parameter;
	}
	
	public VBox getItemDisplay(Item item) {
		pane.setPadding(new Insets(10,10,10,10));
		name = new Label();
		price = new Label();
		itemNumber = new Label();
		stockLocation = new Label();
		quantity = new Label();
		otherInfo = new Label();
		brand = new Label();
		safety = new Label();
		add = new Button("Add to Cart");
		
		name.setText(item.getName());
		price.setText(Integer.toString((int) item.getPrice()));
		itemNumber.setText(Integer.toString((int) item.getItemNumber()));
		stockLocation.setText(item.getStockLocation());
		quantity.setText(Integer.toString((int) item.getQuantity()));
		otherInfo.setText(item.getOtherInfo());
		brand.setText(item.getBrand());
		safety.setText(item.getSafety());
		add.setStyle("-fx-background-color: transparent; ");
		pane.getChildren().clear();
		pane.getChildren().addAll(name, price, itemNumber, stockLocation, quantity, otherInfo, safety, add);
		return pane;
	}
}
