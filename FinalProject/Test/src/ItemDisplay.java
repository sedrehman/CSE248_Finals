

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
	private VBox vPane ;
	private AnchorPane mainPane;
	private AnchorPane imgPane;
	
	public ItemDisplay() {
		//empty parameter;
	}
	
	public Pane itemDisplayPane(Item item) {
		mainPane = new AnchorPane();
		mainPane.setPrefHeight(380);
		mainPane.setPrefWidth(500);
		mainPane.setStyle("-fx-background-color: lightBlue; ");
		
		imgPane = new AnchorPane();
		imgPane.setLayoutX(14);
		imgPane.setLayoutY(46);
		imgPane.setStyle("-fx-background-color: #4D4126; ");
		imgPane.prefHeight(292);
		imgPane.prefWidth(284);
		
		Image img = new Image("logInLogo.jpg");
		ImageView iv = new ImageView(img);
		iv.setFitHeight(256);
		iv.setFitWidth(250);
		iv.setLayoutX(13);
		iv.setLayoutY(15);
		imgPane.getChildren().add(iv);
		
		vPane = new VBox(10);
		vPane.setPadding(new Insets(10,10,10,10));
		vPane.setLayoutX(322);
		vPane.setLayoutY(46);
		vPane.setPrefHeight(276);
		vPane.setPrefWidth(154);
		
		name = new Label();
		price = new Label();
		itemNumber = new Label();
		stockLocation = new Label();
		quantity = new Label();
		otherInfo = new Label();
		brand = new Label();
		safety = new Label();
		add = new Button("Add to Cart");
		add.setOnAction(e->{
			
		});
		
		name.setText(item.getName());
		price.setText("IN USD: $"+Double.toString(item.getPrice()));
		itemNumber.setText("Item Number : "+Integer.toString(item.getItemNumber()));
		stockLocation.setText(item.getStockLocation());
		quantity.setText("Quantity : "+Integer.toString(item.getQuantity()));
		otherInfo.setText(item.getOtherInfo());
		brand.setText(item.getBrand());
		safety.setText(item.getSafety());
		add.setStyle("-fx-background-color: #119296; ");
		vPane.getChildren().addAll(name, price, itemNumber, quantity, safety , stockLocation, otherInfo, add);
		
		ImageView iv2 = new ImageView(new Image("bottomLogo.png"));
		iv2.setFitHeight(49);
		iv2.setFitWidth(501);
		
		mainPane.getChildren().addAll(iv2,imgPane, vPane);
		
		return mainPane;
	}
	

}
