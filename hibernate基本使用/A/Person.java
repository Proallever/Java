package A;

import java.util.Date;

public class Person {
	private int id;
	private String name;
	private int age;
	private double height;
	private Date birth;
	
	private Car car ;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", birth=" + birth + "]";
	}
	
	public Person(String name, int age, double height, Date birth) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.birth = birth;
	}

	public Person(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
