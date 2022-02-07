package tar;

public class CounterThread implements Runnable {
	private int delay;

	public CounterThread(int delay) {
		this.delay = delay;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + ": " + Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(this.delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
