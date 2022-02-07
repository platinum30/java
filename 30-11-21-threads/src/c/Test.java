package c;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CounterThread t1 = new CounterThread("t1");
		CounterThread t2 = new CounterThread("t2");

		t1.start();
		t2.start();
		sc.nextLine();
	}

}
