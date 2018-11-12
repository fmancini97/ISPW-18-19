package dao;

import java.util.List;

import vo.Person;

public interface PersonDAO {
	
	public void insert(Person person);
	public List<Person> select();

}
