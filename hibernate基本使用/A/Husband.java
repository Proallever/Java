package A;

public class Husband {
	private String name ;
	private Wife wife ;
	private int id; 
	
	public Husband(String name, Wife wife) {
		super();
		this.name = name;
		this.wife = wife;
	}
	@Override
	public String toString() {
		return "Husband [name=" + name + ", wife=" + wife + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public Husband(){
		
	}
}
