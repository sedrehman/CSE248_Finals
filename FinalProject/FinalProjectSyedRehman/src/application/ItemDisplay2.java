package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ItemDisplay2 implements Initializable{
	@FXML
	private AnchorPane pane;//= new AnchorPane();
	@FXML
	private Label name;// = new Label();
	@FXML
	private Label price;// = new Label();
	@FXML
	private Label itemNumber;// = new Label();
	@FXML
	private Label stockLocation;// = new Label();
	@FXML
	private Label quantity;// = new Label();
	@FXML
	private Label otherInfo;// = new Label(); 
	@FXML
	private Label brand;// = new Label();
	@FXML
	private Label safety;// = new Label();
	@FXML 
	private Button addButton;// = new Button();
	
	Item item ;
	
	public ItemDisplay2() {
		super();
	}


	public AnchorPane getPane() {
		return pane;
	}


	public void setPane(AnchorPane pane) {
		this.pane = pane;
	}


	public Label getName() {
		return name;
	}


	public Label getPrice() {
		return price;
	}


	public Label getItemNumber() {
		return itemNumber;
	}


	public Label getStockLocation() {
		return stockLocation;
	}


	public Label getQuantity() {
		return quantity;
	}


	public Label getOtherInfo() {
		return otherInfo;
	}


	public Label getBrand() {
		return brand;
	}


	public Label getSafety() {
		return safety;
	}


	public Button getAddButton() {
		return addButton;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		item = DepartmentControl.chosenItem;
		name.setText(item.getName());
		price.setText(Double.toString(item.getPrice()));
		itemNumber.setText(Integer.toString(item.getItemNumber()));
		stockLocation.setText(item.getStockLocation());
		quantity.setText(Integer.toString(item.getQuantity()));
		brand.setText(item.getBrand());
		safety.setText(item.getSafety());
		otherInfo.setText(item.getOtherInfo());	
	}
	
	
	
}
