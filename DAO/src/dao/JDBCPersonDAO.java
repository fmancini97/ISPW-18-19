package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import vo.Person;

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
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test.Persons (name) VALUES (?)");
			preparedStatement.setString(1,  person.getName());
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
			 	Statement statement = connection.createStatement();
			 	ResultSet resultSet = statement.executeQuery("SELECT * FROM test.Persons");
			 	
			 	Person person = null;
			 	while(resultSet.next()){
			 		person = new Person();
			 		person.setId(Integer.parseInt(resultSet.getString("id")));
				    person.setName(resultSet.getString("name"));
				    
				    persons.add(person);
				}
			 	resultSet.close();
			 	statement.close();
			 	
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
