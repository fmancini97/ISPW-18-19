/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

public class Bean {
    
    private String name;
    private String surname; 
    private int changes;
    
    public Bean(){}
    
    public String getName(){
        return this.name;
    }
    
    public void setChanges(int number){
        this.changes = number;
    }
    
    public int getChanges(){
        return this.changes;
    }
    
    
    
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
}