package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LogInWindow {
	private UserList mainUserList = new UserList();
	private Scene scene;
	private Label userNameLabel;
	private Label passwordLabel;
	private TextField userNameField;
	private Button logInButton;
	private Button createAnAccountButton;
	private GridPane pane;
	private PasswordField passwordField;
	
	public void show(Stage primaryStage){
		primaryStage.setOnCloseRequest(e->{
			primaryStage.close();
		});
		mainUserList.load();
		userNameLabel = new Label("User Name:");
		passwordLabel = new Label("Password:");
		userNameField = new TextField();
		userNameField.setPromptText("User Name .. ");
		passwordField = new PasswordField();
		passwordField.setPromptText("Password..  ");
		logInButton = new Button("Log In");
		logInButton.setOnAction(e->{
			User temp = mainUserList.logIn(userNameField.getText(), passwordField.getText());
			if(temp != null){
				AccountWindow aw = new AccountWindow();
				aw.display(primaryStage, temp, mainUserList);
			}else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(null);
				alert.setHeaderText(null);
				alert.setContentText("Incorrect userName or password !");
				alert.showAndWait();
			}
		});
		createAnAccountButton = new Button("Create New Account");
		createAnAccountButton.setOnAction(e->{
			NewAccountWindow naw = new NewAccountWindow();
			naw.window(primaryStage, mainUserList);
		});
		pane = new GridPane();
		pane.setPadding(new Insets(15,15,15,15));
		pane.addRow(0, userNameLabel, userNameField);
		pane.addRow(1, passwordLabel, passwordField);
		pane.addRow(2, logInButton, createAnAccountButton);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);
		pane.setVgap(15);
		pane.setStyle("-fx-background-color: lightgray");
		scene = new Scene(pane, 500,150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
