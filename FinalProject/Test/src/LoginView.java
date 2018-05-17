import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
	
	//-fx-background-color: lightBlue; 
	public void getLogInPane() {
		rootPane = new AnchorPane();
		rootPane.setStyle("-fx-background-color: #4A0A0A;");
		rootPane.setPrefSize(450, 610);
		
		itemPane = new AnchorPane();
		itemPane.setStyle("-fx-background-color: #351109;");
		itemPane.setPrefSize(341, 292);
		itemPane.setLayoutX(295);
		itemPane.setLayoutY(69);
		
		lEmail = new Label("Email:");
		lEmail.setStyle("-fx-background-color: transparent;");
		lEmail.setLayoutX(31);
		lEmail.setLayoutY(36);
		lEmail.setPrefSize(50, 17);
		
		lEmail = new Label("Password:");
		lEmail.setStyle("-fx-background-color: transparent;");
		lEmail.setLayoutX(31);
		lEmail.setLayoutY(36);
		lEmail.setPrefSize(50, 17);
		
		
		ap1 = new AnchorPane();
		ap1.setStyle("-fx-background-color: #231109;");
		ap1.setPrefSize(200, 450);
		ap1.setLayoutX(77);
		ap1.setLayoutY(56);
		
		ap2 = new AnchorPane();
		ap2.setStyle("-fx-background-color: #351109;");
		ap2.setPrefSize(135, 444);
		itemPane.setLayoutX(6);
		itemPane.setLayoutY(6);
	}
	
}
