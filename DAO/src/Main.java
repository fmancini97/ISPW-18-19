import dao.JDBCPersonDAO;
import java.util.List;
import vo.Person;

public class Main {

	public static void main(String args[]){
		
		Person person = new Person();
		person.setName("HMK");
		
		JDBCPersonDAO jdbcPersonDAO = new JDBCPersonDAO();
		jdbcPersonDAO.getConnection();
		

		
		List<Person> persons = jdbcPersonDAO.select();
                System.out.println(persons.size());
                if (persons.size() != 0){
                    for (Person temp : persons) {
            		System.out.println(temp.getName());
		}
                };
		jdbcPersonDAO.closeConnection();
		
	}
}