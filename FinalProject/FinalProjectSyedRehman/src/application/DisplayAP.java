package application;

import javafx.scene.layout.AnchorPane;

public class DisplayAP {
private static AnchorPane ap;
	
	public DisplayAP(AnchorPane ap) {
		this.ap = ap;
		//layoutX="177.0" layoutY="65.0" prefHeight="457.0" prefWidth="572.0"
		ap.setStyle("-fx-background-color: #F7F7F7; ");
		ap.setPrefSize(457, 572);
		ap.setLayoutX(177);
		ap.setLayoutY(65);
		
	}

	public static AnchorPane getAp() {
		return ap;
	}

	public static void setAp(AnchorPane ap) {
		DisplayAP.ap = ap;
	}
	

}
