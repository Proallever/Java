package A;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		String name =  "JPA";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(name);
		
		EntityManager entityManager = factory.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		Person p = new Person("zyf",22 , new Date());
		
		entityManager.persist(p);
		
		tx.commit();
		entityManager.close();
		factory.close();
	}
}
