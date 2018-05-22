package application2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ToggleGroup;

public class AddItemController implements Initializable {



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
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private Label result;

    @FXML
    private RadioButton bathroom;

    @FXML
    private ToggleGroup Department;

    @FXML
    private RadioButton building;

    @FXML
    private RadioButton hardware;

    @FXML
    private RadioButton furniture;

    @FXML
    private RadioButton electronics;

    @FXML
    private RadioButton outdoor;

    @FXML
    private RadioButton kitchen;

    @FXML
    private TextField decimal;

	
	
	public void addButtonClicked(ActionEvent event) {
		
		if (name.getText().equals(null) || name.getText().equals("") || price.getText().equals(null)
				|| price.getText().equals("") || stockLocation.getText().equals(null)
				|| stockLocation.getText().equals("") || quantity.getText().equals(null)
				|| quantity.getText().equals("") || (!bathroom.isSelected() && !building.isSelected()
				&& !electronics.isSelected() && !furniture.isSelected() && !hardware.isSelected() && !kitchen.isSelected()
				&& !outdoor.isSelected())) {
			result.setText("Name, Price, Stock Location, Quantity must be filled and choose a Department");
			
		} else {
			
			SaveItem si = new SaveItem();
			double thePrice = Double.parseDouble(price.getText()) ;
			if(decimal.getText() != null && !decimal.getText().isEmpty()) {
				String some = decimal.getText();
				String[] a = some.split("");
				String some2 = a[0]+ a[1];
				double num = Double.parseDouble(some2);
				num = (num/100);
				thePrice += num;
			}
			si.saveTheItems(name.getText(), thePrice, stockLocation.getText(),
					Integer.parseInt(quantity.getText()), otherInfo.getText(), brand.getText(), safety.getText());
			result.setText("Added!");
			if (bathroom.isSelected()) {
				BathroomDepartment bd = new BathroomDepartment();
				bd.saveBathroomItems(name.getText());
			}
			if (building.isSelected()) {
				BuildingDepartment bd = new BuildingDepartment();
				bd.saveBuildingItems(name.getText());
			}
			if (electronics.isSelected()) {
				ElectronicsDepartment bd = new ElectronicsDepartment();
				bd.saveElectronicsItems(name.getText());
			}
			if (furniture.isSelected()) {
				FurnitureDepartment bd = new FurnitureDepartment();
				bd.saveFurnitureItems(name.getText());
			}
			if (hardware.isSelected()) {
				HardwareDepartment bd = new HardwareDepartment();
				bd.saveHardwareItems(name.getText());
			}
			if (kitchen.isSelected()) {
				KitchenDepartment bd = new KitchenDepartment();
				bd.saveKitchenItems(name.getText());
			}
			if (outdoor.isSelected()) {
				OutdoorDepartment bd = new OutdoorDepartment();
				bd.saveOutdoorItems(name.getText());
			}
			name.clear();
			price.clear();
			stockLocation.clear();
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
			outdoor.setSelected(false);
		}
		
	}

	
	public void clearButtonClicked(ActionEvent event) {
		name.clear();
		price.clear();
		stockLocation.clear();
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
		outdoor.setSelected(false);

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
		quantity.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					quantity.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		price.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) { // if it doesn't match decimal then allow it
					price.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		
		decimal.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) { // if it doesn't match decimal then allow it
					decimal.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		
	}

}
