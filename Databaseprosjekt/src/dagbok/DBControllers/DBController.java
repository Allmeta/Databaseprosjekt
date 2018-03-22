package src.dagbok.DBControllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

	public Connection conn;
	public ArrayList<KeyValuePair> ovelsegrupper = new ArrayList<KeyValuePair>();
	public ArrayList<KeyValuePair> apparater = new ArrayList<KeyValuePair>();
	public ArrayList<TreningKlasse> treninger = new ArrayList<TreningKlasse>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// init database
		initDatabase();
		// must init controller
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../FXML/login.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Treningsdagbok");

		// Style scene
		scene.getStylesheets().add(getClass().getResource("../CSS/style.css").toExternalForm());
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../CSS/icon.png")));

		Controller controller = loader.getController();
		controller.setMain(this);

		primaryStage.show();

	}

	private void initDatabase() {
		// dummy ovelseguppe
		//ovelsegrupper.add(new KeyValuePair("0", "Test1"));
		//ovelsegrupper.add(new KeyValuePair("1", "Test2"));

		// dummy apparater
		//apparater.add(new KeyValuePair("0", "Romaskin"));
		//apparater.add(new KeyValuePair("1", "Beinmaskin idk"));

		treninger.add(new TreningKlasse("Apparatøvelse", "Navn på øvelse"));
		treninger.add(new TreningKlasse("Annen øvelse", "Navn på øvelse"));

		try {
			// Step 1: "Load" the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Establish the connection to the database
			String url = "jdbc:mysql://mysql.stud.ntnu.no/thomalme_124";

			Connection conn = DriverManager.getConnection(url, "thomalme", "test1");
			this.conn = conn;
			System.out.println("Worked nais");
		} catch (Exception e) {
			System.err.println("D'oh! Got an exception!");
			System.err.println(e.getMessage());
		}
		try {
			HentApparater();
			HentOvelsegruppe();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);

	}

	public void RegistrerApparat(String ny) throws SQLException {
		// funker? idk
		apparater.add(new KeyValuePair("" + apparater.size(), ny));
		String sql = "INSERT INTO Apparater(apparat) values('" + ny + "')";

		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);

	}

	public void Register(String username, String password, String fornavn, String etternavn, String pnummer)
			throws SQLException {
		// insert into database
		String sql = "INSERT INTO Person( Personnummer, fornavn, etternavn, passord, brukernavn) values('" + pnummer
				+ "', '" + fornavn + "', '" + etternavn + "', '" + password + "', '" + username + "') ";

		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
	}

	public void RegistrerNyApparatOvelse(String string, String string2, String string3, String string4, String string5)
			throws SQLException {
		// TODO Sende til database

	}

	public void RegistrerNyAnnenOvelse(String string, String string2, String string3) throws SQLException {
		// sende til database

	}

	public void RegistrerNyOvelsegruppe(String ovelse) throws SQLException {
		// Sende til database
		ovelsegrupper.add(new KeyValuePair("" + ovelsegrupper.size(), ovelse));
		String sql = "INSERT INTO Ovelsegrupper(ovelsegruppe) values('" + ovelse + "')";

		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);

	}

	public void HentTreningsokter(String antall) {
		// Hent N treningsøkter fra database
		// this.treninger= noe fra database

	}

	public void HentOvelsegruppe() throws SQLException {
		String sql = "SELECT * FROM Ovelsegrupper";
		ResultSet resultset=conn.prepareStatement(sql).executeQuery();
		while(resultset.next()) {
			ovelsegrupper.add(new KeyValuePair(""+ovelsegrupper.size(),resultset.getString("ovelsegruppe")));
		}
	}

	public void HentApparater() throws SQLException {
		String sql = "SELECT * FROM Apparater";
		ResultSet resultset=conn.prepareStatement(sql).executeQuery();
		while(resultset.next()) {
			apparater.add(new KeyValuePair(""+apparater.size(),resultset.getString("apparat")));
		}
	}

}
