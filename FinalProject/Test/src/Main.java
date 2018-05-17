import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Item item = new Item("name", 2.2, 5, "floor", 30, "na", "apple", "na");
		ItemDisplay id = new ItemDisplay();
		Pane pane = id.itemDisplayPane(item);
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}

}
