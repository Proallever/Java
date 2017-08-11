package A;

public class Wife {
	private String name;
	private Husband husband;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	@Override
	public String toString() {
		return "Wife [name=" + name + ", husband=" + husband + "]";
	}
	public Wife(String name, Husband husband) {
		super();
		this.name = name;
		this.husband = husband;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Wife(){
		
	}
}
