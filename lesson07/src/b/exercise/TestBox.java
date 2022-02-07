package b.exercise;

public class TestBox {

	public static void main(String[] args) {
		Box box1 = new Box(20, 38, 42);
		Box box2 = new Box(44, 65, 86);
		Box box3 = new Box(12, 97, 98);

		System.out.println("box 1 values is:" + " length-" + box1.getLength() + " width-" + box1.getWidth() + " height-"
				+ box1.getHeight());
		System.out.println("box 2 values is:" + " length-" + box2.getLength() + " width-" + box2.getWidth() + " height-"
				+ box2.getHeight());
		System.out.println("box 3 values is:" + " length-" + box3.getLength() + " width-" + box3.getWidth() + " height-"
				+ box3.getHeight());

	}

}
