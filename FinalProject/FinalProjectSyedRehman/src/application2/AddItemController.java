package application2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddItemController implements Initializable{

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField stackLocation;  //i know i spelled this wrong but i dont feel like changing it.. 

    @FXML
    private TextField quantity;

    @FXML
    private TextArea otherInfo;

    @FXML
    private TextField brand;

    @FXML
    private TextField safety;

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private RadioButton bathroom;

    @FXML
    private RadioButton building;

    @FXML
    private RadioButton hardware;

    @FXML
    private RadioButton kitchen;

    @FXML
    private RadioButton electronics;

    @FXML
    private RadioButton outdoors;
    
    @FXML 
    private RadioButton furniture;
    
    @FXML
    private Label result;

    @FXML
    void addButtonClicked(ActionEvent event) {
    		if(!name.getText().equals(null) || !name.getText().equals("") || !price.getText().equals(null)  || 
    				!price.getText().equals("") || !stackLocation.getText().equals(null)|| !stackLocation.getText().equals("") ||
    				!quantity.getText().equals(null) || !quantity.getText().equals("")|| bathroom.isSelected() ||
    				building.isSelected() || electronics.isSelected()|| furniture.isSelected()|| hardware.isSelected()||
    				kitchen.isSelected()|| outdoors.isSelected()){
    			SaveItem si = new SaveItem();
        		si.saveTheItems(name.getText(), Double.parseDouble(price.getText()), stackLocation.getText(), 
        				Integer.parseInt(quantity.getText()), otherInfo.getText(), brand.getText(), safety.getText());
        		result.setText("Added!");
        		if(bathroom.isSelected()) {
        			BathroomDepartment bd = new BathroomDepartment();
        			bd.saveBathroomItems(name.getText());
        		}
        		if(building.isSelected()) {
        			BuildingDepartment bd = new BuildingDepartment();
        			bd.saveBuildingItems(name.getText());
        		}
        		if(electronics.isSelected()) {
        			ElectronicsDepartment bd = new ElectronicsDepartment();
        			bd.saveElectronicsItems(name.getText());
        		}
        		if(furniture.isSelected()) {
        			FurnitureDepartment bd = new FurnitureDepartment();
        			bd.saveFurnitureItems(name.getText());
        		}
        		if(hardware.isSelected()) {
        			HardwareDepartment bd = new HardwareDepartment();
        			bd.saveHardwareItems(name.getText());
        		}
        		if(kitchen.isSelected()) {
        			KitchenDepartment bd = new KitchenDepartment();
        			bd.saveKitchenItems(name.getText());
        		}
        		if(outdoors.isSelected()) {
        			OutdoorDepartment bd = new OutdoorDepartment();
        			bd.saveOutdoorItems(name.getText());
        		}
        		name.clear();
        		price.clear();
        		stackLocation.clear();
        		quantity.clear();
        		otherInfo.clear();
        		brand.clear();
        		safety.clear();
        		
        		bathroom.setSelected(false);
        		building.setSelected(false);
        		electronics.setSelected(false);
        		furniture.setSelected(false);
        		hardware.setSelected(false);
        		kitchen.setSelected(false);
        		outdoors.setSelected(false);
        		
    		}else {
    			result.setText("Name, Price, Stock Location, Quantity must be filled and choose a Department");
    		}
    	
    }

    @FXML
    void clearButtonClicked(ActionEvent event) {
    		name.clear();
    		price.clear();
    		stackLocation.clear();
    		quantity.clear();
    		otherInfo.clear();
    		brand.clear();
    		safety.clear();
    		
    		bathroom.setSelected(false);
    		building.setSelected(false);
    		electronics.setSelected(false);
    		furniture.setSelected(false);
    		hardware.setSelected(false);
    		kitchen.setSelected(false);
    		outdoors.setSelected(false);
    		
    }

    public Parent getPane() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("AddItemView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}


	


