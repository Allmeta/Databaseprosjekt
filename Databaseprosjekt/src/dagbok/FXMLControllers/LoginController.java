package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.dagbok.DBController;
import javafx.scene.Node;
import java.sql.Connection;

public class LoginController extends Controller {

	@FXML
	private TextField brukernavn;

	@FXML
	private TextField passord;

	Stage dialogStage = new Stage();
	Scene scene;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	/*
	 * public FXMLDocumentController() { connection = DBController.initDatabase(); }
	 */

	@FXML
	public void Reg() throws IOException {
		showScene("RegistrerBruker.fxml", (Stage) brukernavn.getScene().getWindow(), main);
	}

	@FXML
	public void Login(ActionEvent event) throws IOException, SQLException {
		String username = brukernavn.getText().toString();
		String password = passord.getText().toString();

		String sql = "SELECT * FROM Person WHERE brukernavn = ? and passord = ?";

		preparedStatement = main.conn.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		resultSet = preparedStatement.executeQuery();
		
		if (!resultSet.next()) {
			infoBox("Feil brukernavn eller passord!", "Failed", null);
		} else {
			main.setPersonnummer(resultSet.getString("Personnummer"));
			infoBox("Logget inn!", "Success", null);
			goToDashboard((Stage) brukernavn.getScene().getWindow(), main);

		}
	}

	public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}

}
