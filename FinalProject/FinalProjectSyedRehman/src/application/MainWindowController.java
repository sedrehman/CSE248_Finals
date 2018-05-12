package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class MainWindowController {
	private BathroomDepartment bathroomDep = new BathroomDepartment();
	private BuildingDepartment buildingDep = new BuildingDepartment();
	private ElectronicsDepartment electronicDep = new ElectronicsDepartment();
	private FurnitureDepartment furnitureDep = new FurnitureDepartment();
	private HardwareDepartment hardwareDep = new HardwareDepartment();
	private KitchenDepartment kitchengDep = new KitchenDepartment();
	private OutdoorDepartment outdoorDep = new OutdoorDepartment();

	@FXML
	private ObservableList<String> articleObvList = FXCollections.observableArrayList();
	@FXML
	private ListView<String> departmentListView = new ListView<String>(articleObvList);
	@FXML
	private AnchorPane ancorPane;
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
	
	public void setBathroom(ActionEvent event) {
		bathroomDep.LoadTheItems();		// this will connect in and load the items in  
	}
	
	public AnchorPane getAncorPane() {
		return ancorPane;
	}
	public void setAncorPane(AnchorPane ancorPane) {
		this.ancorPane = ancorPane;
	}
	
	
	

}
