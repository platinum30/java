package objects;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1;//p1 is not initialized (local variable)
		//p1 = null;//initialize to null = no address
		p1 = new Person(101,11,"dani");
		
		System.out.println(p1.getAge());
		p1.getName();
		

	}

}
