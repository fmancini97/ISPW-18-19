/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

 
import java.util.List;
 
import Entity.Person;
 
public interface PersonDAO {
     
    public void insert(Person person);
    public List<Person> select();
    public void setNotified();
 
}
