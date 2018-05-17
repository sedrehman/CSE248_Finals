package application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LoginView {
	private AnchorPane rootPane;
	private AnchorPane itemPane;
	private AnchorPane ap1;
	private AnchorPane ap2;
	private Label lEmail;
	private Label lPass;
	private TextField tEmail;
	private PasswordField pf;
	private Button loginButton;
	private Button createAccount;
	private Button forgotPassword;
	private LoginControl control;
	DepartmentControl dc = new DepartmentControl();
	
	//-fx-background-color: lightBlue; 
	public AnchorPane getLogInPane() {
		rootPane = new AnchorPane();
		rootPane.setStyle("-fx-background-color: #526B54;");
		rootPane.setPrefSize(610, 450);
		
		itemPane = new AnchorPane();
		itemPane.setStyle("-fx-background-color: #1B261C;");
		itemPane.setLayoutX(295);
		itemPane.setLayoutY(69);
		itemPane.setPrefSize(292,341);
		
		
		lEmail = new Label("Email:");
		lEmail.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
		lEmail.setLayoutX(31);
		lEmail.setLayoutY(36);
		lEmail.setPrefSize(50, 17);
		
		lPass = new Label("Password:");
		lPass.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
		lPass.setLayoutX(8);
		lPass.setLayoutY(70);
		lPass.setPrefSize(80, 17);
		
		tEmail = new TextField();
		tEmail.setStyle(" -fx-background-color: transparent; -fx-border-color: gray; -fx-text-fill: white;");
		tEmail.setLayoutX(86);
		tEmail.setLayoutY(30);
		tEmail.setPrefSize(183, 30);
		
		
		pf = new PasswordField();
		pf.setStyle("-fx-background-color: transparent; -fx-border-color: gray;");
		pf.setLayoutX(86);
		pf.setLayoutY(64);
		pf.setPrefSize(183, 30);
		
		loginButton = new Button("Log in!");
		loginButton.setStyle("-fx-background-color: transparent; -fx-border-color: green; -fx-text-fill: white");
		loginButton.setLayoutX(80);
		loginButton.setLayoutY(122);
		loginButton.setPrefSize(75, 30);
		loginButton.setOnAction(e->{
			control.login(tEmail.getText(), pf.getText());
		});
		
		createAccount = new Button("Create an Account!");
		createAccount.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
		createAccount.setLayoutX(77);
		createAccount.setLayoutY(195);
		createAccount.setOnAction(e->{
			
			dc.createAccount();
		});
		
		forgotPassword = new Button("Forgot password?");
		forgotPassword.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
		forgotPassword.setLayoutX(77);
		forgotPassword.setLayoutY(228);
		
		itemPane.getChildren().addAll(lEmail, lPass, tEmail, pf, loginButton, createAccount, forgotPassword);
		
		
		ap1 = new AnchorPane();
		ap1.setStyle("-fx-background-color: #003B05;");
		ap1.setPrefSize(200, 450);
		ap1.setLayoutX(77);
		ap1.setLayoutY(56);
		
		ap2 = new AnchorPane();
		ap2.setStyle("-fx-background-color: #266E2C;");
		ap2.setPrefSize(135, 444);
		ap2.setLayoutX(6);
		ap2.setLayoutY(6);
		
		rootPane.getChildren().addAll(ap1, ap2, itemPane);
		
		return rootPane;
	}
	
}
