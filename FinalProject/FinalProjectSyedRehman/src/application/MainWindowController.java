package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class MainWindowController {
	@FXML
	private ObservableList<String> articleObvList = FXCollections.observableArrayList();
	@FXML
	private ListView<String> departmentListView = new ListView<String>(articleObvList);
	@FXML
	private AnchorPane ancorPane;
	
	
	public void setDepartmentList() {
		//set all the 
	}
	
	public AnchorPane getAncorPane() {
		return ancorPane;
	}
	public void setAncorPane(AnchorPane ancorPane) {
		this.ancorPane = ancorPane;
	}
	
	
	

}
