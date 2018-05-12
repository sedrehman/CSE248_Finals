package application;

import javafx.scene.layout.AnchorPane;

public class APClass {
	private static AnchorPane ap;
	
	public APClass(AnchorPane ap) {
		this.ap = ap;
		ap.setPrefSize(500, 380);
		ap.setLayoutX(48);
		ap.setLayoutY(72);
	}

	public static AnchorPane getAp() {
		return ap;
	}

	public static void setAp(AnchorPane ap) {
		APClass.ap = ap;
	}
	
	
}
