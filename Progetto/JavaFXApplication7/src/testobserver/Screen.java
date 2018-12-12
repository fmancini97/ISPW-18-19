/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobserver;
import java.util.Observable;
import java.util.Observer;
import Bean.Bean;
import Bean.BeanTest;
import java.util.List;

public class Screen implements Observer {

  @Override
  public void update(Observable o, Object arg) {
      
    for (BeanTest temp : ( List<BeanTest>)arg) {
            System.out.println(temp.getID() + " " + temp.getName() + " " + temp.getSetNotified());
    }
      

      
  }

}