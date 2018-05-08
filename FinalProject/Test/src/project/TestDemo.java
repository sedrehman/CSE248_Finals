package project;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestDemo extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//LogInWindow liw = new LogInWindow();
		//liw.show(primaryStage);
		//newAccountWindow naw = new newAccountWindow();
		//naw.window(primaryStage);
		ArticleList articleList = new ArticleList();
		UserList userList = new UserList();
		String[] hobbies = {"Toy Voyaging", "Stone Skipping"};
		User user = new User("sedrehman@gmail.com", "Syed", "Orko", hobbies, articleList);
		articleList.insert("first", "someday ill write it", user, "Toy Voyaging");
		System.out.println(user.toString());
		
		AccountWindow aw = new AccountWindow();
		aw.display(primaryStage, user, userList);
	}

}
