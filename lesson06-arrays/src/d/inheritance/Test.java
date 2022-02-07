package d.inheritance;

public class Test {

	public static void main(String[] args) {
		Animal animal;
		animal = new Animal();
		animal.speak();

		animal = new Dog();
		animal.speak();
		animal = new Cat();
		animal.speak();

		Animal[] animals = new Animal[3];
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Cat();
		System.out.println("=================");
		for (int i = 0; i < animals.length; i++) {
			animals[i].speak();
			if (animals[i] instanceof Cat) {// check id animal its a cat
				// convert to cat
				Cat cat = (Cat) animals[i];
				cat.scrach();
			}
			System.out.println("____________________");
		}

	}

}
