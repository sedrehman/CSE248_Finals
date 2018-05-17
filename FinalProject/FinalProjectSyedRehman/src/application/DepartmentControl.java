package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class DepartmentControl {
	@FXML
	private Button homeButton = new Button(" home ");
	@FXML
	private Button bathroomButton = new Button(" Bathroom ");
	@FXML
	private Button buildingButton = new Button(" Building Materials ");
	@FXML
	private Button electronicButton = new Button(" Electronics ");
	@FXML
	private Button furnitureButton = new Button(" Furnitures ");
	@FXML
	private Button hardwareButton = new Button(" Hardware ");
	@FXML
	private Button kitchenButton = new Button(" Kitchen ");
	@FXML
	private Button outdoorButton = new Button(" Outdoors ");
	private HomeDisplay hd = new HomeDisplay();
	@FXML
	private Pane ap = hd.getHomePane();//DisplayAP.getAp();
	//"-fx-background-color: #9FB2C4; "
	
	//ap = hd.
	
	@FXML 
	private ObservableList<String> obList = FXCollections.observableArrayList();
	@FXML 
	private ListView<String> itemList = new ListView<>(obList);
	
	private ItemDisplay itemDisplay = new ItemDisplay();
	private LoadItems loadItems = new LoadItems();
	public static Item chosenItem;
	private CartModel cart = new CartModel();
	
	public void homeSet(ActionEvent event) {
		cleaningMethod();
		VBox webVpane = new VBox();
		webVpane.setPrefSize(572, 457);
		WebView web = new WebView();
		WebEngine engine = web.getEngine();
		engine.load("https://www.habitat.org/");
		webVpane.getChildren().add(web);
		ap.getChildren().add(webVpane);
	}
	
	public void bathroomSet(ActionEvent event) {
		cleaningMethod();
		bathroomButton.setStyle("-fx-background-color: #9FB2C4; ");
		BathroomDepartment bathroomDep = new BathroomDepartment();	
		bathroomDep.loadBathroomItems();		//loads the bathroom Items;
		for(int i = 0; i< bathroomDep.getItemList().size(); i++) {
			obList.add(bathroomDep.getItemList().get(i).getName());
		}
		//added the bathroom items to the list.
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		//added the list to the pane!
		
		itemSelected();	//this is when someone selects an item!
	}
	
	public void buildingSet(ActionEvent event) {
		cleaningMethod();
		buildingButton.setStyle("-fx-background-color: #9FB2C4; ");
		BuildingDepartment buildingDep = new BuildingDepartment();	
		buildingDep.LoadTheItems();
		for(int i = 0; i< buildingDep.getItemList().size(); i++) {
			obList.add(buildingDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		itemSelected();	//this is when someone selects an item!
	}
	
	public void electronicsSet(ActionEvent event) {
		cleaningMethod();
		electronicButton.setStyle("-fx-background-color: #9FB2C4; ");
		ElectronicsDepartment electronicsDep = new ElectronicsDepartment();	
		electronicsDep.LoadTheItems();
		for(int i = 0; i< electronicsDep.getItemList().size(); i++) {
			obList.add(electronicsDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		itemSelected();	//this is when someone selects an item!
	}
	
	public void furnitureSet(ActionEvent event) {
		cleaningMethod();
		furnitureButton.setStyle("-fx-background-color: #9FB2C4; ");
		FurnitureDepartment furnitureDep = new FurnitureDepartment();	
		furnitureDep.LoadTheItems();
		for(int i = 0; i< furnitureDep.getItemList().size(); i++) {
			obList.add(furnitureDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		itemSelected();	//this is when someone selects an item!
	}
	
	public void hardwareSet(ActionEvent event) {
		cleaningMethod();
		hardwareButton.setStyle("-fx-background-color: #9FB2C4; ");
		HardwareDepartment hardwareDep = new HardwareDepartment();	
		hardwareDep.LoadTheItems();
		for(int i = 0; i< hardwareDep.getItemList().size(); i++) {
			obList.add(hardwareDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		itemSelected();	//this is when someone selects an item!
	}
	
	public void kitchenSet(ActionEvent event) {
		cleaningMethod();
		kitchenButton.setStyle("-fx-background-color: #9FB2C4; ");
		KitchenDepartment kitchenDep = new KitchenDepartment();	
		kitchenDep.LoadTheItems();
		for(int i = 0; i< kitchenDep.getItemList().size(); i++) {
			obList.add(kitchenDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		itemSelected();	//this is when someone selects an item!
	}
	
	public void outdoorSet(ActionEvent event) {
		cleaningMethod();
		outdoorButton.setStyle("-fx-background-color: #9FB2C4; ");
		OutdoorDepartment outdoorDep = new OutdoorDepartment();	
		outdoorDep.LoadTheItems();
		for(int i = 0; i< outdoorDep.getItemList().size(); i++) {
			obList.add(outdoorDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		itemSelected();	//this is when someone selects an item!
	}
	
	
	
	
	private void itemSelected() {
		//only used after the items HAVE been set. 
		//if clicked then the ap will change to the itemDisplay!
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				//newValue is just a String here. Its the name of the item;
				ap.getChildren().clear();
				chosenItem = loadItems.getItem(newValue);	//takes the newValue and find the item with that name;
				Pane pane = itemDisplay.itemDisplayPane(chosenItem, cart);
				ap.getChildren().add(pane);
				
			}else {
				//nada
			}
		});
	}
	
	private void cleaningMethod() {
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		//done clearing out the buttons;
		
		ap.getChildren().clear(); //clears whats in ap;
		itemList.getItems().clear();		//clears out itemList;
		itemList.getSelectionModel().clearSelection();     //clears out the itemList and obList first.		
		obList.clear();	
		//now the itemList and the pane is clean to work on.!
	}
	
	
	
}
