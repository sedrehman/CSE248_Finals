package application2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DisplayItemController implements Initializable{

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField stockLocation;

    @FXML
    private TextField quantity;

    @FXML
    private TextArea otherInfo;

    @FXML
    private TextField brand;

    @FXML
    private TextField safety;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Label result;
    
    public static Item item = MainWindowController.chosenItem;
    
    @FXML
    void daleteButtonClicked(ActionEvent event) {
    		DeleteItems di = new DeleteItems();
    		di.deleteFronDepartments(item.getName());
    		di.delete(item.getItemNumber());
    		name.clear();
    		price.clear();
    		stockLocation.clear();
    		quantity.clear();
    		otherInfo.clear();
    		brand.clear();
    		safety.clear();
    		result.setText("Deleted! ");
    }

    @FXML
    void updateButtonClicked(ActionEvent event) {
    		UpdateItems ui = new UpdateItems();
    		ui.update(name.getText(), Double.parseDouble(price.getText()), item.getItemNumber(), stockLocation.getText(), 
    				Integer.parseInt(quantity.getText()), otherInfo.getText(), brand.getText(), safety.getText());
    		result.setText("Item Updated");
    }
    
    public Parent getPane() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("ItemDisplay.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return root;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(item != null) {
			name.setText(item.getName());
			price.setText(Double.toString(item.getPrice()));
			stockLocation.setText(item.getStockLocation());
			quantity.setText(Integer.toString(item.getQuantity()));
			otherInfo.setText(item.getOtherInfo());
			brand.setText(item.getBrand());
			safety.setText(item.getSafety());
		}
		
	}

}
