package d.Point;

public class Point {
	protected int x;
	protected int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(int a) {
		this(a, a);
	}

	public Point() {
	}

	public void print() {
		System.out.println("[" + x + ", " + y + "]");
	}

	public static void main(String[] args) {
		Point p1 = new Point(9, 3);
		p1.print();
		Point p2 = new Point();
		p2.print();
		Point p3 = new Point(2);
		p3.print();
	}

}
