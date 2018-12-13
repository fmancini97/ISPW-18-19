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
import Bean.BeanNotifica;
import Bean.BeanTest;
import java.util.LinkedList;

public class DataStore extends Observable implements Runnable{
    
    private static DataStore instance;
    
    private DataStore(){};
    
    public static synchronized DataStore getInstance(){
        if(instance == null){
            instance = new DataStore();
        }
        return instance;
    }

@Override
public void run(){
    
JDBCPersonDAO jdbcPersonDAO = new JDBCPersonDAO();
jdbcPersonDAO.getConnection();
int count = 0;
while(true){
    
    List<Person> Result = jdbcPersonDAO.select();
    /*List<BeanTest> list = new LinkedList<BeanTest>();
    for (Person temp : Result) {
        BeanTest test = new BeanTest();
        test.setID(temp.getName());
        test.setName(temp.toString());
        test.setSetNotified("true");
        list.add(test);
    }
    setChanged();
    notifyObservers(list);*/
    if (Result.size() != 0){
        count = Result.size();
        BeanNotifica changes = new BeanNotifica();
        changes.setNumeroNotifiche(count);
        setChanged();
        notifyObservers(changes);
        jdbcPersonDAO.setNotified();
    } 
    
    //mark the observable as changed
    try {
        Thread.sleep(10000);
    } catch (InterruptedException ex) {
        jdbcPersonDAO.closeConnection();
        Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

}   


}
