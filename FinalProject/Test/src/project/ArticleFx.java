package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ArticleFx {
	UserList list ;
	
	public void ArticleWindow(User account, UserList list){
		this.list = list;
		Stage stage = new Stage();
		GridPane gp = new GridPane();
		TextArea taData = new TextArea();
		taData.setPrefSize(300, 150);
		taData.wrapTextProperty().set(true);
		TextField tfTitle = new TextField();
		Button createButton = new Button("Save");
		String[] hobbies = account.getHobbies();
		RadioButton[] rb = new RadioButton[hobbies.length];
		ToggleGroup group = new ToggleGroup();
		
		for(int i = 0 ; i< hobbies.length; i++){
			rb[i] = new RadioButton(hobbies[i]);
			rb[i].setToggleGroup(group);
			rb[i].setUserData(hobbies[i]);
		}
		rb[0].setSelected(true);
		
		createButton.setOnAction(e->{
			if(tfTitle.getText().equals(null) || tfTitle.getText().equals("")|| taData.getText().equals(null)|| taData.getText().equals("")){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(null);
				alert.setHeaderText(null);
				alert.setContentText("Retry. You article must have a title and a body");
				alert.showAndWait();
			}else{
				account.getArticles().insert(tfTitle.getText(), taData.getText(), account, (String) group.getSelectedToggle().getUserData());
				list.save();
				stage.close();
			}
		});
		
		VBox vPane = new VBox();
		vPane.setSpacing(5);
		vPane.getChildren().addAll(rb);
		gp.addRow(0,new Label("Title: "),tfTitle);
		gp.addRow(1, new Label("Body :"),taData);
		gp.addRow(2, vPane);
		gp.addRow(3, createButton);
		GridPane.setColumnIndex(createButton, 1);
		gp.setPadding(new Insets(10,20,10,20));
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(gp, 500,400);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
		
	}
}
