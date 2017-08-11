package A;

import java.util.HashSet;
import java.util.Set;

public class Emperor {
	private String name ;
	private int id ;
	private double weight ;
	private Set<Princess> princesses = new HashSet<Princess>();
	
	public Emperor(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	
	public Emperor(){
		
	}
	
	@Override
	public String toString() {
		return "Emperor [name=" + name + ", weight=" + weight + "]";
	}
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Princess> getPrincesses() {
		return princesses;
	}

	public void setPrincesses(Set<Princess> princesses) {
		this.princesses = princesses;
	}
	
	
}
