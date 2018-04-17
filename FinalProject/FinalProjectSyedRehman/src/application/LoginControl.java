package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControl implements Initializable{
	@FXML 
	private Label isConnectedLabel;
	@FXML
	private TextField userNameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button loginButton;
	
	private LoginModel loginModel = new LoginModel();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(loginModel.isConnected()) {	//if connection is open
			isConnectedLabel.setText("Connected");
		}else {
			isConnectedLabel.setText("Not Connected");
		}
	}
	
	public void login() {
		if(loginModel.isLogin(userNameField.getText(), passwordField.getText())) {
			isConnectedLabel.setText("logged in!");
		}else {
			isConnectedLabel.setText("not logged in");
		}
		
	}
	
	
	
}
