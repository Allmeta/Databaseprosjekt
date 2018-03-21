package src.dagbok.FXMLControllers;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.dagbok.DBControllers.DBController;


public class LoginController extends Controller{
	
	@FXML
	private TextField brukernavn;
	
	@FXML
	private TextField passord;
	
	@FXML
	public void Reg() throws IOException {		
		showScene("RegistrerBruker.fxml",(Stage)brukernavn.getScene().getWindow(),main);
	}
	
	@FXML
	public void Login() throws IOException {
		String user = brukernavn.getText();
		String p=passord.getText();
		main.Login(user,p);
		
		//if login is true
		goToDashboard((Stage)brukernavn.getScene().getWindow(),main);
	}
	
	
}
