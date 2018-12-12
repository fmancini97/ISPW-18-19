/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author root
 */
public class BeanTest {
    
    private String id;
    private String name;
    private String setNotified;
    
    public void setID(String id){
        this.id=id;
    }
    
    public void setName(String name){
        this.name=name;
    }
        
    public void setSetNotified(String setNotified){
        this.setNotified = setNotified;
    }
    
    public String getID(){
        return this.id;
    }
        
    public String getName(){
        return this.name;
    }
            
    public String getSetNotified(){
        return this.setNotified;
    }
    
}
