/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entity.SegnalazionePagamento;
 
import java.util.List;
 
import Entity.Person;
 
public interface SegnalazionePagamentoDAO {
    
    public List<SegnalazionePagamento> select();
    public void insert(SegnalazionePagamento segnalazione);
    public void setNotified(SegnalazionePagamento segnalazione);
    public void eliminaSegnalazionePagamento(int ID);
 
}
