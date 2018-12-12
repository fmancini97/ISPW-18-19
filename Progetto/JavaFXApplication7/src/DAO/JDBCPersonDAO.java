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
import javafx.fxml.FXMLLoader;
 
public class JDBCPersonDAO implements PersonDAO {
 
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
    public void insert(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Persons (id ,name) VALUES (NULL , ?)");
            preparedStatement.setString(1,  person.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
    
    @Override
    public void setNotified() {
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Persons SET setNotified = 1 WHERE setNotified = 0");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
 
    @Override
    public List<Person> select() {
        List<Person> persons = new LinkedList<Person>();
         try {
         String query = "select * from Persons where setNotified = 0";


                PreparedStatement preparedStatement = connection.prepareStatement(query);

               // preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                // statement.setString(userId, userID);
                Person person = null;
                while(resultSet.next()){
                    person = new Person();
                    person.setId(Integer.parseInt(resultSet.getString("id")));
                    person.setName(resultSet.getString("name"));
                    persons.add(person);
                }
                resultSet.close();
                preparedStatement.close();
                 
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return persons;
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
 
}