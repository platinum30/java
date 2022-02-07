package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Person;

public class Application {
	public static void main(String[] args) {
		System.out.println("start");
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			Person p1 = ctx.getBean("person", Person.class);
			p1.setAge(30);
			p1.setName("Tzah");
			p1.setId(101);
			Person p2 = ctx.getBean("person", Person.class);
			p2.setAge(25);
			p2.setName("David");
			p2.setId(102);

			System.out.println(p1);
			System.out.println(p2);

			Person danny = ctx.getBean("danny", Person.class);
			System.out.println(danny);
		}
		System.out.println("stop");
	}

}
