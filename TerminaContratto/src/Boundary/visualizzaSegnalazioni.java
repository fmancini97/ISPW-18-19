/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary;

import Bean.SegnalazionePagamentoBean;
import Controller.Controller;
import java.util.Observable;
import java.util.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class visualizzaSegnalazioni implements Observer {
    
private VBox as;
@FXML private GridPane tabella;
@FXML private Button closeButton;
@FXML private Label labelPopup;
@FXML private ScrollPane principale;
@FXML private Button pannelloUtenteButton;
private String dataScadenza = null;

public void initialize(){
    
    
    Controller controllerProva = new Controller();
    
    controllerProva.addObserver(this);
    List<Integer> IDSegnalazioni = new LinkedList<>();
    List<SegnalazionePagamentoBean> listaResult = controllerProva.getSegnalazioniPagamento();
    System.out.println(listaResult.size());
    if (listaResult.size() == 0){
    } else {
        for (int i = 0; i < listaResult.size(); i++) {
            
            IDSegnalazioni.add(listaResult.get(i).getID());
            
            SegnalazionePagamentoBean Result = listaResult.get(i);
            Label element0 = new Label();
            element0.setText("ID Contratto: " + Result.getIDContratto());
            tabella.add(element0, 0, i);

            Label element1 = new Label();
            element1.setText("Numero reclamo: " + Result.getNumeroReclamo());
            tabella.add(element1, 1, i);

            Label element2 = new Label();
            element2.setText("Scadenza reclamo: " + Result.getScadenzaReclamo());
            tabella.add(element2, 2, i);

            Button element3 = new Button();
            element3.setText("Button");
            element3.setMnemonicParsing(false);
            tabella.add(element3, 3, i);
            
            switch(Result.getStato()){
                case 0:
                    element3.setText("In attesa del locatario");
                    element3.setDisable(true);
                    break;
                
                case 1:
                    element3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (dataScadenza == null){
                            } else {
                            System.out.println(dataScadenza);
                            dataScadenza = null;
                            element3.setDisable(true);
                    }
                    }
                });
                    break;
                    
                case 2:
                    break;
                    
                case 3: 
                    element3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (dataScadenza == null){
                     } else {
                         System.out.println(dataScadenza);
                         dataScadenza = null;
                         element3.setDisable(true);
            }
        }
    });
                    
                case 4:
                    element3.setText("In attesa del locatario");
                    element3.setDisable(true);
                    break;
            }
            
            element3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                    Node source = (Node)event.getSource() ;
                    Integer rowIndex = GridPane.getRowIndex(source);
                    SegnalazionePagamentoBean bean = new SegnalazionePagamentoBean();
                    bean.setID(IDSegnalazioni.get(rowIndex));
                    controllerProva.setContrattoArchiviato(bean);
                    element3.setDisable(true);
                    }
                
            });
        }
    }
}

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @FXML
    private void newScene() throws IOException{
        Stage stage=(Stage) pannelloUtenteButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(this);
        Parent myNewScene = loader.load(getClass().getResource("pannelloUtente.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("FERSA - Termina contratto - Pannello utente");
        stage.show();
    }
}