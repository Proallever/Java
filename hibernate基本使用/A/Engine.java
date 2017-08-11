package A;

public class Engine {
	private String brand ;
	private double price ;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Engine(String brand, double price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	
	public Engine(){
		
	}
	
	@Override
	public String toString() {
		return "Engine [brand=" + brand + ", price=" + price + "]";
	}
	
}
