package application2;

import java.net.URL;
import java.util.ResourceBundle;

import application.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

public class MainWindowController implements Initializable{
	@FXML
	private Button home;
	
	@FXML
    private AnchorPane ap;

    @FXML
    private WebView web;

    @FXML
    private Button addButton;

    @FXML
    private Button orderButton;
    
    @FXML
	private ObservableList<String> obList = FXCollections.observableArrayList();
	@FXML
	private ListView<String> itemList = new ListView<>(obList);
    
	public static Item chosenItem;
	private LoadItems loadItems = new LoadItems();
	
    @FXML
    void addItems(ActionEvent event) {
    		cleaningMethod();
    		addButton.setStyle("-fx-background-color: #9FB2C4; ");
    		AddItemController aic = new AddItemController();
    		ap.getChildren().add(aic.getPane());
    }

    @FXML
    void getOrders(ActionEvent event) {
    		
    }
    
    public void homeButtonClicked(ActionEvent event) {
    		cleaningMethod();
		home.setStyle("-fx-background-color: #9FB2C4; ");
		loadItems.loadTheItems();
		for (int i = 0; i < loadItems.getItemNames().size(); i++) {
			obList.add(loadItems.getItemNames().get(i));
		}
		ap.getChildren().add(itemList);
		itemList.setPrefSize(ap.getWidth(), ap.getHeight());
		itemSelected(); // this is when someone selects an item!
		
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	private void cleaningMethod() {
		addButton.setStyle("-fx-background-color: transparent; ");
		home.setStyle("-fx-background-color: transparent; ");
		orderButton.setStyle("-fx-background-color: transparent; ");
		// done clearing out the buttons;

		ap.getChildren().clear(); // clears whats in ap;
		itemList.getItems().clear(); // clears out itemList;
		itemList.getSelectionModel().clearSelection(); // clears out the itemList and obList first.
		obList.clear();
		// now the itemList and the pane is clean to work on.!
	}
	private void itemSelected() {
		// only used after the items HAVE been set.
		// if clicked then the ap will change to the itemDisplay!
		itemList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				// newValue is just a String here. Its the name of the item;
				chosenItem = loadItems.getItem(newValue); // takes the newValue and find the item with that name;
				cleaningMethod(); // just clearning out the selectrions and buttons.. 
				//System.out.println(newValue);
				//System.out.println(chosenItem.toString());
				DisplayItemController dic = new DisplayItemController();
				ap.getChildren().add(dic.getPane());

			} else {
				// nada
			}
		});
	}
	
}
