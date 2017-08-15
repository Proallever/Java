package A;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="group1")
@Entity
public class Group {
	private int id;
	private String name;
	private Set<Member> members = new HashSet<Member>();
	
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
	
	@ManyToMany
	@JoinTable(name="group_member",
			joinColumns={@JoinColumn(name="group_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="member_id",referencedColumnName="id")})
	public Set<Member> getMembers() {
		return members;
	}
	
	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", members = "+ members + "]";
	}
	public Group(String name) {
		super();
		this.name = name;
	}
	
	public Group(){
		
	}

	
}
