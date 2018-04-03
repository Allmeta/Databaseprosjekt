package src.dagbok;

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
import src.dagbok.DBControllers.KeyValuePair;
import src.dagbok.DBControllers.OvelseKlasse;
import src.dagbok.DBControllers.TreningKlasse;
import src.dagbok.FXMLControllers.Controller;

@SuppressWarnings("unused")
public class DBController extends Application {

	public Connection conn;
	public ArrayList<KeyValuePair> ovelsegrupper = new ArrayList<KeyValuePair>();
	public ArrayList<KeyValuePair> apparater = new ArrayList<KeyValuePair>();
	public ArrayList<TreningKlasse> treninger = new ArrayList<TreningKlasse>();
	public String personnummer;
	public int treningsoktid = 0;
	public int ovelseid = 0;
	public ArrayList<OvelseKlasse> ovelser;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// init database
		initDatabase();
		// must init controller
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("FXML/login.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Treningsdagbok");

		// Style scene
		scene.getStylesheets().add(getClass().getResource("CSS/style.css").toExternalForm());
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("CSS/icon.png")));

		Controller controller = loader.getController();
		controller.setMain(this);

		primaryStage.show();

	}

	private void initDatabase() throws ClassNotFoundException, SQLException {
		// Step 1: "Load" the JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

		// Step 2: Establish the connection to the database
		String url = "jdbc:mysql://mysql.stud.ntnu.no/thomalme_124";

		Connection conn = DriverManager.getConnection(url, "thomalme", "test1");
		this.conn = conn;

		HentApparater();

		HentOvelsegruppe();

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

	public void RegistrerNyApparatOvelse(String navn, String ovelse, String apparat, String kilo, String sett)
			throws SQLException {
		// apparatovelse
		String sql = "INSERT INTO ovelse(Navn,ovelsegruppe,TreningsoktID) values('" + navn + "','" + ovelse + "','"
				+ treningsoktid + "')";

		Statement statement = conn.createStatement();
		statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

		ResultSet rs = statement.getGeneratedKeys();
		rs.next();
		setOvelseID(rs.getInt(1));

		sql = "INSERT INTO Apparatovelse(Kilo,Sett,ovelseID,Apparatnavn) values('" + kilo + "','" + sett + "','"
				+ ovelseid + "','" + apparat + "')";

		statement = conn.createStatement();
		statement.executeUpdate(sql);

	}

	public void RegistrerNyAnnenOvelse(String navn, String ovelse, String beskrivelse) throws SQLException {
		// annenøvelse
		String sql = "INSERT INTO ovelse(Navn,ovelsegruppe,TreningsoktID) values('" + navn + "','" + ovelse + "','" + treningsoktid
				+ "')";

		Statement statement = conn.createStatement();
		statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

		ResultSet rs = statement.getGeneratedKeys();
		rs.next();
		setOvelseID(rs.getInt(1));

		sql = "INSERT INTO Annenovelse(ovelseID,Beskrivelse) values('" + ovelseid + "','" + beskrivelse + "')";

		statement = conn.createStatement();
		statement.executeUpdate(sql);
	}

	private void setOvelseID(int int1) {
		// TODO Auto-generated method stub
		ovelseid=int1;
	}

	public void RegistrerNyOvelsegruppe(String ovelse) throws SQLException {
		// Sende til database
		ovelsegrupper.add(new KeyValuePair("" + ovelsegrupper.size(), ovelse));
		String sql = "INSERT INTO Ovelsegrupper(ovelsegruppe) values('" + ovelse + "')";

		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);

	}

	public void HentTreningsokter() throws SQLException {
		treninger = new ArrayList<TreningKlasse>();
		String sql = "SELECT * FROM Treningsokt WHERE 1 AND Personnummer=" + personnummer;
		ResultSet resultset = conn.prepareStatement(sql).executeQuery();
		while (resultset.next()) {
			treninger.add(new TreningKlasse(resultset.getString("Dato"), resultset.getString("Notat")));
		}

	}

	public void HentOvelsegruppe() throws SQLException {
		String sql = "SELECT * FROM Ovelsegrupper WHERE 1";
		ResultSet resultset = conn.prepareStatement(sql).executeQuery();
		while (resultset.next()) {
			ovelsegrupper.add(new KeyValuePair("" + ovelsegrupper.size(), resultset.getString("ovelsegruppe")));
		}
	}

	public void HentApparater() throws SQLException {
		String sql = "SELECT * FROM Apparater WHERE 1";
		ResultSet resultset = conn.prepareStatement(sql).executeQuery();
		while (resultset.next()) {
			apparater.add(new KeyValuePair("" + apparater.size(), resultset.getString("apparat")));
		}
	}

	public void setPersonnummer(String string) {
		// TODO Auto-generated method stub
		this.personnummer = string;

	}

	public void RegistrerNyTreningsokt(String dato, double prestasjon, double dagsform, String tidspunkt,
			String varighet, String notat) throws SQLException {
		String sql = "INSERT INTO Treningsokt(Dato, Prestasjon, Dagsform, Tidspunkt, Varighet,Notat,Personnummer) values('"
				+ dato + "', '" + prestasjon + "', '" + dagsform + "', '" + tidspunkt + "', '" + varighet + "','"
				+ notat + "','" + personnummer + "')";

		Statement statement = conn.createStatement();
		statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		ResultSet rs=statement.getGeneratedKeys();
		rs.next();
		setTreningsoktID(rs.getInt(1));

	}

	private void setTreningsoktID(int size) {
		this.treningsoktid = (size);
	}

	public void HentOvelser(String ovelse) throws SQLException {
		this.ovelser = new ArrayList<OvelseKlasse>();
		String sql = "SELECT o.Navn * FROM ovelse o, Treningsokt to WHERE o.TreningsoktID = to.TreningsoktID AND to.Personnummer = "
				+ personnummer + " AND o.ovelsegruppe=" + ovelse;

		ResultSet resultset = conn.prepareStatement(sql).executeQuery();
		while (resultset.next()) {
			ovelser.add(new OvelseKlasse(resultset.getString("Navn")));
		}

	}

}
