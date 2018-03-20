package src.dagbok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegisterController {

    @FXML
    private TextField Passord;

    @FXML
    private TextField Pnr;

    @FXML
    private Button Submit;
    
    @FXML
    private Button cancel;

    @FXML
    private TextField Fornavn;

    @FXML
    private TextField Etternavn;

    @FXML
    private TextField Brukernavn;

    @FXML
    void CancelReg(ActionEvent event) {
    	Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    	

    }

    @FXML
    void SubmitReg(ActionEvent event) {
    	
    	Window owner = Submit.getScene().getWindow();
        
    	if(Fornavn.getText().isEmpty() || Etternavn.getText().isEmpty()) {
    		AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                "Please enter your name");
    		return;
    }
    

    
    
    if(Passord.getText().isEmpty()) {
        AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                "Please enter a password");
        return;
    }

    
    
    AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", 
            "Welcome " + Fornavn.getText());
    
    
    }
    
}


