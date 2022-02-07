package objects;

public class Person {
	
	public Person(int id, int age, String name) {//constractor (брай)
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	//attribustes
	private int id;
	private int age;
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	

}
