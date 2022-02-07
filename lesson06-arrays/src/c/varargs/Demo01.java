package c.varargs;

public class Demo01 {

	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		// method invocation (call)

		// a and b are methods arguments
		int sum = sumArgs(a, b, 10, 5, 9);// 5 and 9 are arguments or args
		System.out.println(sum);
		// System.out.println(sum);

	}

	// a and b are parameters
	public static int sum(int a, int b) {
		return a + b;
	}

	public static int sumArgs(int... args) {
		int sum = 0;// using var args, args are array
		for (int i = 0; i < args.length; i++) {
			sum += args[i];
		}
		return sum;
	}
}
