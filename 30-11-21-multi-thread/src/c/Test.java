package c;

public class Test {

	public static void main(String[] args) {
		MyRunable r = new MyRunable();
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		t1.start();
		t2.start();

	}

}
