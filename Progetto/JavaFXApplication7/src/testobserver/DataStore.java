/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobserver;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.JDBCPersonDAO;
import Entity.Person;
import java.util.List;
import Bean.Bean;

public class DataStore extends Observable implements Runnable{

private String data;    

@Override
public void run(){
    
JDBCPersonDAO jdbcPersonDAO = new JDBCPersonDAO();
jdbcPersonDAO.getConnection();
int count = 0;
while(true){
    
   
    System.out.println("thread is running...");  

    
    List<Person> Result = jdbcPersonDAO.select();
    if (Result.size() != count && Result.size() != 0){
        count = Result.size();
        Bean changes = new Bean();
        changes.setChanges(count);
        setChanged();
        notifyObservers(changes);
        jdbcPersonDAO.setNotified();
    }
    //mark the observable as changed
    try {
        Thread.sleep(5000);
    } catch (InterruptedException ex) {
        jdbcPersonDAO.closeConnection();
        Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

}   


}
