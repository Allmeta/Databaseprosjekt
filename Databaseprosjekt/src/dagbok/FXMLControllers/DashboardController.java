package src.dagbok.FXMLControllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import src.dagbok.DBControllers.DBController;

public class DashboardController extends Controller{
	@FXML private Button register;
	@FXML
	public void Register() throws IOException {
		showScene("RegistrerOvelse.fxml", (Stage)register.getScene().getWindow(),main);
	}
	@FXML
	public void hentTreninger() throws IOException {
		showScene("HentTreninger.fxml", (Stage)register.getScene().getWindow(),main);
	}
	@FXML
	public void hentResultatlogg() throws IOException {
		showScene("Resultatlogg.fxml", (Stage)register.getScene().getWindow(), main);		
	}
}
