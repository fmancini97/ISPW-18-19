/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfx1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Window;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


public class controller {
    @FXML
    private ProgressIndicator progress;
    @FXML
    private ToggleGroup Group1;
    @FXML
    private RadioButton easy;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton hard;
    @FXML
    private Button closeButton;
    @FXML
    private Button gioca;
    
    
    /*
    public void initialize(){
    }*/
    
    @FXML
    public void closePopup(){
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
    }
    
    public void popup(String FXML) throws Exception{
        Stage popup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(FXML));
        popup.setTitle("Registration Form FXML Application");
        popup.setScene(new Scene(root, 300, 100));
        popup.show();
    }
    
    public void resetGame(){
        progress.setProgress(0);
    }
    
    public void play() throws Exception{
    double increment;
    
    // Nel caso in cui arrivo al 100%
    if (progress.getProgress() > 1){
        popup("test1.fxml");
    }
    
    // Controllo che almeno una difficoltà sia stata selezionata
    if (Group1.getSelectedToggle() == easy){
        increment = 0.10;
    } else if (Group1.getSelectedToggle() == medium){
        increment = 0.01;
    } else if (Group1.getSelectedToggle() == hard) {
        increment = 0.001;
    } else {
        Stage test = new Stage();
        popup("test2.fxml");
        increment = 0;
    }
    
    progress.setProgress(progress.getProgress() + increment);
    
}


}