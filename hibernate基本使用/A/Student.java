package A;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private int id;
	private String name ; 
	private Set<Course> courses = new HashSet<Course>();
	
	public int getId() {
		return id;
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", courses=" + courses + "]";
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
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public Student(){
		
	}
	
}
