package c;

import objects.Person;

public class CallDemo2 {
	public static void main(String[] args) {
		m1();
		//ternary operator ? :
		int n1 =5;
		int n2=3;
		int max = n1>n2 ? n1 : n2; //short if
	}
	public static void m1() {
		Person p = new Person(101,11,"aaa");
		m2(p);
		System.out.println(p);
		System.out.println(p.getName());
	}
	
	
	public static void m2(Person p) {
		System.out.println(p);
		p=null;
		System.out.println(p);
	}


}
