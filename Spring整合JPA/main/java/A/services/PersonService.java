package A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import A.dao.PersonDAO;
import A.dao.PersonRepository;
import A.dao.PersonRepository2;
import A.entities.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private PersonRepository pr;
	
	@Autowired
	private PersonRepository2 pr2;
	
	@Transactional
	public void savePersons(Person[] persons){
		for(Person p : persons){
			personDAO.save(p);
		}
	}
	
	@Transactional
	public void repository(){
		pr.ooo3(5, "buzhihuowu");
	}
	
	@Transactional
	public void savePersons2(List<Person> persons){		
		pr2.save(persons);
	}
}
