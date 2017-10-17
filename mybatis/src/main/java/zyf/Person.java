package zyf;
/**
* @author 张佳晨
*/
public class Person {
	private Integer id ;
	private String name ;
	private Integer age ; 
	private Double height ; 
	private Boolean isDelete ; 
	
	
	public Person() {
		
	}
	
	public Person(String name, Integer age, Double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Double getHeight() {
		return height;
	}



	public void setHeight(Double height) {
		this.height = height;
	}



	public Boolean getIsDelete() {
		return isDelete;
	}



	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", isDelete=" + isDelete
				+ "]";
	}
	
}
