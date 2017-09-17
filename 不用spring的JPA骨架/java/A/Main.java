package A;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.book.Book;
import domain.student.Student;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
//		Student s = new Student();
//		s.setName("zyf");
//		
//		Book b1 = new Book();
//		Book b2 = new Book();
//		b1.setName("shu1");
//		b2.setName("shu2");
//		Set<Book> books = new HashSet<Book>();
//		books.add(b1); 
//		books.add(b2);
//		
//		s.setBooks(books);
//		
//		manager.persist(s);
		Student s = manager.find(Student.class, 1L);
		s.setName("zy");
		
		tx.commit();
		manager.close();
		factory.close();
	}
}
