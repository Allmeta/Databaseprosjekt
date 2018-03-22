package src.dagbok.FXMLControllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ResultatloggController extends Controller{
	@FXML private ListView list;
	@FXML private Button back;
	@FXML private TextField text;
	
	@FXML
	public void Back() throws IOException {
		goToDashboard((Stage)back.getScene().getWindow(),main);
	}
	public void initialize() {
		//Hent resultatlogg
	}
}
