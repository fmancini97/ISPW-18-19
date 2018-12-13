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

public class controller implements Observer{
    
private DataStore datastore;
private VBox as;
@FXML private GridPane tabella;
private ControllerLogicoDati control;
@FXML private Button closeButton;
@FXML private Label labelPopup;
@FXML private ScrollPane principale;


public void initialize(){

    control = new ControllerLogicoDati();
    DataStore dataStore = DataStore.getInstance();
    dataStore.addObserver(this); 

    List<Integer> listID = new ArrayList<>();
    List<BeanSegnalazionePagamento> itera = this.control.ottieniSegnalazioniPagamento();
    for (int i = 0; i < itera.size(); i++) {

        listID.add(itera.get(i).getID());

        Label element1 = new Label();
        Label element2 = new Label();
        Label element3 = new Label();
        Button element4 = new Button();

        element1.setText("ID Segnalazione: " + Integer.toString(itera.get(i).getID()));		
        element4.setMnemonicParsing(false);
        element4.setText("Elimina segnalazione pagamento");
        
        // Elimina segnalazione pagamento
        element4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Node source = (Node)event.getSource() ;
                Integer rowIndex = GridPane.getRowIndex(source);
                element4.setDisable(true);
                control.eliminaSegnalazionePagamento(listID.get(rowIndex));
            }
        }); 

        element3.setText("Scadenza: " + Integer.toString(itera.get(i).getIDLocatario()));
        element2.setText("ID Contratto: " + Integer.toString(itera.get(i).getStato()));

        // Non serve metterlo in quanto l'ho già inserito all'interno dell'FXML
        /*GridPane.setHalignment(element1, HPos.CENTER);
        GridPane.setHalignment(element2, HPos.CENTER);
        GridPane.setHalignment(element3, HPos.CENTER);
        GridPane.setHalignment(element4, HPos.CENTER);*/

        tabella.add(element1, 0, i);
        tabella.add(element2, 1, i);
        tabella.add(element3, 2, i);
        tabella.add(element4, 3, i);
    } 
} 
        
        
/*public void test(ActionEvent event) throws IOException{
    
        control = new ControllerLogicoDati();
        DataStore dataStore = new DataStore();
        Thread t1 =new Thread(dataStore);  
        t1.start();  

        dataStore.addObserver(this); 

        List<Integer> listID = new ArrayList<>();
        List<BeanSegnalazionePagamento> itera = this.control.ottieniSegnalazioniPagamento();
        for (int i = 0; i < itera.size(); i++) {
            
            listID.add(itera.get(i).getID());

            Label element1 = new Label();
            Label element2 = new Label();
            Label element3 = new Label();
            Button element4 = new Button();
            	
            element1.setText("ID Segnalazione: " + Integer.toString(itera.get(i).getID()));		
            element4.setMnemonicParsing(false);
            element4.setText("Elimina segnalazione pagamento");

            element4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        Node source = (Node)event.getSource() ;
                        Integer rowIndex = GridPane.getRowIndex(source);
                        element4.setDisable(true);
                        control.eliminaSegnalazionePagamento(listID.get(rowIndex));
                }
            }); 
           
            element3.setText("Scadenza: " + Integer.toString(itera.get(i).getIDLocatario()));
            element2.setText("ID Contratto: " + Integer.toString(itera.get(i).getStato()));
            
            // Non serve metterlo in quanto l'ho già inserito all'interno dell'FXML
            GridPane.setHalignment(element1, HPos.CENTER);
            GridPane.setHalignment(element2, HPos.CENTER);
            GridPane.setHalignment(element3, HPos.CENTER);
            GridPane.setHalignment(element4, HPos.CENTER);

            tabella.add(element1, 0, i);
            tabella.add(element2, 1, i);
            tabella.add(element3, 2, i);
            tabella.add(element4, 3, i);
            
            Stage stage = (Stage)element4.getScene().getWindow();
            this.newScene(stage);
        }
} */

// Popup quando ci sono delle nuove notifiche
@Override
public void update(Observable o, Object arg) {
    Platform.runLater(() -> {
        BeanNotifica dati = (BeanNotifica)arg;
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
    private void deleteSegnalazionePagamento(ActionEvent event){

    }
    
    private void newScene(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setController(this);
        Parent myNewScene = loader.load(getClass().getResource("popup.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("My New Scene");
        stage.show();
    }
}