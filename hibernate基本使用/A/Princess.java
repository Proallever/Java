package A;

public class Princess {
	private int id;
	private String name;
	private double weight ;
	private Emperor husband;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Emperor getHusband() {
		return husband;
	}
	public void setHusband(Emperor husband) {
		this.husband = husband;
	}
	
	@Override
	public String toString() {
		return "Princess [name=" + name + ", weight=" + weight + ", husband=" + husband + "]";
	}
	
	public Princess(String name, double weight, Emperor husband) {
		super();
		this.name = name;
		this.weight = weight;
		this.husband = husband;
	}
	
	public Princess(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
