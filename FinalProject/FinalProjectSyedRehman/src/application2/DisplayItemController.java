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

   
    
    public static Item item;
    

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
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Label result;

    @FXML
    private TextField decimal;

    
    @FXML
    void deleteButtonClicked(ActionEvent event) {
    		// user the item and not the textField texts!!!
    		DeleteItems di = new DeleteItems();
    		if(di.deleteFronDepartments(item.getName())) {
    			di.delete(item.getItemNumber());
    		}
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
    	if (name.getText().equals(null) || name.getText().equals("") || price.getText().equals(null)
				|| price.getText().equals("") || stockLocation.getText().equals(null)
				|| stockLocation.getText().equals("") || quantity.getText().equals(null)
				|| quantity.getText().equals("")) {
			result.setText("Name, Price, Stock Location, Quantity must be filled and choose a Department");
			
		}else {
    			UpdateItems ui = new UpdateItems();
    			ui.update(name.getText(), Double.parseDouble(price.getText()), item.getItemNumber(), stockLocation.getText(), 
    					Integer.parseInt(quantity.getText()), otherInfo.getText(), brand.getText(), safety.getText());
    			result.setText("Item Updated");
		}
    }
    
    public static Parent getPane() {
		Parent root = null;
		try {
			root = FXMLLoader.load(DisplayItemController.class.getResource("ItemDisplay.fxml"));
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
			if(item.getOtherInfo() != null) {
				otherInfo.setText(item.getOtherInfo());
			}else {
				otherInfo.setText("");
				System.out.println("fart");
			}
			if(item.getBrand() != null) {
				brand.setText(item.getBrand());
			}else {
				brand.setText("");
			}
			if(item.getSafety() != null) {
				safety.setText(item.getSafety());
			}else {
				safety.setText("");
			}
			
		}
		
	}

}
