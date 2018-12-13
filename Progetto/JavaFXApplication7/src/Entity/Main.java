/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Bean.BeanTest;
import DAO.JDBCSegnalazionePagamentoDAO;
import java.util.List;

/**
 *
 * @author root
 */
public class Main {
    public static void main(String args[]){
        
        JDBCSegnalazionePagamentoDAO connection = new JDBCSegnalazionePagamentoDAO();
        connection.getConnection();
    
        System.out.println("thread is running...");  
        List<SegnalazionePagamento> Result = connection.select();
        System.out.println(Result);
    }
}
