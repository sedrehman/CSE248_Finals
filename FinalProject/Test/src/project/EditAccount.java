package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EditAccount {
	private UserList list ;
	
	public void window(Stage stage, User account, UserList userList){
		this.list = userList;
		GridPane pane = new GridPane();
		Label userNameLabel = new Label("Email address: ");
		Label userNameField = new Label(account.getUserName());
		userNameField.setMinWidth(200);
		userNameField.setMaxWidth(220);
		Label passwordLabel = new Label("Enter password: ");
		TextField passwordField = new TextField(account.getPassword());
		passwordField.setPromptText("Must contain 1 Cap & 1 Lower case");
		passwordField.setMinWidth(200);
		passwordField.setMaxWidth(280);
		Label nickNameLabel = new Label("Enter your Nick name: ");
		TextField nickNameField = new TextField(account.getNickName());
		
		CheckBox CBToyVoyaging = new CheckBox("Toy Voyaging");
		for(int i = 0; i< account.getHobbies().length; i++){
			if(account.getHobbies()[i].equals(CBToyVoyaging.getUserData())){
				CBToyVoyaging.setSelected(true);
			}
		}
		CheckBox CBStoneSkipping = new CheckBox("Stone Skipping");
		CBStoneSkipping.setSelected(true);
		CheckBox CBExtremeIroning = new CheckBox("Extreme Ironing");
		CBExtremeIroning.setSelected(true);
		CheckBox CBTreeShaping = new CheckBox("Tree Shaping");
		CBTreeShaping.setSelected(true);
		CheckBox CBNewsRaiding = new CheckBox("News Raiding");
		CBNewsRaiding.setSelected(true);
		CheckBox CBTrainSurfing = new CheckBox("Train Surfing");
		CBTrainSurfing.setSelected(true);
		
		Button bUpdate = new Button("Update!");
		bUpdate.setOnAction(e-> {
			User tempAccount = update(userNameField.getText(), passwordField.getText(), nickNameField.getText(), CBToyVoyaging, 
					CBStoneSkipping, CBExtremeIroning, CBTreeShaping, CBNewsRaiding, CBTrainSurfing);
			if(!(tempAccount == null)){
				account.setHobbies(tempAccount.getHobbies());
				account.setPassword(tempAccount.getPassword());
				account.setNickName(tempAccount.getNickName());
				list.save();
				AccountWindow aw = new AccountWindow();
				aw.display(stage, account, list);
			}
		});
		Button dButton = new Button("Delete");
		dButton.setOnAction(e->{
			list.getList().remove(account.getUserName());
			list.save();
			LogInWindow liw = new LogInWindow();
			liw.show(stage);
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
		pane.addRow(9, bUpdate);
		pane.addRow(10, dButton);
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 500,400);
		stage.setScene(scene);
		stage.show();

	}

	private User update(String userName, String password, String nickName, CheckBox CBToyVoyaging,
			CheckBox CBStoneSkipping, CheckBox CBExtremeIroning, CheckBox CBTreeShaping, 
			CheckBox CBNewsRaiding, CheckBox CBTrainSurfing) {
		userName = userName.trim();
		password = password.trim();
		
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
