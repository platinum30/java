package a;

public class Demo04ObjectArray {
	public static void main(String[] args) {
		Point[] points = new Point[10];
		for (int i = 0; i < points.length; i++) {
			int x = (int)(Math.random()*101);
			int y = (int)(Math.random()*101);
			Point p = new Point(x,y); //create an object p
			points[i] = p;//insert p values into array point
			
		}
		
		//print the arrray
		for (int i = 0; i < points.length; i++) {
			System.out.println("(" +points[i].getX()+", " +points[i].getY()+ ")");
		}
	}
}
