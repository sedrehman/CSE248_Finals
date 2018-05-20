package application;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class CartControl implements Initializable{
	private final double tax = .08786;
	private static double gt = 0;
	private static double total;
	@FXML
	AnchorPane mainPane;
	@FXML
	TableView<CartItem> table;
	@FXML 
	TableColumn<CartItem, String> nameColumn;
	@FXML 
	TableColumn<CartItem, Integer> quantityColumn;
	@FXML 
	TableColumn<CartItem, Double> priceColumn;
	@FXML
	Button remove;
	@FXML
	Button Order;
	@FXML
	TextField totalField;
	@FXML
	TextField taxField;
	@FXML
	TextField grandTotalField;
	
	private CartModel cm = new CartModel();
	private DepartmentControl dc = new DepartmentControl();
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(int i = 0; i< cm.getCartItemList().size(); i++) {
			System.out.println(cm.getCartItemList().get(i));
		}
		//setting what data to look for
		nameColumn.setCellValueFactory(new PropertyValueFactory<CartItem, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<CartItem, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<CartItem, Double>("price"));
        
        //load  data
        //table = new TableView<>();
        table.setItems(getItems());
        //table.getColumns().addAll(nameColumn, brandColumn, quantityColumn, priceColumn);
        //not editable !
        table.setEditable(false);
        
        //This will allow the table to select multiple rows at once
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Disable the detailed person view button until a row is selected
		this.remove.setDisable(true);
		
		total = cm.getTotalPrice();
		double temp = cm.getTotalPrice() * tax;
		gt = cm.getTotalPrice() + temp;
		DecimalFormat df2 = new DecimalFormat(".##");
		totalField.setText(df2.format(total));
		taxField.setText(df2.format(temp));
		grandTotalField.setText(df2.format(gt));

	}

	public ObservableList<CartItem> getItems() {
		ObservableList<CartItem> itemList = FXCollections.observableArrayList();
		if (cm.getCartItemList().size() != 0) {
			for (int i = 0; i < cm.getCartItemList().size(); i++) {
				itemList.add(cm.getCartItemList().get(i));
			}
		}
		return itemList;
	}

	public Parent getPane() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}
	
	public void placeOrder(ActionEvent event) {
		if (total == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setContentText("You must add items first!!");
			alert.showAndWait();
		}else {
			
		}
	}
}
