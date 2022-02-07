package d.Point;

public class Pixel extends Point {
	private String color;

	public Pixel(String color, int x, int y) {
		super(x, y);
		this.color = color;
	}

	public Pixel(int x, int y) {
		super(x, y);
		this.color = "black";
	}

	public void printPx() {
		System.out.println("[" + color + ", " + x + ", " + y + "]");
	}

	public static void main(String[] args) {
		Pixel px = new Pixel("red", 5, 7);
		px.printPx();
	}
}
