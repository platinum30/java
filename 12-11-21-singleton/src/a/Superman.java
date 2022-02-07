package a;

public class Superman {
	// 1.thr single instance
	private static Superman instance = new Superman();

	// 2.private CTOR
	private Superman() {
	}

	// 3.getter for instance
	public static Superman getInstance() {
		return instance;
	}
}
