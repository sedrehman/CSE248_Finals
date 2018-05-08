package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewAccountWindow {
	private Stage stage;
	private UserList list;
	
	public void window(Stage stage, UserList list){
		this.list = list;
		this.stage = stage;
		GridPane pane = new GridPane();
		Label userNameLabel = new Label("Email address: ");
		TextField userNameField = new TextField();
		userNameField.setMinWidth(200);
		userNameField.setMaxWidth(220);
		Label passwordLabel = new Label("Enter password: ");
		TextField passwordField = new TextField();
		passwordField.setPromptText("Must contain 1 Cap & 1 Lower case");
		passwordField.setMinWidth(200);
		passwordField.setMaxWidth(280);
		Label nickNameLabel = new Label("Enter your Nick name: ");
		TextField nickNameField = new TextField();
		
		CheckBox CBToyVoyaging = new CheckBox("Toy Voyaging");
		CBToyVoyaging.setUserData("Toy Voyaging");
		CBToyVoyaging.setSelected(true);
		
		CheckBox CBStoneSkipping = new CheckBox("Stone Skipping");
		CBStoneSkipping.setUserData("Stone Skipping");
		CBStoneSkipping.setSelected(true);
		
		CheckBox CBExtremeIroning = new CheckBox("Extreme Ironing");
		CBExtremeIroning.setUserData("Extreme Ironing");
		CBExtremeIroning.setSelected(true);
		
		CheckBox CBTreeShaping = new CheckBox("Tree Shaping");
		CBTreeShaping.setUserData("Tree Shaping");
		CBTreeShaping.setSelected(true);
		
		CheckBox CBNewsRaiding = new CheckBox("News Raiding");
		CBNewsRaiding.setUserData("News Raiding");
		CBNewsRaiding.setSelected(true);
		
		CheckBox CBTrainSurfing = new CheckBox("Train Surfing");
		CBTrainSurfing.setUserData("Train Surfing");
		CBTrainSurfing.setSelected(true);
		
		Button bCreate = new Button("Create!");
		bCreate.setOnAction(e-> {
			User account = create(userNameField.getText(), passwordField.getText(), nickNameField.getText(), CBToyVoyaging, 
					CBStoneSkipping, CBExtremeIroning, CBTreeShaping, CBNewsRaiding, CBTrainSurfing);
			if(!(account == null)){
				list.insert(account);
				AccountWindow aw = new AccountWindow();
				aw.display(stage, account, list);
			}
		});
		
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10,10,10,10));
		pane.addRow(0, userNameLabel, userNameField);
		pane.addRow(1, passwordLabel, passwordField);
		pane.addRow(2, nickNameLabel, nickNameField);
		pane.addRow(3, CBToyVoyaging);
		pane.addRow(4, CBStoneSkipping);
		pane.addRow(5, CBExtremeIroning);
		pane.addRow(6, CBTreeShaping);
		pane.addRow(7, CBNewsRaiding);
		pane.addRow(8, CBTrainSurfing);
		pane.addRow(9, bCreate);
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 500,400);
		stage.setScene(scene);
		stage.show();

	}

	private User create(String userName, String password, String nickName, CheckBox CBToyVoyaging,
			CheckBox CBStoneSkipping, CheckBox CBExtremeIroning, CheckBox CBTreeShaping, 
			CheckBox CBNewsRaiding, CheckBox CBTrainSurfing) {
		userName = userName.trim();
		password = password.trim();
		if(!(userName.contains("@")) && !(userName.contains(".com"))){
			// userName must be an email address.
			errorMessage("User Name", "Please enter a valid Email address");
			return null;
		}
		if(!list.checkUserName(userName)){
			// userName must be unique;
			errorMessage("User Name", "Please enter an Unique Email address");
			return null;
		}
		
		Pattern patt1 = Pattern.compile("[A-Z]");
		Matcher match1 = patt1.matcher(password);
		Pattern patt2 = Pattern.compile("[a-z]");
		Matcher match2 = patt2.matcher(password);
		if(password.contains(" ")){
			//passwords can't have any spaces.
			errorMessage("Password", "No spaces allowed in the password!");
			return null;
		}
		if(!match1.find()){
			//password must contain a Capital letter;
			errorMessage("Password", "Must contain a Capital letter in the password!");
			return null;
		}
		if(!match2.find()){
			//password must contain a lower-case letter;
			errorMessage("Password", "Must contain a Lower-case letter in the password!");
			return null;
		}
		if(nickName == null || nickName.equals(" ")){
			errorMessage("Nick Name", "Must enter your nick name");
		}
		int counter = 0;
		String temp = "";
		if(CBToyVoyaging.isSelected()){
			counter++;
			temp += "Toy Voyaging,";
		}
		if(CBStoneSkipping.isSelected()){
			counter++;
			temp += "Stone Skipping,";
		}
		if(CBExtremeIroning.isSelected()){
			counter++;
			temp += "Extreme Ironing,";
		}
		if(CBTreeShaping.isSelected()){
			counter++;
			temp += "Tree Shaping,";
		}
		if(CBNewsRaiding.isSelected()){
			counter++;
			temp += "News Raiding,";
		}
		if(CBTrainSurfing.isSelected()){
			counter++;
			temp += "Train Surfing,";
		}
		String[] hobbies = temp.split(",");	
		if(counter <1){
			errorMessage("Hobbies" , "You much choose at least one Hobby");
			return null;
		}
		for(int i = 0; i< hobbies.length; i++){
			hobbies[i].replaceAll(";", "");
		}
		
		ArticleList list = new ArticleList();
		User account = new User(userName, password, nickName, hobbies, list);
		
		return account;
	}
	
	
	private void errorMessage(String where, String message){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(where);
		alert.setHeaderText(null);
		alert.setContentText(message +" !");
		alert.showAndWait();
	}
}
