package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

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
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Vennilgt skriv navnet ditt");
			return;
		}

		if (Passord.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Vennilgt skriv et passord");
			return;
		}

		AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registrering fullført!",
				"Velkommen " + Fornavn.getText());
		main.Register(Fornavn.getText(),Etternavn.getText(),Brukernavn.getText(),Pnr.getText(),Passord.getText());
		
		goToDashboard((Stage)Fornavn.getScene().getWindow(),main);

	}

}
