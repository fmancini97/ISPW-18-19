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
 
class Model {
    
    private String name;
    private String surname;
    
    public Model (String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    public void setName(String name){
        this.name = name;
    }
 
}
