package b.exercise;

public class TestPoint {

	public static void main(String[] args) {
		Point pt1 = new Point(12, 5);
		Point pt2 = new Point(128, 45);
		Point pt3 = new Point(55, 987);

		System.out.println("Point Number 1 x is:" + pt1.getX());
		System.out.println("Point Number 1 y is:" + pt1.getY());

		System.out.println("Point Number 2 x is:" + pt2.getX());
		System.out.println("Point Number 2 y is:" + pt2.getY());

		System.out.println("Point Number 3 x is:" + pt3.getX());
		System.out.println("Point Number 3 y is:" + pt3.getY());
	}

}
