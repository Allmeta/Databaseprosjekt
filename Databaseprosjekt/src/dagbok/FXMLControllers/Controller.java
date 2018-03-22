package src.dagbok.FXMLControllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.dagbok.DBControllers.DBController;

public class Controller {
	protected DBController main;
	private Stage root;

	public void setMain(DBController main) {
		this.main = main;
	}
	public void setRoot(Stage root) {
		this.root = root;
	}
	public Stage getRoot() {
		return this.root;
	}
	public void showScene(String sceneText, Stage root, DBController main2) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass()
	            .getResource("../FXML/"+sceneText));
	    BorderPane parent;
	    try 
	    {
	    	parent = (BorderPane)loader.load();
	    	//Set controller
	    	Controller controller = loader.getController();
			controller.setRoot(root);
			controller.setMain(main2);
			
			Scene scene=new Scene(parent);
			scene.getStylesheets().add(
				    getClass().getResource("../CSS/style.css").toExternalForm());
			root.getIcons().add(
					   new Image(
					      getClass().getResourceAsStream( "../CSS/icon.png" )));
			
	        root.setScene(scene);
	    } 
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }


	}
	public void goToDashboard(Stage root, DBController main2) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass()
	            .getResource("../FXML/Dashboard.fxml"));
	    BorderPane parent;
	    try 
	    {
	    	parent = (BorderPane)loader.load();
	    	//Set controller
	    	Controller controller = loader.getController();
			controller.setRoot(root);
			controller.setMain(main2);
			
			Scene scene=new Scene(parent);
			scene.getStylesheets().add(
				    getClass().getResource("../CSS/style.css").toExternalForm());
			root.getIcons().add(
					   new Image(
					      getClass().getResourceAsStream( "../CSS/icon.png" )));
			
	        root.setScene(scene);
	    } 
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }	    
	}
	public void goToLogin(Stage root, DBController main2) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass()
	            .getResource("../FXML/login.fxml"));
	    BorderPane parent;
	    try 
	    {
	    	parent = (BorderPane)loader.load();
	    	//Set controller
	    	Controller controller = loader.getController();
			controller.setRoot(root);
			controller.setMain(main2);
			
			Scene scene=new Scene(parent);
			scene.getStylesheets().add(
				    getClass().getResource("../CSS/style.css").toExternalForm());
			root.getIcons().add(
					   new Image(
					      getClass().getResourceAsStream( "../CSS/icon.png" )));
			
	        root.setScene(scene);
	    } 
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }	    
	}
}
