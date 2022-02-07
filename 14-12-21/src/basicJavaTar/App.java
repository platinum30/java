package basicJavaTar;

public class App {
	static int nextNumber = 101;
	static int nextHighwayNumber = 50001;

	public static void main(String[] args) {
		Country country = new Country();
		Highway h1 = new Highway("H1");
		country.addHighway(h1);

	}

	public static Highway getHighway() {
		Highway highway = new Highway("H" + nextHighwayNumber++);
		int n = (int) (Math.random() * highway.NUM_OF_CARS + 1);
		for (int i = 0; i < n; i++) {

		}
		return highway;
	}

	public static Car getCar() {
		Car car = new SportsCar(0, 0);
		if (Math.random() < 0.5) {
			car = new SportsCar(0, 0);
		}
		return car;
	}

}
