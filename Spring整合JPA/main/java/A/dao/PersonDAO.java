package A.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import A.entities.Person;

@Repository
public class PersonDAO {
	
	@PersistenceContext
	private EntityManager entityManager ;
	
	public void save(Person p){
		entityManager.persist(p);
	}
}
