package A;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="office")
@Entity
public class Office {
	
	private int id;
	private String name;
	private Set<Shangbanzu> members = new HashSet<Shangbanzu>();
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Office [id=" + id + ", name=" + name + "]";
	}
	public Office( String name) {
		super();
		this.name = name;
	}
	
	public Office(){
		
	}
	
	//@JoinColumn(name="office_id")
	@OneToMany(mappedBy="office")
	public Set<Shangbanzu> getMembers() {
		return members;
	}
	public void setMembers(Set<Shangbanzu> members) {
		this.members = members;
	}
}
