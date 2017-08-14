package A;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private int id ;
	private String name ;
	private Set<Student> students = new HashSet<Student>();
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name ;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Course(String name) {
		super();
		this.name = name;
	}
	
	public Course(){
		
	}
	
}
