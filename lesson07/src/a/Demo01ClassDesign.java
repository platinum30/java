package a;

public class Demo01ClassDesign {

	public static void main(String[] args) {
		double c1Radius = Math.random() * 6;
		double c2Radius = Math.random() * 6;
		Circle c1 = new Circle(c1Radius);
		Circle c2 = new Circle(c2Radius);
		System.out.println("c1 radius is: " + c1.getRadius() + " Area is:" + c1.getArea());
		System.out.println("c2 radius is: " + c2.getRadius() + " Area is:" + c2.getArea());
	}

}
