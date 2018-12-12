/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobserver;

 
import DAO.JDBCPersonDAO;
import Entity.Person;
 
public class Main {
 
    public static void main(String args[]){
         
        Screen screen = new Screen();

        DataStore dataStore = new DataStore();
        
          
        Thread t1 =new Thread(dataStore);  
        t1.start();  


        dataStore.addObserver(screen); 
 
         
    }
}