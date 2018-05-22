package application2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class OrderController implements Initializable{
	 @FXML
	    private AnchorPane mainPane;

	    @FXML
	    private Label orderNum;

	    @FXML
	    private Label items;

	    @FXML
	    private Label time;

	    @FXML
	    private Label name;

	    @FXML
	    private Label address;

	    @FXML
	    private Label card;

	    @FXML
	    private Label total;

	    @FXML
	    private Button ship;

	    @FXML
	    private Button delete;

	    private MainWindowController mwc = new MainWindowController();
	    private Order order = mwc.chosenOrder;
	    
	@FXML
	void deleteClicked(ActionEvent event) {
		DeleteOrder d = new DeleteOrder();
		if (order != null) {
			d.delete(order.getOrderNum());
			mainPane.getChildren().clear();
			Label lbl = new Label("deleted order!");
			mainPane.getChildren().add(lbl);
		}
	}

	@FXML
	void shipClicked(ActionEvent event) {
		DeleteOrder d = new DeleteOrder();
		if (order != null) {
			d.delete(order.getOrderNum());
			mainPane.getChildren().clear();
			Label lbl = new Label("deleted order!");
			mainPane.getChildren().add(lbl);
		}
		File file = new File("E:\\" + "Order1" + ".txt");
		int increase=1;
		while(file.exists()){
		     increase++;
		     file = new File("E:\\" + "Order" + increase+ ".txt");
		} 
		if(!file.exists()) {
		   try {

		    String content = order.toString();
		    file.createNewFile();

		    FileWriter fw = new FileWriter(file.getAbsoluteFile());
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(content);
		    bw.close();

		    System.out.println("Done");

		}catch (IOException e){
		   }
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		orderNum.setText(Integer.toString(order.getOrderNum()));
		time.setText(order.getTimeStamp());
		name.setText(order.getFullName());
		address.setText(order.getUserAddress());
		card.setText(Double.toString(order.getCreditCardNumber()));
		total.setText(Double.toString(order.getTotal()));
		items.setText(order.getItems());

	}

	public Parent getPane() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("OrderDisplay.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}
}
