

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
	
	/*
	public void profileView(User user, Pane pane) {
		this.user = user ;
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("CreateAccountView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pane.getChildren().clear();
		pane.getChildren().addAll(root);
		
		fName.setText(user.getFirstName());
		lName.setText(user.getLastName());
		String[] address = user.getAddress().split(", ");
		add1.setText(address[0]);
		add1.setText(address[1]);
		email.setText(user.getEmail());
		password.setText(user.getPassword());
	}
	*/
	
	/*public ProfileViewController(User user) {
		this.user = user;
	}
	*/
	public Parent profileView() {
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
		/*
		user = dc.getUser();
		fName = new TextField(user.getFirstName());
		lName= new TextField(user.getLastName());
		String[] address = user.getAddress().split(", ");
		add1= new TextField(address[0]);
		add1= new TextField(address[1]);
		email= new TextField(user.getEmail());
		password= new TextField(user.getPassword());
		*/
	}
	
}
