package enums.solarSystem;

import java.util.Arrays;
import java.util.Scanner;

public class SolarSystemApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// use values method to get an array of all constants
		Planet[] planets = Planet.values();
		System.out.println("ENTER PLANET NAME - " + Arrays.toString(planets));
		String planetName = sc.nextLine();
		System.out.println("details about " + planetName + ": ");
		sc.close();
		// convert string to enum
		// use valueOf method to get instance index
		Planet planet = Planet.valueOf(planetName);
		// use our methods
		System.out.println("order: " + (planet.ordinal() + 1));// location on enum
		System.out.println("mass: " + planet.mass);
		System.out.println("orbit: " + planet.getOrbit());
	}

}
