package a;

public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person();
		//method invocation (קריאה למטודה)
		p1.setAge(25);
		p1.setName("David");
		p1.setId(101);
		
		System.out.println(p1.getAge());
		System.out.println(p1.getId());
		System.out.println(p1.getName());
		
	}

}
