/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmvc;

/**
 *
 * @author root
 */
public class Controller {
    
    Model modello = new Model("Salvatore", "Foderaro");
    
    public Bean restituisciInformazioni(){
        Bean appoggio = new Bean();
        appoggio.setName(modello.getName());
        appoggio.setSurname(modello.getSurname());
        return appoggio;
    }
    
    public void setModel(Bean info){
        modello.setName(info.getName());
    }
    
}
