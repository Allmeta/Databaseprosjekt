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
import src.dagbok.DBControllers.DBController;
import javafx.scene.Node;
import java.sql.Connection;

public class LoginController extends Controller{
	
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
	public FXMLDocumentController() {
		connection = DBController.initDatabase();
		}
	*/
	
	@FXML
	public void Reg() throws IOException {		
		showScene("RegistrerBruker.fxml",(Stage)brukernavn.getScene().getWindow(),main);
	}
	
	
	/*
	 @FXML
	public void Login() throws IOException {
		String user = brukernavn.getText();
		String p=passord.getText();
		main.Login(user,p);
		
		//if login is true
		goToDashboard((Stage)brukernavn.getScene().getWindow(),main);
	}
	*/
	
	@FXML
	private void Login(ActionEvent event)throws IOException {
		String username = brukernavn.getText().toString();
		String password = passord.getText().toString();
		
		String sql = "SELECT * FROM Person WHERE brukernavn = ? and passord = ?";
		
		
		try{
			preparedStatement = main.conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()){
			infoBox("Enter Correct Email and Password", "Failed", null);
			}else{
			infoBox("Login Successfull", "Success", null);
			
			goToDashboard((Stage)brukernavn.getScene().getWindow(),main);
			
			
			}
			 
			}catch(Exception e){
			e.printStackTrace();
			}
			}
			 
			public static void infoBox(String infoMessage, String titleBar, String headerMessage)
			{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleBar);
			alert.setHeaderText(headerMessage);
			alert.setContentText(infoMessage);
			alert.showAndWait();
			}
		
		
		
		
		
	}
	
	

