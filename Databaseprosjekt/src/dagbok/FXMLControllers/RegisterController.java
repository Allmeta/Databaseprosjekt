package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.*; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;
import src.dagbok.DBControllers.DBController;

public class RegisterController extends Controller{

	@FXML
	private TextField Passord;

	@FXML
	private TextField Pnr;

	@FXML
	private Button Submit;

	@FXML
	private Button Cancel;

	@FXML
	private TextField Fornavn;

	@FXML
	private TextField Etternavn;

	@FXML
	private TextField Brukernavn;

	@FXML
	void CancelReg() throws IOException {		
		goToLogin((Stage)Fornavn.getScene().getWindow(),main);

	}

	@FXML
	void SubmitReg(ActionEvent event) throws IOException, SQLException {

		Window owner = Submit.getScene().getWindow();

		if (Fornavn.getText().isEmpty() || Etternavn.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Vennligst skriv navnet ditt");
			return;
		}

		if (Passord.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Vennligst skriv et passord");
			return;
		}

		AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registrering fullført!",
				"Velkommen " + Fornavn.getText());
		main.Register(Fornavn.getText(),Etternavn.getText(),Brukernavn.getText(),Pnr.getText(),Passord.getText());
		
		String username = Brukernavn.getText().toString();
		String password = Passord.getText().toString();
		String fornavn = Fornavn.getText().toString();
		String etternavn = Etternavn.getText().toString();
		String pnummer = Pnr.getText().toString();
		
		main.Register(username, password, fornavn, etternavn, pnummer);		
		
		goToLogin((Stage)Fornavn.getScene().getWindow(),main);

	}
	
		
		
		
	
	
	

}
