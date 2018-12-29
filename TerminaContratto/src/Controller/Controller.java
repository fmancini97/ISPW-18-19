/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.BeanNotifica;
import Bean.ContrattoBean;
import Bean.SegnalazionePagamentoBean;
import DAO.JDBCContratto;
import DAO.JDBCSegnalazionePagamento;
import Entity.Contratto;
import Entity.SegnalazionePagamento;
import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Controller extends Observable implements Runnable {
    
    // Creo il dizionario, "accetta" un Intero come chiave, e segnalazione Pagamento come valore (oggetto)
    private  Map<Integer, SegnalazionePagamento> dictionarySegnalazionePagamento  = new HashMap<Integer, SegnalazionePagamento>();
    private  Map<Integer, Contratto> dictionaryContratto  = new HashMap<Integer, Contratto>();
    private Connection connection = null;
    private JDBCSegnalazionePagamento jdbcSegnalazionePagamento;
    private JDBCContratto jdbcContratto;
 
    public List<SegnalazionePagamentoBean> getSegnalazioniPagamento(){
        
    jdbcSegnalazionePagamento = new JDBCSegnalazionePagamento();

    List<SegnalazionePagamento> Result = jdbcSegnalazionePagamento.getSegnalazioniPagamento();
    List<SegnalazionePagamentoBean> list = new LinkedList<SegnalazionePagamentoBean>();
    
    for (SegnalazionePagamento temp : Result) {
        if (dictionarySegnalazionePagamento.get(temp.getID()) == null){
            dictionarySegnalazionePagamento.put(temp.getID(), temp);    
            list.add(temp.makeBean());
        }
        // SegnalazionePagamentoBean bean = new SegnalazionePagamentoBean();
        
    }
    
    return list;    
}   
    
    public List<ContrattoBean> getContratti(){
        
        JDBCContratto jdbcContratto = new JDBCContratto();
        List<Contratto> Result = jdbcContratto.getContratti();
        List<ContrattoBean> list = new LinkedList<>();
        
        for (Contratto temp : Result) {
            ContrattoBean bean = new ContrattoBean();
            bean.setIDContratto(temp.getIDContratto());
            bean.setIDLocatario(temp.getIDLocatario());
            bean.setStatoContratto(temp.getStatoContratto());
            list.add(bean);
            dictionaryContratto.put(temp.getIDContratto(), temp);
        }        
        
        return list;
    }
  
    public void setContrattoArchiviato(SegnalazionePagamentoBean bean){
        
        dictionarySegnalazionePagamento.get(bean.getID()).getContratto().archiviaContratto();            
}
    
    public void testMakeBean(SegnalazionePagamentoBean bean){
       
        jdbcSegnalazionePagamento  = new JDBCSegnalazionePagamento();
        jdbcContratto = new JDBCContratto();
        
        jdbcSegnalazionePagamento.createSegnalazionePagamento(bean);
        jdbcContratto.setContrattoSegnalato(bean.getIDContratto());

        SegnalazionePagamento newSegnalazione = jdbcSegnalazionePagamento.getSegnalazionePagamento(bean.getIDContratto());
        dictionarySegnalazionePagamento.put(newSegnalazione.getID(), newSegnalazione);
    }
    
    @Override
    public void run(){
        JDBCSegnalazionePagamento jdbcSegnalazionePagamento = new JDBCSegnalazionePagamento();
        jdbcSegnalazionePagamento.getConnection();

        int count = 0;
        while(true){
            List<SegnalazionePagamento> Result = jdbcSegnalazionePagamento.getSegnalazioniPagamento();

            if (Result.size() != 0){
                count = Result.size();
                BeanNotifica changes = new BeanNotifica();
                changes.setNumeroNotifiche(count);
                setChanged();
                notifyObservers(changes);
            } 

            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                jdbcSegnalazionePagamento.closeConnection();
            }
            }
        }       
}
