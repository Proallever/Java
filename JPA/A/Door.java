package A;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="door")
@Entity
public class Door {
	private int id;
	private String brand ;
	private Lock lock;
	
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
	
	@JoinColumn(name="lock_id",unique=true,nullable=false)
	@OneToOne
	public Lock getLock() {
		return lock;
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
	@Override
	public String toString() {
		return "Door [id=" + id + ", brand=" + brand + ", lock=" + lock + "]";
	}
	
	public Door(String brand) {
		super();
		this.brand = brand;
	}
	
	public Door(){
		
	}
	
}
