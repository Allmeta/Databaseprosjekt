package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class NyttApparatController extends Controller{
	
	@FXML
	private TextField tekstNavn;
	
	@FXML
	private Button knappLagre;
	
	@FXML
	private Button knappTilbake;
	
	@FXML
	public void gaTilbake() throws IOException {
		showScene("RegistrerOvelse.fxml",(Stage)tekstNavn.getScene().getWindow(),main);
	}
	
	@FXML
	public void RegistrerApparat() throws SQLException, IOException {
		String apparat = faNavn();
		main.RegistrerApparat(apparat);		
		
		gaTilbake();
	}
	
	
	public String faNavn() {
		return tekstNavn.getText();
	}
	
}
