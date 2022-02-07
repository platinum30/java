package basicJavaTar;

public class Car {
	private int number;
	private int speed;
	public static final int MIN_SPEED = 0;
	public static final int MAX_SPEED = 110;

	public Car(int number, int speed) {
		this.number = number;
		setSpeed(speed);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed >= MIN_SPEED && speed <= MAX_SPEED) {
			this.speed = speed;
		}
	}

}
