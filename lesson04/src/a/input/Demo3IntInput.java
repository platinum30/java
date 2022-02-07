package a.input;

import java.util.Scanner;

public class Demo3IntInput {

	public static void main(String[] args) {
		System.out.println("enter number");
		Scanner sc = new Scanner (System.in);
		int a = sc.nextInt();
		
		System.out.println("enter another number");
		int b = sc.nextInt();
		
		System.out.println("the sum is: " + (a+b));
		sc.close();
		
	}

}
