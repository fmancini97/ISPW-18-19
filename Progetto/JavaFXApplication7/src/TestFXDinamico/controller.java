/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFXDinamico;

import JavaFXApplication7.*;
import java.util.Observable;
import java.util.Observer;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import testobserver.DataStore;
import Bean.Bean;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
 import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
 import javafx.geometry.Rectangle2D;
 import javafx.scene.Group;
 import javafx.scene.Scene; 
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
 import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
 import javafx.scene.paint.Color;
 import javafx.stage.Stage; 



public class controller {

@FXML private GridPane tabella;

public void test(){
        for (int i = 0; i < 100; i++){
            Button label1 = new Button("Accept");
            Button label2 = new Button("Accept");
            Button label3 = new Button("Accept");        
        
             tabella.setHalignment(label1, HPos.CENTER);
                          tabella.setHalignment(label2, HPos.CENTER);
             tabella.setHalignment(label3, HPos.CENTER);


        tabella.add(label1, 0, i);
        tabella.add(label2, 1, i);
        tabella.add(label3, 2, i);
        }
}
}