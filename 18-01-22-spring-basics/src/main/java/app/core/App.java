package app.core;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Person;

public class App {
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			
			System.out.println("end");
			Person p1 = ctx.getBean("x", Person.class);
			Person p2 = ctx.getBean("x", Person.class);
			Person p3 = ctx.getBean("x", Person.class);
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(p3);
			Person siri = ctx.getBean("siri",Person.class);
			System.out.println(siri);
			ArrayList<Person> persons = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				Person coffeeWorker = ctx.getBean("coffeeWorker",Person.class);
				persons.add(coffeeWorker);
			}
			
			for (Person person : persons) {
				System.out.println(person);
			}
			ctx.close();
		}
	}
}
