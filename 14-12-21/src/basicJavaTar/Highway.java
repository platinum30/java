package basicJavaTar;

public class Highway {
	public String name;
	public static final int NUM_OF_CARS = 100;
	private Car[] cars = new Car[NUM_OF_CARS];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Highway(String name) {
		super();
		this.name = name;
	}

	public boolean addCar(Car car) {
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] == null) {
				this.cars[i] = car;
				return true;
			}
		}
		return false;
	}

}
