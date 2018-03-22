package src.dagbok.FXMLControllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.dagbok.DBControllers.KeyValuePair;

public class NyAnnenOvelseController extends Controller{
	@FXML
    private TextField navn;
	@FXML
    private ComboBox<KeyValuePair> ovelse;
	@FXML
    private TextField notat;
	
	@FXML
	public void onSubmit() throws IOException {
		main.RegistrerNyAnnenOvelse(navn.getText(),ovelse.getValue().toString(),notat.getText());
		goToDashboard((Stage)navn.getScene().getWindow(),main);
		
	}
	@FXML
	public void onCancel() throws IOException {
		goToDashboard((Stage)navn.getScene().getWindow(),main);
	}
	@FXML
	public void initialize() {
		//Fyll #ovelse med items fra database
		//dummy
		Platform.runLater(()->{
			fillItems();
		});
	}
	public void fillItems() {
		for(KeyValuePair k : main.HentTreningsgrupper()) {
			ovelse.getItems().add(k);
		}
		ovelse.getSelectionModel().selectFirst();
	}
}
