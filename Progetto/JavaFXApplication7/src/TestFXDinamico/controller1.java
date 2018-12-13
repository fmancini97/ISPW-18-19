/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFXDinamico;

import java.util.Observable;
import java.util.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import testobserver.DataStore;
import Bean.BeanTest;
import java.awt.event.MouseEvent;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ControllerLogico.*;
import Bean.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class controller1 implements Observer{
    
private DataStore datastore;
private VBox as;
@FXML private GridPane tabella;
private ControllerLogicoDati control;
@FXML private Button closeButton;
@FXML private Label labelPopup;
@FXML private ScrollPane principale;
@FXML private Button changeScreen;
private int notifiche;

public void initialize(){
    
    DataStore dataStore = DataStore.getInstance();
    
    Thread t1 =new Thread(dataStore);  
    t1.start();  
    dataStore.addObserver(this); 
    changeScreen.setOnAction(this::visualizzaSegnalazioni);
}

// Popup quando ci sono delle nuove notifiche
@Override
public void update(Observable o, Object arg) {
    Platform.runLater(() -> {
        Stage stage = (Stage) changeScreen.getScene().getWindow();
        BeanNotifica dati = (BeanNotifica)arg;
        this.notifiche = dati.getNumeroNotifiche();
        stage.setTitle("FERSA - Termina contratto - " + (Integer.toString(this.notifiche)) + " nuove notifiche disponibili");
        changeScreen.setText((Integer.toString(this.notifiche)) + " notifiche - Visualizza richieste pagamento");
        Stage newStage = new Stage();
        Pane comp = new Pane();
        Label nameField = new Label();
        nameField.setLayoutX(71.0);
        nameField.setLayoutY(42.0);

        if(dati.getNumeroNotifiche() > 1){
            nameField.setText("Sono disponibili " + Integer.toString(dati.getNumeroNotifiche()) + " nuove notifiche!");
        } else {
            nameField.setText("E' disponibile 1 nuova notifica!");
        }

        Button close = new Button();
        close.setLayoutX(154.0);
        close.setLayoutY(99.0);
        close.setText("Chiudi!");

        Scene stageScene = new Scene(comp, 368, 159);
        newStage.setScene(stageScene);
        comp.getChildren().addAll(nameField, close);
        newStage.show();
        close.setOnAction(this::closePopup);
    });
}
    
    @FXML
    private void closePopup(ActionEvent event) {
    Button close = (Button)event.getSource() ;
    Stage stage = (Stage)close.getScene().getWindow();
    stage.close();
}
    @FXML
    public void visualizzaSegnalazioni(ActionEvent event){
        Button close = (Button)event.getSource() ;
        Stage stage = (Stage)close.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Parent myNewScene;
    try {
        myNewScene = loader.load(getClass().getResource("m.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("My New Scene");
        stage.show();
        DataStore dataStore = DataStore.getInstance();
        dataStore.deleteObserver(this);
    } catch (IOException ex) {
        Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    
private void deleteSegnalazionePagamento(ActionEvent event){

}
    

}