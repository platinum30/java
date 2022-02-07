package zoo.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zoo.core.beans.Bird;

public class Application {
	public static void main(String[] args) {
		System.out.println("start");
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			Zoo zoo = ctx.getBean(Zoo.class);
			zoo.addBird(new Bird("bird 1"));
			zoo.addBird(new Bird("bird 2"));
			zoo.printAllAnimals();
		}
	}
}
