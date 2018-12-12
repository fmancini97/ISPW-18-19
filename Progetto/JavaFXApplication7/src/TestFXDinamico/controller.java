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

public class controller implements Observer{
    
private DataStore datastore;
private VBox as;
@FXML private GridPane tabella;

public void test(){
    
    
    this.datastore = new DataStore();
    Thread t1 =new Thread(this.datastore);  
    t1.start();
    this.datastore.addObserver(this); 
}

private void mouseEntered(MouseEvent e) {
    }

    @Override
    public void update(Observable o, Object arg) {
        
        Platform.runLater(() -> {
        List <BeanTest> itera = (List<BeanTest>)arg;
        
        if (!itera.isEmpty()){
            System.out.println("Cambiamenti!");
        }
        
        for (int i = 0; i < itera.size(); i++) {
            Button label1 = new Button(itera.get(i).getID());
            Button label2 = new Button(itera.get(i).getName());
            Button label3 = new Button(itera.get(i).getSetNotified());
            Label label4 = new Label();
            String aa = label4.getText();
            
            label1.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                     Node source = (Node)event.getSource() ;
                     Integer colIndex = GridPane.getColumnIndex(source);
                     Integer rowIndex = GridPane.getRowIndex(source);
                     System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
                }
            });

            tabella.setHalignment(label1, HPos.CENTER);
            tabella.setHalignment(label2, HPos.CENTER);
            tabella.setHalignment(label3, HPos.CENTER);

            tabella.add(label1, 0, i);
            tabella.add(label2, 1, i);
            tabella.add(label3, 2, i);
		}
        });
    }
}