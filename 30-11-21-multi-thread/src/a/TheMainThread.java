package a;

public class TheMainThread {
	public static void main(String[] args) throws InterruptedException {
		// if main is running there must be a thread object for it.
		// get a refernce to the currently exeuting thread object
		Thread t = Thread.currentThread();
		System.out.println("thread name is: " + t.getName());
		System.out.println(1);
		t.sleep(1000);// delay the thread running for 1 sec
		System.out.println(2);
		t.sleep(1000);
		System.out.println(3);
	}

}
