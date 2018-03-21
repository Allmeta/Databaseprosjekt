package src.dagbok;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class NyttApparatController {
	
	@FXML
	private TextField tekstNavn;
	
	@FXML
	private Button knappLagre;
	
	@FXML
	private Button knappTilbake;
	
	public JdbcTest1 DB = new JdbcTest1();
	
	private Main main;

	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	public void gåTilbake() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Dashboard.fxml"));
	}
	
	@FXML
	public void RegistrerApprat() throws SQLException {
		String apparat = faNavn();
		String apparatSpørring = "INSERT apparat INTO ovelse";
		Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/thomalme_124", "thomalme", "test1");
		Statement stmt = conn.createStatement();
		stmt.executeQuery(apparatSpørring);
		}
	
	@FXML
	public String faNavn() {
		return tekstNavn.getText();
	}
	
}
