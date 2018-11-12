/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmvc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author root
 */
public class TestMVC extends Application {
    
    Controller controller = new Controller();
    Bean informazioni = controller.restituisciInformazioni();
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Get text from model");
        btn.setStyle
		(
				"-fx-font-size: 24px;"
				+ "-fx-font-weight: bold;"
				+ "-fx-background-color: lightgreen;"
				+ "-fx-border-style: solid inside;"
				+ "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;"
				+ "-fx-border-color: blue;"
		);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                btn.setText(informazioni.getName());
            }
        });
        
        Button btn1 = new Button();
        btn1.setText("x");
        btn1.setStyle("-fx-border-top:10px;" + "-fx-text-fill: rgb(49, 89, 23);");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                informazioni.setName("Giuseppino");
                controller.setModel(informazioni);
            }
        });
        /* // Grid Pane
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");

        GridPane gridPane = new GridPane();

        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 0, 1, 1, 1);
        gridPane.add(button5, 1, 1, 1, 1);
        gridPane.add(button6, 2, 1, 1, 1);
        */
        
        VBox root = new VBox(5); // Spazio tra i vari elementi della VBox
        root.getChildren().add(btn);
        root.getChildren().add(btn1);
        // root.getChildren().add(gridPane);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
