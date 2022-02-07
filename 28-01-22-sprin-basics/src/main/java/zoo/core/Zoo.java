package zoo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import zoo.core.beans.Animal;
import zoo.core.beans.Bird;
import zoo.core.beans.Mammal;
import zoo.core.beans.Reptile;
import zoo.core.beans.Zone;

@Component
@Scope("prototype")
public class Zoo {
	@Autowired
	private Zone<Mammal> mammalZone;
	@Autowired
	private Zone<Bird> birdZone;
	@Autowired
	private Zone<Reptile> reptileZone;

	public void addMammal(Mammal mammal) {
		this.mammalZone.addAnimal(mammal);
	}

	public void addBird(Bird bird) {
		this.birdZone.addAnimal(bird);
	}

	public void addReptile(Reptile reptile) {
		this.reptileZone.addAnimal(reptile);
	}

	public void printMammals() {
		System.out.println("==========Mammals");
		for (Animal animal : mammalZone.getAnimals()) {
			System.out.println(animal);
		}
	}

	public void printBirds() {
		System.out.println("==========Birds");
		for (Animal animal : birdZone.getAnimals()) {
			System.out.println(animal);
		}
	}

	public void printReptiles() {
		System.out.println("==========Reptiles");
		for (Animal animal : reptileZone.getAnimals()) {
			System.out.println(animal);
		}

	}

	public void printAllAnimals() {
		System.out.println("========Animals=======");
		printBirds();
		printMammals();
		printReptiles();
		System.out.println("======================");
	}
}
