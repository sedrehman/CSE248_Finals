import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*Item item = new Item("name", 2.2, 5, "floor", 30, "na", "apple", "na");
		ItemDisplay id = new ItemDisplay();
		Pane pane = id.itemDisplayPane(item);
		
		*/
		
		//https://www.habitat.org/
		LoginView lv  = new LoginView();
		Pane pane = new Pane();
		pane.getChildren().add(lv.getLogInPane());
		//pane.setPrefSize(610, 450);
		
//		WebView web = new WebView();
//		WebEngine engine = web.getEngine();
//		engine.load("https://www.habitat.org/");
	//	pane.getChildren().add(web);
		
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}

}
