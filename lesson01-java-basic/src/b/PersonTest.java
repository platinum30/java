package b;

public class PersonTest {

	public static void main(String[] args) {
		// create Object of type Person
		Person person = new Person();
		
		// set the object values
		person.id = 101 ;
		person.name = "David";
		person.age = 25;
		
		System.out.println(person.id);
		System.out.println(person.name);
		System.out.println(person.age);
		
		person.speak("Hello");
	}

}
