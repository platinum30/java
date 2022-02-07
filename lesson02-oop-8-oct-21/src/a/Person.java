package a;

public class Person {
	private int age;
	private String name;
	private int id;
	
	//constructor (брай) - is special method that runs on object creation
	//CTORs has no return type
	//CTORs name is always the class name
	//CTORs is used for initialization
	public Person() {
		System.out.println("an object is created");
		this.id = -1;
		this.name = "defafult_name";
		this.age = 18;
		
	}
	//Constructor that get parameters on creation
	public Person(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
	//Methods
	//age
	public int getAge() {
		return age;
	}
	
	public void setAge(int age){
		if(age >=0 && age<=120) {
			this.age = age;
		}
	}
	
	//id
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	//name
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

}
