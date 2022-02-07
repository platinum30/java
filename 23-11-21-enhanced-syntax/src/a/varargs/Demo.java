package a.varargs;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(10, 14, 23));
	}

	public static int sum(int... numbers) {
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		return sum;
	}

}
