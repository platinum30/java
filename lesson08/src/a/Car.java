package a;

import java.util.Objects;

public class Car {

	private int number;
	private int speed;
	private String color;

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", speed=" + speed + ", color=" + color + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Car))
			return false;
		Car other = (Car) obj;
		return number == other.number;
	}

	public static void main(String[] args) {
		Car car1 = new Car(48188, 100, "silver");
		Car car2 = new Car(21341, 170, "red");
		Car car3 = new Car(12254, 170, "red");
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);

		System.out.println("car 1 == to car2? | " + car1.equals(car2));
		System.out.println("car 1 == to car3? | " + car1.equals(car3));
		System.out.println("car 2 == to car1? | " + car2.equals(car1));
		System.out.println("car 2z == to car3? | " + car2.equals(car3));

	}

	public Car(int number, int speed, String color) {
		super();
		this.number = number;
		this.speed = speed;
		this.color = color;
	}

}
