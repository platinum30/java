package tar;

public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		CounterThreadExtends t1 = new CounterThreadExtends();
		System.out.println(t1.getState());
		System.out.println(t1.isAlive());

		t1.start();
		System.out.println(t1.isAlive());

		System.out.println(t1.getState());
		Thread.sleep(500);

		t1.join();// Causes this thread (main) to stop until t1 is therminated
		System.out.println(t1.getState());
		System.out.println(t1.isAlive());

	}
}
