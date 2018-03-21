package src.dagbok.FXMLControllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegistrerOvelseController extends Controller{
	@FXML private Button med;
	@FXML
	public void apparatOvelse() throws IOException {
		showScene("ApparatOvelse.fxml", (Stage)med.getScene().getWindow(),main);
	}
	@FXML
	public void annenOvelse() throws IOException {
		showScene("annenOvelse.fxml", (Stage)med.getScene().getWindow(),main);
	}
	@FXML
	public void back() throws IOException{
		goToDashboard((Stage)med.getScene().getWindow(),main);
	}
	public void RegistrerApparat() throws IOException {
		showScene("NyttApparat.fxml", (Stage)med.getScene().getWindow(),main);
	}
	public void RegistrerGruppe() throws IOException {
		showScene("nyOvelsegruppe.fxml", (Stage)med.getScene().getWindow(),main);
	}
}
