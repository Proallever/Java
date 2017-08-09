package A;

public class Person {
	private String name;
	private int age ; 
	private String gender;
	private Person girlFriend;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person getGirlFriend() {
		return girlFriend;
	}
	public void setGirlFriend(Person girlFriend) {
		this.girlFriend = girlFriend;
	}
	
	public Person(){
		
	}
	
	public Person(String name , int age , String gender){
		this.age = age;
		this.name = name ;
		this.gender =gender ;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", girlFriend=" + girlFriend + "]";
	}
	
}
