package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ProfileViewController implements Initializable{

	@FXML
	AnchorPane mainPane;
	@FXML
	TextField fName;
	@FXML
	TextField lName;
	@FXML
	TextField add1;
	@FXML
	TextField add2;
	@FXML
	TextField email;
	@FXML
	TextField password;
	@FXML
	Button button;
	@FXML
	Label lbl;
	private User user;
	DepartmentControl dmc = new DepartmentControl();
	
	public void update(ActionEvent event) {
		UpdateUserModel uum = new UpdateUserModel();
		if(fName.getText().equals(null) || fName.getText().equals("") || lName.getText().equals(null)|| lName.getText().equals("") 
				||add1.getText().equals(null)||add1.getText().equals("") || add2.getText().equals(null)||add2.getText().equals("")
				|| email.getText().equals(null)||email.getText().equals("") || password.getText().equals(null)
				|| password.getText().equals("")) {   
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("All information must be entered !");
			alert.showAndWait();
		}else {
			String address = add1.getText() + " & " + add2.getText();
	 		uum.update(fName.getText(), lName.getText(), email.getText(), password.getText(), 
					address, user.getCartItems(), user.getOrders());
	 		user.setFirstName(fName.getText());
	 		user.setLastName(lName.getText());
	 		user.setPassword(password.getText());
	 		user.setAddress(address);
	 		//can not change email
	 		address = "";
	 		dmc.setUser(user);
		}
		
		
	}
	
	public Parent getPane() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		user = dmc.getUser();
		fName.setText(user.getFirstName());
		lName.setText(user.getLastName());
		String[] address = user.getAddress().split(" & ");
		if(address.length>1) {
			add1.setText(address[0]);
			add2.setText(address[1]);
		}else {
			add1.setText(user.getAddress());
		}
		email.setText(user.getEmail());
		password.setText(user.getPassword());
	}

}
