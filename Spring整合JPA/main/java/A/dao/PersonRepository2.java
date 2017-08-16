package A.dao;

import org.springframework.data.repository.CrudRepository;

import A.entities.Person;

public interface PersonRepository2 extends CrudRepository<Person, Integer>{
	
}
