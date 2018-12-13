/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
    import Bean.*;


/**
 *
 * @author root
 */
public class SegnalazionePagamento {
    
    private int ID;
    private int IDContratto;
    private int IDLocatore;
    private int IDLocatario;
    private int NumeroReclamo;
    private String ScadenzaReclamo;
    private int Stato;
    
    public SegnalazionePagamento(int ID, int IDContratto, int IDLocatore, int IDLocatario, int NumeroReclamo, String ScadenzaReclamo, int Stato){
        this.ID = ID;
        this.IDContratto = IDContratto;
        this.IDLocatore = IDLocatore;
        this.IDLocatario = IDLocatario;
        this.NumeroReclamo = NumeroReclamo;
        this.ScadenzaReclamo = ScadenzaReclamo;
        this.Stato = Stato;
    }
    
    public BeanSegnalazionePagamento makeBean(){
        BeanSegnalazionePagamento testBean = new BeanSegnalazionePagamento();
        testBean.setID(this.ID);
        testBean.setIDContratto(this.IDContratto);
        testBean.setIDLocatario(this.IDLocatario);
        testBean.setIDLocatore(this.IDLocatore);
        testBean.setNumeroReclamo(this.NumeroReclamo);
        testBean.setScadenzaReclamo(this.ScadenzaReclamo);
        testBean.setStato(this.Stato);
        return testBean;
    }
}
