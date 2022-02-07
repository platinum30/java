package a;

public class Calculator {

	public int sum(int a, int b) {
		return a + b;
	}

	public int div(int a, int b) throws Exception {// throws declaration
		if (b != 0) {
			return a / b;
		} else {
			Exception e = new Exception("error - divide by 0");// create obj exception
			throw e;// throw an Exception object
		}
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		try {
			System.out.println(calc.sum(4, 5));
			System.out.println(calc.div(4, 0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("ERROR - END PROGRAM");
	}

}
