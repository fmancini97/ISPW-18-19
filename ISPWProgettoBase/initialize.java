// Codice da eseguire appena parte il controller grafico

public void initialize(){
    
    DataStore dataStore = DataStore.getInstance();
    
    Thread t1 =new Thread(dataStore);  
    t1.start();  
    dataStore.addObserver(this); 
    changeScreen.setOnAction(this::visualizzaSegnalazioni);
}