    private void newScene(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setController(this);
        Parent myNewScene = loader.load(getClass().getResource("popup.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("My New Scene");
        stage.show();
    }