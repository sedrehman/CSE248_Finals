package testCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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
	
	public void setLeftList(ActionEvent event) {     //need the action event to be used by a button
		theList.getItems().clear();
		ls.setItems();
		theList.getItems().addAll(ls.getItems());
		
	}
	
	public void setRightList(ActionEvent event) {     //need the action event to be used by a button
		theList.getItems().clear();
		rs.setItems();
		theList.getItems().addAll(rs.getItems());
		
	}
}
