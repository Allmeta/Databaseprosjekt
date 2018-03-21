package src.dagbok.FXMLControllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NyAnnenOvelseController extends Controller{
	@FXML
    private TextField navn;
	@FXML
    private ChoiceBox ovelse;
	@FXML
    private TextField notat;
	
	@FXML
	public void onSubmit() throws IOException {
		main.RegistrerNyAnnenOvelse(navn.getText(),ovelse.getSelectionModel().getSelectedItem().toString(),notat.getText());
		goToDashboard((Stage)navn.getScene().getWindow(),main);
		
	}
	@FXML
	public void onCancel() throws IOException {
		goToDashboard((Stage)navn.getScene().getWindow(),main);
	}
	@FXML
	public void initialize() {
		//Fyll #ovelse med items fra database
		
	}
	
}
