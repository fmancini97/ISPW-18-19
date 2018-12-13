/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogico;
import Bean.*;
import DAO.*;
import Entity.SegnalazionePagamento;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author root
 */
public class ControllerLogicoDati {
    
    public List<BeanSegnalazionePagamento> ottieniSegnalazioniPagamento(){
        
        JDBCSegnalazionePagamentoDAO jdbcPersonDAO = new JDBCSegnalazionePagamentoDAO();
        jdbcPersonDAO.getConnection();
       
        List<BeanSegnalazionePagamento> returnList = new LinkedList<>();
        List<SegnalazionePagamento> listaEntita = jdbcPersonDAO.select();
        
        for (SegnalazionePagamento temp : listaEntita) {
                returnList.add(temp.makeBean());
        }
        
        
    
        return returnList;
    }
        
    public void eliminaSegnalazionePagamento(int IDSegnalazione){
    
        JDBCSegnalazionePagamentoDAO jdbcPersonDAO = new JDBCSegnalazionePagamentoDAO();
        jdbcPersonDAO.getConnection();
        
        jdbcPersonDAO.eliminaSegnalazionePagamento(IDSegnalazione);
        
        
        
}

    
}
