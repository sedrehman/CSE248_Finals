package application2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Button updateButton;

    @FXML
    private Button orderButton;

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

    @FXML
    void updateItems(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	cdcd
	private void cleaningMethod() {
		homeButton.setStyle("-fx-background-color: transparent; ");
		bathroomButton.setStyle("-fx-background-color: transparent; ");
		buildingButton.setStyle("-fx-background-color: transparent; ");
		electronicButton.setStyle("-fx-background-color: transparent; ");
		furnitureButton.setStyle("-fx-background-color: transparent; ");
		hardwareButton.setStyle("-fx-background-color: transparent; ");
		kitchenButton.setStyle("-fx-background-color: transparent; ");
		outdoorButton.setStyle("-fx-background-color: transparent; ");
		// done clearing out the buttons;

		ap.getChildren().clear(); // clears whats in ap;
		itemList.getItems().clear(); // clears out itemList;
		itemList.getSelectionModel().clearSelection(); // clears out the itemList and obList first.
		obList.clear();
		// now the itemList and the pane is clean to work on.!
	}
	
}
