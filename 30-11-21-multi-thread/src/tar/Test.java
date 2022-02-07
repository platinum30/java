package tar;

public class Test {

	public static void main(String[] args) {
		CounterThread ct = new CounterThread(1000);
		Thread t1 = new Thread(ct, "t1");
		Thread t2 = new Thread(ct, "t2");
		t1.start();
		t2.start();
	}

}
