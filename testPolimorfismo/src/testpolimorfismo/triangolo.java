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
public class triangolo extends figura {
    
    public triangolo(){
        super();
    };
    
    public triangolo(int base, int altezza){
        super(base, altezza);
    }
   
    @Override
    public int area(){
        return ((super.base * super.altezza)/2);
    };
    
}
