package A;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="shangbanzu")
@Entity
public class Shangbanzu {
	private int id;
	private String name;
	private Office office;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name",length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Shangbanzu [id=" + id + ", name=" + name + "]";
	}
	
	public Shangbanzu(String name) {
		super();
		this.name = name;
	}
	
	public Shangbanzu(){
		
	}
	
	@JoinColumn(name="office_id")
	@ManyToOne(fetch=FetchType.LAZY)
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	
}
