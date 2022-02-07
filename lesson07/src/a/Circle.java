package a;

public class Circle extends Shape {
	private double radius;

	public double getRadius() {
		return radius;
	}

	// CTOR
	public Circle(double radius) {
		// set the radius attribute
		this.radius = radius;
		// set the area attribute
		this.area = Math.PI * radius * radius;
		// this.area = Math.PI * Math.pow(radius, 2);
	}

}
