/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
 
import Entity.Person;
import Bean.BeanTest;
import Entity.SegnalazionePagamento;
import javafx.fxml.FXMLLoader;
 
public class JDBCSegnalazionePagamentoDAO implements SegnalazionePagamentoDAO {
 
    Connection connection = null;
 
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:8000/test?user=root&password=");
 
        } catch (ClassNotFoundException e) {
 
            e.printStackTrace();
             
        } catch (SQLException e) {
             
            e.printStackTrace();
             
        }
        return connection;
    }

    
 
    @Override
    public List<SegnalazionePagamento> select() {
        List<SegnalazionePagamento> listaSegnalazioni = new LinkedList<SegnalazionePagamento>();
         try {
         String query = "select * from segnalazionePagamento";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    SegnalazionePagamento segnalazione = new SegnalazionePagamento(
                            Integer.parseInt(resultSet.getString("ID")),
                            Integer.parseInt(resultSet.getString("IDContratto")),
                            Integer.parseInt(resultSet.getString("IDLocatore")),
                            Integer.parseInt(resultSet.getString("IDLocatario")),
                            Integer.parseInt(resultSet.getString("NumeroReclamo")),
                            resultSet.getString("ScadenzaReclamo"),
                            Integer.parseInt(resultSet.getString("Stato"))
                    );
                    listaSegnalazioni.add(segnalazione);
                }
                resultSet.close();
                preparedStatement.close();
                 
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listaSegnalazioni;
    }
    
    @Override
    public void eliminaSegnalazionePagamento(int ID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM segnalazionePagamento WHERE (id) = ?");
            preparedStatement.setString(1,  Integer.toString(ID));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
     
     
    public void closeConnection(){
        try {
              if (connection != null) {
                  connection.close();
              }
            } catch (Exception e) { 
                //do nothing
            }
    }

    @Override
    public void insert(SegnalazionePagamento segnalazione) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNotified(SegnalazionePagamento segnalazione) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}