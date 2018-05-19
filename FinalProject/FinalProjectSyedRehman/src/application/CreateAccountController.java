package application;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreateAccountController implements Initializable {

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
	PasswordField password;
	@FXML
	Button button;

	private User user;
	private CreateAccountModel cam = new CreateAccountModel();
	private DepartmentControl dCon = new DepartmentControl();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void buttonClicked(ActionEvent event) {
		String address = add1.getText() +" & "+ add2.getText();
		user = new User(fName.getText(), lName.getText(), email.getText(), password.getText(), address, "", "");
		cam.incert(fName.getText(), lName.getText(), email.getText(),address, password.getText(), "", "");
		
		System.out.println(user);
		dCon.setUser(user);
		mainPane.getChildren().clear();
		Label label = new Label("You've created an account");
		mainPane.getChildren().add(label);
	}

	public Parent createAccount() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("CreateAccountView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}

}
