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
	private User user;
	private LoginModel loginModel = new LoginModel();
	private DepartmentControl dc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(loginModel.isConnected()) {	//if connection is open
			//isConnectedLabel.setText("Connected");
			user = loginModel.getUser();
			dc.setUser(user);
		}else {
			//isConnectedLabel.setText("Not Connected");
		}
	}
	
	public void login(String userName, String password) {
		if(loginModel.isLogin(userName, password)) {
			//isConnectedLabel.setText("logged in!");
		}else {
			//isConnectedLabel.setText("not logged in");
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
