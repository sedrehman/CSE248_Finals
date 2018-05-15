package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class DepartmentControl {
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
	@FXML
	private AnchorPane ap = DisplayAP.getAp();
	//"-fx-background-color: #9FB2C4; "
	@FXML 
	private ObservableList<String> obList = FXCollections.observableArrayList();
	@FXML 
	private ListView<String> itemList = new ListView<>(obList);
	private ItemDisplay itemDisplay = new ItemDisplay();
	private LoadItems loadItems = new LoadItems();
	
	public void bathroomSet(ActionEvent event) {
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		
		ap.getChildren().clear();
		itemList.getItems().clear();
		itemList.getSelectionModel().clearSelection();     //clears out the itemList and obList first.
		obList.clear();
		bathroomButton.setStyle("-fx-background-color: #9FB2C4; ");
		BathroomDepartment bathroomDep = new BathroomDepartment();	
		bathroomDep.loadBathroomItems();
		for(int i = 0; i< bathroomDep.getItemList().size(); i++) {
			obList.add(bathroomDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				ap.getChildren().clear();
				Item a1 = loadItems.getItem(newValue);
				VBox pane = itemDisplay.getItemDisplay(a1);
				pane.setAlignment(Pos.CENTER);
				ap.getChildren().add(pane);
				
			}else {
				//nada
			}
		});
		
	}
	
	public void buildingSet(ActionEvent event) {
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		
		ap.getChildren().clear();
		itemList.getItems().clear();
		itemList.getSelectionModel().clearSelection();     //clears out the itemList and obList first.
		obList.clear();
		buildingButton.setStyle("-fx-background-color: #9FB2C4; ");
		BuildingDepartment buildingDep = new BuildingDepartment();	
		buildingDep.LoadTheItems();
		for(int i = 0; i< buildingDep.getItemList().size(); i++) {
			obList.add(buildingDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				ap.getChildren().clear();
				Item a1 = loadItems.getItem(newValue);
				VBox pane = itemDisplay.getItemDisplay(a1);
				pane.setAlignment(Pos.CENTER);
				ap.getChildren().add(pane);
				
			}else {
				//nada
			}
		});
		
	}
	
	public void electronicsSet(ActionEvent event) {
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		
		ap.getChildren().clear();
		itemList.getItems().clear();
		itemList.getSelectionModel().clearSelection();     //clears out the itemList and obList first.
		obList.clear();
		electronicButton.setStyle("-fx-background-color: #9FB2C4; ");
		ElectronicsDepartment electronicsDep = new ElectronicsDepartment();	
		electronicsDep.LoadTheItems();
		for(int i = 0; i< electronicsDep.getItemList().size(); i++) {
			obList.add(electronicsDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				ap.getChildren().clear();
				Item a1 = loadItems.getItem(newValue);
				VBox pane = itemDisplay.getItemDisplay(a1);
				pane.setAlignment(Pos.CENTER);
				ap.getChildren().add(pane);
				
			}else {
				//nada
			}
		});
	}
	
	public void furnitureSet(ActionEvent event) {
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		
		ap.getChildren().clear();
		itemList.getItems().clear();
		itemList.getSelectionModel().clearSelection();     //clears out the itemList and obList first.
		obList.clear();
		furnitureButton.setStyle("-fx-background-color: #9FB2C4; ");
		FurnitureDepartment furnitureDep = new FurnitureDepartment();	
		furnitureDep.LoadTheItems();
		for(int i = 0; i< furnitureDep.getItemList().size(); i++) {
			obList.add(furnitureDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				ap.getChildren().clear();
				Item a1 = loadItems.getItem(newValue);
				VBox pane = itemDisplay.getItemDisplay(a1);
				pane.setAlignment(Pos.CENTER);
				ap.getChildren().add(pane);
				
			}else {
				//nada
			}
		});
	}
	
	public void hardwareSet(ActionEvent event) {
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		
		ap.getChildren().clear();
		itemList.getItems().clear();
		itemList.getSelectionModel().clearSelection();     //clears out the itemList and obList first.
		obList.clear();
		hardwareButton.setStyle("-fx-background-color: #9FB2C4; ");
		HardwareDepartment hardwareDep = new HardwareDepartment();	
		hardwareDep.LoadTheItems();
		for(int i = 0; i< hardwareDep.getItemList().size(); i++) {
			obList.add(hardwareDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				ap.getChildren().clear();
				Item a1 = loadItems.getItem(newValue);
				VBox pane = itemDisplay.getItemDisplay(a1);
				pane.setAlignment(Pos.CENTER);
				ap.getChildren().add(pane);
				
			}else {
				//nada
			}
		});
	}
	
	public void kitchenSet(ActionEvent event) {
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		
		ap.getChildren().clear();
		itemList.getItems().clear();
		itemList.getSelectionModel().clearSelection();     //clears out the itemList and obList first.
		obList.clear();
		kitchenButton.setStyle("-fx-background-color: #9FB2C4; ");
		KitchenDepartment kitchenDep = new KitchenDepartment();	
		kitchenDep.LoadTheItems();
		for(int i = 0; i< kitchenDep.getItemList().size(); i++) {
			obList.add(kitchenDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				ap.getChildren().clear();
				Item a1 = loadItems.getItem(newValue);
				VBox pane = itemDisplay.getItemDisplay(a1);
				pane.setAlignment(Pos.CENTER);
				ap.getChildren().add(pane);
				
			}else {
				//nada
			}
		});
	}
	
	public void outdoorSet(ActionEvent event) {
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		
		ap.getChildren().clear();
		itemList.getItems().clear();
		itemList.getSelectionModel().clearSelection();     //clears out the itemList and obList first.
		obList.clear();
		outdoorButton.setStyle("-fx-background-color: #9FB2C4; ");
		OutdoorDepartment outdoorDep = new OutdoorDepartment();	
		outdoorDep.LoadTheItems();
		for(int i = 0; i< outdoorDep.getItemList().size(); i++) {
			obList.add(outdoorDep.getItemList().get(i).getName());
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				ap.getChildren().clear();
				Item a1 = loadItems.getItem(newValue);
				VBox pane = itemDisplay.getItemDisplay(a1);
				pane.setAlignment(Pos.CENTER);
				ap.getChildren().add(pane);
				
			}else {
				//nada
			}
		});
		}
	
	
}
