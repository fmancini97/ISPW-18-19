// Popup quando ci sono delle nuove notifiche
@Override
public void update(Observable o, Object arg) {
    // Imposto il runLater, per poter permettere l'esecuzione a partire di un Thread
    Platform.runLater(() -> {
        // Ottengo i dati passati dal Bean
        BeanNotifica dati = (BeanNotifica)arg;
        this.notifiche = dati.getNumeroNotifiche();

        // Creo lo stage
        Stage stage = (Stage) changeScreen.getScene().getWindow();
        stage.setTitle("FERSA - Termina contratto - " + (Integer.toString(this.notifiche)) + " nuove notifiche disponibili");
        changeScreen.setText((Integer.toString(this.notifiche)) + " notifiche - Visualizza richieste pagamento");
        Stage newStage = new Stage();
        Pane comp = new Pane();
        
        // Inserisco gli elementi che mi interessano
        Label nameField = new Label();
        nameField.setLayoutX(71.0);
        nameField.setLayoutY(42.0);
        
        Button close = new Button();
        close.setLayoutX(154.0);
        close.setLayoutY(99.0);
        close.setText("Chiudi!");

        if(dati.getNumeroNotifiche() > 1){
            nameField.setText("Sono disponibili " + Integer.toString(dati.getNumeroNotifiche()) + " nuove notifiche!");
        } else {
            nameField.setText("E' disponibile 1 nuova notifica!");
        }

        // Mostro la finestra di popup
        Scene stageScene = new Scene(comp, 368, 159);
        newStage.setScene(stageScene);
        comp.getChildren().addAll(nameField, close);
        newStage.show();

        // Imposto un azione per il bottone
        close.setOnAction(this::closePopup);
    });
}
    
@FXML
private void closePopup(ActionEvent event) {
    // Imposto la chiusura della finestra
    Button close = (Button)event.getSource() ;
    Stage stage = (Stage)close.getScene().getWindow();
    stage.close();
}