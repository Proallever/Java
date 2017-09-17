package domain.student;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import domain.book.Book;

@Entity
@Table(name="student")
public class Student {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private long id ;
	private String name ;
	
	@JoinColumn(name="student_id")
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Book> books ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
