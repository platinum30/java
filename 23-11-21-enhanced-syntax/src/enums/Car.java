package enums;

public class Car {
	private int number;
	private Color color;

	public Car(int number, Color color) {
		super();
		this.number = number;
		this.color = color;
	}

	public static void main(String[] args) {
		Car car = new Car(111, Color.YELLOW);
		System.out.println(car);
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + "]";
	}

}
