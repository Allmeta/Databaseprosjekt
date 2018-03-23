package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.dagbok.DBControllers.KeyValuePair;

public class NyAppOvelseController extends Controller {
	@FXML
	private TextField navn;
	@FXML
	private ComboBox<KeyValuePair> ovelse;
	@FXML
	private ComboBox<KeyValuePair> apparat;
	@FXML
	private TextField kilo;
	@FXML
	private TextField sett;

	@FXML
	public void onSubmit() throws IOException, SQLException {
		// how to submit to mysql shiet
		main.RegistrerNyApparatOvelse(navn.getText(), ovelse.getValue().toString(), apparat.getValue().toString(), kilo.getText(),sett.getText());
		showScene("RegistrerOvelse.fxml",(Stage)navn.getScene().getWindow(),main);

	}

	@FXML
	public void onCancel() throws IOException {
		showScene("RegistrerOvelse.fxml",(Stage)navn.getScene().getWindow(),main);
	}

	@FXML
	public void initialize() {
		// Fyll #ovelse med items fra database
		// Dummy info
		Platform.runLater(()->{
			fillItems();
		});
		

	}

	protected void fillItems() {
		// TODO Auto-generated method stub
		for(KeyValuePair k : main.ovelsegrupper) {
			ovelse.getItems().add(k);
		}
		ovelse.getSelectionModel().selectFirst();
		//apparat
		for(KeyValuePair k : main.apparater) {
			apparat.getItems().add(k);
		}
		apparat.getSelectionModel().selectFirst();		
	}

}
