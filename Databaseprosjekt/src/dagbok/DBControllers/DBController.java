package src.dagbok.DBControllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.dagbok.FXMLControllers.Controller;

@SuppressWarnings("unused")
public class DBController extends Application {

	private Connection conn;
	public ArrayList<KeyValuePair> ovelsegruppe=new ArrayList<KeyValuePair>();
	public ArrayList<KeyValuePair> apparater=new ArrayList<KeyValuePair>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		//init database
		initDatabase();
		// must init controller
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../FXML/login.fxml"));
		
		

		Parent root = loader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Treningsdagbok");
		
		//Style scene
		scene.getStylesheets().add(
			    getClass().getResource("../CSS/style.css").toExternalForm());
		primaryStage.getIcons().add(
				   new Image(
				      getClass().getResourceAsStream( "../CSS/icon.png" )));
		
		Controller controller = loader.getController();
		controller.setMain(this);
		
		primaryStage.show();

	}

	private void initDatabase() {
		//dummy ovelseguppe
		ovelsegruppe.add(new KeyValuePair("0","Test1"));
		ovelsegruppe.add(new KeyValuePair("1","Test2"));
		
		//dummy apparater
		apparater.add(new KeyValuePair("0","Romaskin"));
		apparater.add(new KeyValuePair("1","Beinmaskin idk"));
		
		//fra database på login
		//HentApparater();
		//HentOvelsegruppe();
		
		
		try {
			// Step 1: "Load" the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Establish the connection to the database
			String url = "jdbc:mysql://mysql.stud.ntnu.no/thomalme_124";

			Connection conn = DriverManager.getConnection(url, "thomalme", "test1");
			this.conn=conn;
			System.out.println("Worked nais");
		} catch (Exception e) {
			System.err.println("D'oh! Got an exception!");
			System.err.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		launch(args);

	}

	public void Login(String user, String p) {
		// insert into database
		

	}

	public void RegistrerApparat(String ny) throws SQLException {
		// funker? idk
		apparater.add(new KeyValuePair(""+apparater.size(), ny));

	}

	public void Register(String string, String string2, String string3, String string4,
			String string5) throws SQLException {
		// insert into database

	}

	public void RegistrerNyApparatOvelse(String string, String string2, String string3, String string4,
			String string5) {
		// TODO Sende til database
		String apparatString = "INSERT * INTO ovelse";
		Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/thomalme_124", "thomalme",
				"test1");
		Statement stmt = conn.createStatement();
		stmt.executeQuery(apparatString);

	}

	public void RegistrerNyAnnenOvelse(String string, String string2, String string3) {
		// sende til database
		String annenString = "INSERT * INTO ovelse";
		Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/thomalme_124", "thomalme",
				"test1");
		Statement stmt = conn.createStatement();
		stmt.executeQuery(apparatString);

	}

	public void RegistrerNyOvelsegruppe(String ovelse) {
		// Sende til database
		ovelsegruppe.add(new KeyValuePair(""+ovelsegruppe.size(), ovelse));

	}

	public void HentTreningsokter(String antall) {
		// Hent N treningsï¿½kter fra database
		
		
	}
	public ArrayList<KeyValuePair> HentTreningsgrupper(){
		return ovelsegruppe;
	}
	public ArrayList<KeyValuePair> HentApparater(){
		return apparater;
	}

}
