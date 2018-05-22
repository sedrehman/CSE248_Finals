package application;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
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
	AnchorPane tableRoot;
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
	@FXML
	Button save;
	@FXML
	TextField ccn;
	@FXML
	TextField sc;
	
	private CartModel cm = new CartModel();
	private DepartmentControl dc = new DepartmentControl();
	private User user = DepartmentControl.user;
	private static CartItem item;
	private LoadItems li = new LoadItems();
	private ObservableList<CartItem> itemList = FXCollections.observableArrayList();
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
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		// Disable the detailed person view button until a row is selected
		
		total = cm.getTotalPrice();
		double temp = cm.getTotalPrice() * tax;
		gt = cm.getTotalPrice() + temp;
		DecimalFormat df2 = new DecimalFormat(".##");
		totalField.setText(df2.format(total));
		taxField.setText(df2.format(temp));
		grandTotalField.setText(df2.format(gt));
		
		ccn.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) { // if it doesn't match decimal then allow it
					ccn.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		
		sc.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) { // if it doesn't match decimal then allow it
					sc.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		
	}

	public ObservableList<CartItem> getItems(){
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
		if(user != null) {
			if (total == 0 || ccn.getText()== null || ccn.getText().isEmpty()|| sc.getText() ==null || 
					sc.getText().isEmpty()) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error!");
				alert.setHeaderText(null);
				alert.setContentText("You must add items first!! and leave no blank");
				alert.showAndWait();
				
			}else {
				String allItems = "";
				int size = cm.getCartItemList().size();
				for(int i = 0; i< size; i++) {
					allItems += cm.getCartItemList().get(i).getName();
					if(i+1 != size) {
						allItems += ",";
					}
				}
				Order order = new Order(allItems, user.getFirstName() + " " + user.getLastName(), user.getAddress(),
						Double.parseDouble(ccn.getText()), total);
				SaveOrders so = new SaveOrders();
				so.saveOrder(order);
				cm.getCartItemList().clear();
				mainPane.getChildren().clear();
				Label lbl = new Label("Order Placed successfully");
				mainPane.getChildren().add(lbl);
			}
		}
	}
	
	public void removeButtonClicked(ActionEvent event) {
		item = table.getSelectionModel().getSelectedItem();
		if(item != null) {
			Item actualItem = li.getItem(item.getName());
			cm.removeItem(actualItem);
			itemList.clear();
			table.refresh();
			tableRoot.getChildren().clear();
			table.setItems(getItems());
			tableRoot.getChildren().add(table);
		}

	}
	
	public void saveForLater(ActionEvent event) {
		if(user != null && cm.getCartItemList().size() > 0) {
			String allItems = "";
			int size = cm.getCartItemList().size();
			for(int i = 0; i< size; i++) {
				allItems += cm.getCartItemList().get(i).getName();
				if(i+1 != size) {
					allItems += ",";
				}
			}
			UpdateUserModel uum = new UpdateUserModel();
			uum.update(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
					user.getAddress(), allItems, user.getOrders());
		}else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("You must log in first");
			alert.showAndWait();
		}
	}
	
	
	
}
