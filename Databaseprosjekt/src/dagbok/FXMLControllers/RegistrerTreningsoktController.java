package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrerTreningsoktController extends Controller{
	@FXML private DatePicker dato;
	@FXML private Slider prestasjon;
	@FXML private Slider dagsform;
	@FXML private TextField tid, varighet;
	@FXML private TextArea notat;
	
	@FXML public void Submit() throws IOException, SQLException {
		//lagre treningsøkt
		main.RegistrerNyTreningsokt(dato.getValue().toString(),prestasjon.getValue(),dagsform.getValue(),tid.getText(),varighet.getText(),notat.getText());
		showScene("RegistrerOvelse.fxml", (Stage)dato.getScene().getWindow(), main);
	}
	@FXML public void Cancel() throws IOException {
		goToDashboard((Stage)dato.getScene().getWindow(), main);
	}
	
}
