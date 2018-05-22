package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class OrderControl implements Initializable{

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField ccn;

    @FXML
    private TextField security;

    @FXML
    private Button orderButton;
    
    private DepartmentControl dc = new DepartmentControl();
    private User user = dc.getUser();

    @FXML
    public void order(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public Parent getPane() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}
	
}
