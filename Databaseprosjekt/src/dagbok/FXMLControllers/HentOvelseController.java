package src.dagbok.FXMLControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import com.mysql.fabric.xmlrpc.base.Array;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import src.dagbok.DBControllers.KeyValuePair;
import src.dagbok.DBControllers.OvelseKlasse;

public class HentOvelseController extends Controller {
	@FXML
	private ListView<OvelseKlasse> list;
	@FXML
	private Button back;
	@FXML
	private ComboBox<KeyValuePair> ovelse;

	@FXML
	public void Back() throws IOException {
		goToDashboard((Stage) back.getScene().getWindow(), main);
	}

	public void initialize() {
		// Hent ovelse
		Platform.runLater(() -> {
			fillItems();
		});
	}

	private void fillItems() {
		for (KeyValuePair k : main.ovelsegrupper) {
			ovelse.getItems().add(k);
		}
		ovelse.getSelectionModel().selectFirst();
	}
	
	@FXML
    private Button vislistemedovelser;
	
	
	
	private void HandleHent(ActionEvent event) throws SQLException {
	     // Button was clicked, do something...
	    
		String ovelsen = ovelse.getSelectionModel().getSelectedItem().toString();
; 
		
		main.HentOvelser(ovelsen);
		
	 }
	}
		

