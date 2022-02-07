package c;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Point {
	private int x;
	private int y;
	private static final int MIN = 0;
	private static final int MAX = 100;

	public Point(int x, int y) throws PointXYEXception {
		super();
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) throws PointXYEXception {
		if (x >= MIN && x <= MAX) {
			this.x = x;
		} else {
			throw new PointXYEXception("set X failed - value" + x + "is out of range");
		}

	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws PointXYEXception {
		if (y >= MIN && y <= MAX) {
			this.y = y;
		} else {
			throw new PointXYEXception("set Y failed - value" + y + "is out of range");
		}

	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Point[] ArrPt = new Point[5];
			for (int i = 0; i < ArrPt.length; i++) {
				System.out.println("point #" + (i + 1));
				while (true) {
					try {
						System.out.println("Enter X value");
						int x = sc.nextInt();
						System.out.println("Enter Y value");
						int y = sc.nextInt();
						Point p = new Point(x, y);
						ArrPt[i] = p;
						break;
					} catch (PointXYEXception e) {
						System.out.println(e.getMessage());
						sc.nextInt();
					}
				}
			}
			System.out.println(Arrays.toString(ArrPt));
			System.out.println("scanner closed");
		} catch (InputMismatchException e1) {
			System.out.println("error: wrong input");
			e1.getStackTrace();
		}
	}
}
