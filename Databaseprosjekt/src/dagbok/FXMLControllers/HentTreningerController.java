package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
	private TableColumn<TreningKlasse, String> dato;
	@FXML
	private TableColumn<TreningKlasse, String> notat;
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
			try {
				main.HentTreningsokter();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fillItems();
		});
	}
	private void fillItems() {
		dato.setCellValueFactory(new PropertyValueFactory<TreningKlasse, String>("dato"));
		notat.setCellValueFactory(new PropertyValueFactory<TreningKlasse, String>("notat"));
		
		view.getItems().clear();
		
		main.treninger.sort(Comparator.comparing(TreningKlasse::getDato));
		Collections.reverse(main.treninger);
		
		int j=Integer.parseInt(text.getText());
		int i=0;
		while(i<j) {
			view.getItems().add(main.treninger.get(i));
			i++;
		}
	}
}
