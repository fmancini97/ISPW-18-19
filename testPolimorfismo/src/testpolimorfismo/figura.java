/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpolimorfismo;

/**
 *
 * @author root
 */
public abstract class figura {
    protected int base, altezza;
    
    public figura(){
        this.base = 0;
        this.altezza = 0; 
    };
    
    public figura(int base, int altezza){
        this.base = base;
        this.altezza = altezza;
    }
    
    abstract int area();
}
