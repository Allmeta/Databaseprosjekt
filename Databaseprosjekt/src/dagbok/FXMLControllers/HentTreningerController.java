package src.dagbok.FXMLControllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import src.dagbok.DBControllers.TreningKlasse;

public class HentTreningerController extends Controller{
	@FXML
	private TableView<TreningKlasse> view;
	@FXML
	private TableColumn<TreningKlasse, String> type;
	@FXML
	private TableColumn<TreningKlasse, String> navn;
	@FXML private Button back;
	@FXML private TextField text;
	
	@FXML
	public void Back() throws IOException {
		goToDashboard((Stage)back.getScene().getWindow(),main);
	}
	@FXML
	public void Hent() {
		//hent siste øvelser
		Platform.runLater(()->{
			fillItems();
		});
	}
	private void fillItems() {
		type.setCellValueFactory(new PropertyValueFactory<TreningKlasse, String>("type"));
		navn.setCellValueFactory(new PropertyValueFactory<TreningKlasse, String>("navn"));
		
		view.getItems().addAll(main.treninger);
	}
}
