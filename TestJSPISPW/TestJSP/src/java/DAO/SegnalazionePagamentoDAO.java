/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

 
import Bean.SegnalazionePagamentoBean;
import java.util.List;
 
import Entity.SegnalazionePagamento;
 
public interface SegnalazionePagamentoDAO {
     
    public void setSegnalazionePagamentoArchiviata(int ID);
    public List<SegnalazionePagamento> getSegnalazioniPagamento(int IDUtente);
    public void incrementaNumeroSegnalazione(int ID);
    public void createSegnalazionePagamento(SegnalazionePagamentoBean bean);
    public SegnalazionePagamento getSegnalazionePagamento(int ID);
    public void checkSegnalazionePagamentoData();
}