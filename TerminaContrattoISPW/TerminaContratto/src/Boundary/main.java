package Boundary;


import Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class main extends Application {
    
    Controller controllerProva;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        controllerProva = Controller.getInstance();
        Thread t1 =new Thread(controllerProva);
        t1.setDaemon(true);
        t1.start(); 
        Parent root = FXMLLoader.load(getClass().getResource("fakeLogin.fxml"));
       // primaryStage.setTitle("Registration Form FXML Application");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.setTitle("FERSA - Termina contratto - Pannello utente");
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}