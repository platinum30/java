package b;

public class MyThread extends Thread {

	public MyThread(String name) {
		this.setName(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i + ":" + getName());
		}
		super.run();
	}

}
