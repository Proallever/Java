package A;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="lock1")
@Entity
public class Lock {
	private int id;
	private String brand ;
	private Door door ;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length=50)
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@OneToOne(mappedBy="lock")
	public Door getDoor() {
		return door;
	}
	public void setDoor(Door door) {
		this.door = door;
	}
	
	@Override
	public String toString() {
		return "Lock [id=" + id + ", brand=" + brand + ", door=" + door + "]";
	}
	public Lock(String brand) {
		super();
		this.brand = brand;
	}
	
	public Lock(){
		
	}
}
