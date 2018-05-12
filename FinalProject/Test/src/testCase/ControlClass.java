package testCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class ControlClass {
	private ObservableList<String> theObserver = FXCollections.observableArrayList();
	@FXML
	private ListView<String> theList = new ListView<String>(theObserver);
	@FXML
	private Button btnLeft = new Button();
	@FXML
	private Button btnRight = new Button();
	private LeftSide ls = new LeftSide();
	private RightSide rs = new RightSide();
	@FXML
	private Button swithButton = new Button();
	@FXML
	private AnchorPane ap = APClass.getAp();
	
	public void setLeftList(ActionEvent event) {     //need the action event to be used by a button
		theList.getItems().clear();
		ls.setItems();
		theList.getItems().addAll(ls.getItems());
		ap.getChildren().clear();
		ap.getChildren().add(theList);
		theList.setPrefHeight(ap.getHeight());
		theList.setPrefWidth(ap.getWidth());
		btnLeft.setStyle("-fx-background-color: #9FB2C4; ");
		swithButton.setStyle("-fx-background-color: transparent; ");
		btnRight.setStyle("-fx-background-color: transparent; ");
	}
	
	public void setRightList(ActionEvent event) {     //need the action event to be used by a button
		theList.getItems().clear();
		rs.setItems();
		theList.getItems().addAll(rs.getItems());
		ap.getChildren().clear();
		ap.getChildren().add(theList);
		theList.setPrefHeight(ap.getHeight());
		theList.setPrefWidth(ap.getWidth());
		btnLeft.setStyle("-fx-background-color: transparent; ");
		swithButton.setStyle("-fx-background-color: transparent; ");
		btnRight.setStyle("-fx-background-color: #9FB2C4; ");
	}
	public void swithPane(ActionEvent event) {
		ap.getChildren().clear();
		btnLeft.setStyle("-fx-background-color: transparent; ");
		swithButton.setStyle("-fx-background-color: #9FB2C4; ");
		btnRight.setStyle("-fx-background-color: transparent; ");
	}
	
}
