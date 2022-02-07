package a.input;

import java.util.Scanner;
public class Demo2Input {

	public static void main(String[] args) {
		//option 2 - scanner
		System.out.println("Enter name");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine(); // next method will get just one word
		System.out.println(name);
		sc.close();// closing the scanner to avoid resource leak
		
		//////////////////////////
		
		//option 2 - scanner
		System.out.println("Enter name");
		Scanner sc2 = new Scanner(System.in);
		String name2 = sc.next(); // next token (until get space)
		System.out.println(name);
		sc2.close();// closing the scanner to avoid resource leak
		
		
		
	}

}
