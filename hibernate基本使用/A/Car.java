package A;

public class Car {
	private String brand ;
	private double price ;
	private Engine engine ;
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", engine=" + engine + "]";
	}
	
	public String getBrand() {
		return brand;
	}
	public Car(String brand, double price, Engine engine) {
		super();
		this.brand = brand;
		this.price = price;
		this.engine = engine;
	}
	
	public Car(){
		
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
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
}
