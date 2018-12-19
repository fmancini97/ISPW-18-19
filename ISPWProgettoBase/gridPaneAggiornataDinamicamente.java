@FXML private GridPane tabella;


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