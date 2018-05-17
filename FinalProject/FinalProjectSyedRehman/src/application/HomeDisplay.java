package application;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class HomeDisplay {
	private VBox webVpane;
	
	public Pane getHomePane() {
		
		VBox webVpane = new VBox();
		webVpane.setPrefSize(572, 457);
		WebView web = new WebView();
		WebEngine engine = web.getEngine();
		engine.load("https://www.habitat.org/");
		webVpane.getChildren().add(web);
		//ap.getChildren().add(webVpane);
		return webVpane;
	}
}
