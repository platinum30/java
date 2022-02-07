package a;

import java.util.Scanner;

public class Demo02Cinema {
	public static void main(String[] args) {
		Cinema c1 = new Cinema(5,4);
		Cinema c2 = new Cinema(10,25);
		c1.display();
		//c2.display();
		
		System.out.println("where do you want to seat?");
		System.out.println("please enter row number");
		Scanner sc = new Scanner(System.in);
		int wantedRow = sc.nextInt();
		System.out.println("please enter seat number");
		int wantedSeat = sc.nextInt();
		c1.add(wantedRow, wantedSeat);
		c1.display();
	}
	
}
