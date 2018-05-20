package application2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class MainWindowController implements Initializable{
	@FXML
    private AnchorPane ap;

    @FXML
    private WebView web;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button orderButton;
    
    @FXML
	private ObservableList<String> obList = FXCollections.observableArrayList();
	@FXML
	private ListView<String> itemList = new ListView<>(obList);
    
    @FXML
    void addItems(ActionEvent event) {
    		AddItemController aic = new AddItemController();
    		ap.getChildren().clear();
    		ap.getChildren().add(aic.getPane());
    }

    @FXML
    void getOrders(ActionEvent event) {

    }

    @FXML
    void removeItems(ActionEvent event) {

    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	private void cleaningMethod() {
		addButton.setStyle("-fx-background-color: transparent; ");
		removeButton.setStyle("-fx-background-color: transparent; ");
		orderButton.setStyle("-fx-background-color: transparent; ");
		// done clearing out the buttons;

		ap.getChildren().clear(); // clears whats in ap;
		itemList.getItems().clear(); // clears out itemList;
		itemList.getSelectionModel().clearSelection(); // clears out the itemList and obList first.
		obList.clear();
		// now the itemList and the pane is clean to work on.!
	}
	
}
