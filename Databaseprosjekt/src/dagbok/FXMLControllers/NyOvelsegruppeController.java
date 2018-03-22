package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class NyOvelsegruppeController extends Controller{
	
	@FXML
	private TextField tekstNavn;
	
	@FXML
	public void gaTilbake() throws IOException {
		goToDashboard((Stage)tekstNavn.getScene().getWindow(),main);
	}
	
	@FXML
	public void Registrer() throws IOException, SQLException {
		String ovelse = faNavn();
		main.RegistrerNyOvelsegruppe(ovelse);	
		
		gaTilbake();
	}
	
	
	public String faNavn() {
		return tekstNavn.getText();
	}
	
}
