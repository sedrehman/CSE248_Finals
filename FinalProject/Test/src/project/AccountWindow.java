package project;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AccountWindow {
	private ArticleList articleList;
	private TextArea mainTextArea;
	private UserList userList;
	private ObservableList<String> articleObvList = FXCollections.observableArrayList();
	private ListView<String> articleListView = new ListView<String>(articleObvList);

	private ObservableList<HBox> commonHobbyObvList = FXCollections.observableArrayList();
	private ListView<HBox> commonHobbyUserList = new ListView<HBox>(commonHobbyObvList);

	private ObservableList<User> LikedObvList = FXCollections.observableArrayList();
	private ListView<User> mostLikedUserList = new ListView<User>(LikedObvList);
	private User someOne;
	private String pickedHobby = "";

	private User[] mostCommonInHobbies;

	public void display(Stage stage, User account, UserList userList) {
		this.userList = userList;
		this.someOne = account;
		articleList = someOne.getArticles();
		BorderPane root = new BorderPane();
		mainTextArea = new TextArea();
		Menu menu = new Menu("Menu");
		MenuItem logOffMenu = new MenuItem("Log off");
		stage.setOnCloseRequest(e -> {
			userList.save();
			e.consume();
		});
		logOffMenu.setOnAction(e -> {
			LogInWindow liw = new LogInWindow();
			userList.save();
			liw.show(stage);
		});
		MenuItem editMenu = new MenuItem("Edit Profile");
		editMenu.setOnAction(e -> {
			EditAccount ea = new EditAccount();
			ea.window(stage, account, userList);
		});
		menu.getItems().addAll(logOffMenu, editMenu);
		Menu accountMenu = new Menu("Account");
		MenuItem myAccountMenu = new MenuItem("My Account");
		myAccountMenu.setOnAction(e -> {
			stage.close();
			display(stage, account, userList);
		});
		MenuItem deleteArticle = new MenuItem("Delete Article");
		deleteArticle.setOnAction(e -> {
			if (!articleListView.getSelectionModel().getSelectedItem().isEmpty()) {
				// articleListView.getSelectionModel().getSelectedItem().r
				articleList.deleteKey(articleListView.getSelectionModel().getSelectedItem());
				articleManagement(someOne);
			}
		});
		MenuItem newArticle = new MenuItem("New Article");
		newArticle.setOnAction(e -> {
			ArticleFx newFxArticle = new ArticleFx();
			newFxArticle.ArticleWindow(account, userList);
			articleManagement(someOne);
		});
		accountMenu.getItems().addAll(myAccountMenu, newArticle, deleteArticle);

		MenuBar bar = new MenuBar();
		bar.getMenus().addAll(menu, accountMenu);

		articleManagement(someOne);

		articleListView.setPrefSize(150, 350);
		articleListView.getSelectionModel().selectedItemProperty()
				.addListener((observableValue, oldValue, newValue) -> {
					if (newValue != null) {
						// System.out.println("The new value is: " + newValue);
						// System.out.println(articleList.findArticle(newValue));
						String tempArticle = articleList.findArticle(newValue).toString();
						mainTextArea.setText(tempArticle);
					} else {
						mainTextArea.setText("");
					}
				});
		VBox vPaneLeft = new VBox();
		VBox vPaneRight = new VBox();
		vPaneLeft.getChildren().add(articleListView);
		vPaneLeft.setAlignment(Pos.CENTER);
		Label accountNameLabel = new Label("User: " + someOne.getNickName());
		accountNameLabel.setFont(Font.font("Comic Sans MS", 20));

		mainTextArea.setPrefSize(250, 200);
		mainTextArea.wrapTextProperty().set(true);
		mainTextArea.setStyle("-fx-background-color: transparent");
		vPaneRight.getChildren().addAll(accountNameLabel, mainTextArea);
		vPaneRight.setSpacing(20);
		vPaneRight.setAlignment(Pos.CENTER);
		vPaneLeft.setPadding(new Insets(10, 10, 10, 10));
		vPaneRight.setPadding(new Insets(10, 10, 10, 10));
		vPaneRight.setStyle("-fx-background-color: white");
		CommonUserManagement(account);
		commonHobbyUserList.getSelectionModel().selectedItemProperty().addListener((e) -> {
			HBox htemp = commonHobbyUserList.getSelectionModel().getSelectedItem();
			System.out.println(htemp + " Htemp");
			String stringTemp = "";
			if (htemp.getChildren().get(0) != null) {
				Node node = htemp.getChildren().get(0);
				if (node instanceof Label) {
					Label someLabel = (Label) node;
					stringTemp += someLabel.getText();
				}
				for (int i = 0; i < mostCommonInHobbies.length; i++) {
					if (mostCommonInHobbies[i].getNickName().equals(stringTemp)) {
						someOne = mostCommonInHobbies[i];
						break;
					}
				}
				articleList = someOne.getArticles();
				Node node2 = htemp.getChildren().get(1);
				CheckBox cb = null;
				if (node2 instanceof CheckBox) {
					cb = (CheckBox) node2;
				}
				if (cb.isSelected()) {
					someOne.addLikes(account);
				}
				articleManagement(someOne);
			}
		});
		commonHobbyUserList.setPrefSize(180, 350);

		GridPane gpLeft = new GridPane();
		gpLeft.addRow(0, commonHobbyUserList);
		gpLeft.setVgap(10);
		gpLeft.setHgap(10);
		gpLeft.setAlignment(Pos.CENTER);
		gpLeft.setPadding(new Insets(10, 10, 10, 10));

		mostLikedUserList.setPrefSize(180, 330);
		mostLikedUserList.getSelectionModel().selectedItemProperty().addListener(e -> {
			someOne = mostLikedUserList.getSelectionModel().getSelectedItem();
			articleManagement(someOne);
		});
		String[] hobbies = account.getHobbies();
		RadioButton[] rb = new RadioButton[hobbies.length];
		ToggleGroup group = new ToggleGroup();
		for (int i = 0; i < hobbies.length; i++) {
			rb[i] = new RadioButton(hobbies[i]);
			rb[i].setToggleGroup(group);
			rb[i].setUserData(hobbies[i]);
			rb[i].setOnAction(e -> {
				pickedHobby = group.getSelectedToggle().getUserData().toString();
				mostLikedUserManagement(account);
			});
		}
		RadioButton rbNone = new RadioButton("none");
		rbNone.setToggleGroup(group);
		rbNone.setUserData(null);
		rbNone.setOnAction(e -> {
			pickedHobby = "";
			mostLikedUserManagement(account);
		});
		HBox hPane = new HBox();
		hPane.getChildren().addAll(rb);
		hPane.getChildren().add(rbNone);
		hPane.setAlignment(Pos.BASELINE_RIGHT);
		GridPane gpRight = new GridPane();
		gpRight.addRow(0, mostLikedUserList);
		gpRight.setVgap(10);
		gpRight.setHgap(10);
		gpRight.setAlignment(Pos.CENTER);
		gpRight.setPadding(new Insets(10, 10, 10, 10));

		root.setLeft(vPaneLeft);
		root.setCenter(vPaneRight);
		root.setPadding(new Insets(0, 0, 0, 10));

		BorderPane mainRoot = new BorderPane();
		mainRoot.setTop(bar);
		mainRoot.setCenter(root);
		mainRoot.setLeft(gpLeft);
		mainRoot.setRight(gpRight);
		mainRoot.setBottom(hPane);
		mainRoot.setStyle("-fx-background-color: beige");
		Scene scene = new Scene(mainRoot, 1000, 400);
		stage.setScene(scene);
		stage.show();
	}

	public void articleManagement(User user) {
		articleListView.getSelectionModel().clearSelection();
		articleObvList.clear();
		Article temp = user.getArticles().getLast();
		while (temp != null) {
			articleObvList.add(temp.getTitle());
			temp = temp.getPrevious();
		}
	}

	public void CommonUserManagement(User user) {
		if (commonHobbyObvList.size() != 0) {
			commonHobbyUserList.getSelectionModel().clearSelection();
			commonHobbyObvList.clear();
		}
		getMostCommonInHobbies(user);
		for (int i = 0; i < mostCommonInHobbies.length; i++) {
			HBox htemp = new HBox();
			CheckBox cb = new CheckBox();
			if (mostCommonInHobbies[i].getLikes().containsValue(someOne)) {
				cb.setSelected(true);
			}
			cb.setOnAction(e -> {
				userList.save();
			});
			htemp.getChildren().addAll(new Label(mostCommonInHobbies[i].toString()), cb);
			htemp.setSpacing(15);
			commonHobbyObvList.add(htemp);
		}
	}

	public void mostLikedUserManagement(User account) {
		mostLikedUserList.getSelectionModel().clearSelection();
		LikedObvList.clear();
		User[] mostLikedUser;
		if (pickedHobby.equals("")) {
			mostLikedUser = userList.mostLikedUsers();
		} else {
			mostLikedUser = userList.mostLikedUsersByHobby(pickedHobby);
		}
		for (int i = 0; i < mostLikedUser.length; i++) {
			LikedObvList.add(mostLikedUser[i]);
		}
	}

	private void getMostCommonInHobbies(User account) {
		mostCommonInHobbies = userList.mostCommonInHobbies(account);
	}
}
