package A.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import A.dao.PersonDAO;
import A.entities.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDAO personDAO;
	
	@Transactional
	public void savePersons(Person[] persons){
		for(Person p : persons){
			personDAO.save(p);
		}
	}
}
