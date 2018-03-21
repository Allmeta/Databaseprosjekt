package src.dagbok.FXMLControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import src.dagbok.DBControllers.DBController;

public class NyAppOvelseController extends Controller{
	@FXML
    private TextField navn;
	@FXML
    private ChoiceBox ovelse;
	@FXML
    private TextField apparat;
	@FXML
    private TextField kilo;
	@FXML
    private TextField notat;
	
	@FXML
	public void onSubmit() throws IOException {
		//how to submit to mysql shiet
		main.RegistrerNyApparatOvelse(navn.getText(),ovelse.getSelectionModel().getSelectedItem().toString(),apparat.getText(),kilo.getText(),notat.getText());
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
