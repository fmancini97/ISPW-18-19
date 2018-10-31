/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfx1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Window;
import javafx.scene.control.ChoiceBox;

public class controller {
    @FXML
    private TextField nameField;

    @FXML
    private ProgressIndicator avanzamento;

    @FXML
    private ChoiceBox selezione;

    @FXML
    private Button submitButton;
    
    public void initialize(){
    selezione.getItems().add("Choice 1");
    }
    
public void pressioneBottone(){

    avanzamento.setProgress(avanzamento.getProgress() + 0.25F);

}

    
}