package a;

public class Person {
	private int id;
	private String name;
	private int age;

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person: id = " + id + " | name =  " + name + " | age = " + age;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {

		}

		// if we are here than obj is Person
		Person other = (Person) obj;// casting
		return this.id == other.id;// check if ids are the same
	}

	@Override
	public int hashCode() {
		return id * 2 + 25;
	}

	public static void main(String[] args) {
		Person p1 = new Person(101, "Dan", 21);
		Person p2 = new Person(404, "Avi", 18);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());

	}

}
