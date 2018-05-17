package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccountController implements Initializable{
	
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
	PasswordField password;
	@FXML
	Button button;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void buttonClicked(ActionEvent event) {
		System.out.println(fName.getText());
	}
	
}
