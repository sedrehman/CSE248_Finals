package project;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ArticleView {
	private Article article;
	private Button delete;
	private TextArea ta;
	private GridPane pane;
	private Label label;
	private Label label2;
	private Label tLabel;
	
	public ArticleView(String article){
		//User account = article.getWriter();
		//this.article = article;
		ta = new TextArea("1");
		tLabel = new Label("2");
		label = new Label("3");
		//label2 = new Label(article.getTimeStamp() + " by-"+ article.getWriter().getNickName());
		label2 = new Label("4");
		delete = new Button("Delete!"); 
		delete.setOnAction(e->{
			//ArticleList list = account.getArticles();
			//list.deleteKey(article.getTitle());
		});
		pane = new GridPane();
		pane.setPadding(new Insets(10,10,10,10));
		pane.setHgap(10);
		pane.addRow(0, tLabel);
		pane.addRow(1, ta);
		pane.addRow(2, label, label2);
		pane.addRow(3, delete);
	}
	
}
