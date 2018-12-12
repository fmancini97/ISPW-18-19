            // Ottenere dal bottone che ho premuto la rispettiva riga e colonna
            
            label1.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                     Node source = (Node)event.getSource() ;
                     Integer colIndex = GridPane.getColumnIndex(source);
                     Integer rowIndex = GridPane.getRowIndex(source);
                     System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
                }
            });
            
            // Ottenere nodo di una GridPane con indice della riga e della colonna
            // Dato un GridPane, indice della riga e della colonna, ottengo il nodo corrispettivo 
            
            private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
                for (Node node : gridPane.getChildren()) {
                    if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                        return node;
                    }
                }
            return null;
            }
            
            // Inserimento dinamico delle righe all'interno di una GridPane
            // tabella è un oggetto di tipo GridPane, i rappresenta la riga per l'inserimento
            
            Button button = new Button(itera.get(i).getID());
            tabella.setHalignment(button, HPos.CENTER);
            tabella.add(button, 0, i);
            
            // Modificare elementi interfaccia grafica tramite un Thread
            
            Platform.runLater(() -> {
                // [...] Codice da eseguire [...]
            });
