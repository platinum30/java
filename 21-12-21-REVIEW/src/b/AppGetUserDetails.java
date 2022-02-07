package b;

import java.util.Scanner;

public class AppGetUserDetails {

	public static void main(String[] args) {
		ReminderThread t = new ReminderThread("כבר נו", 10, 1);
		t.start();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("enter name:");
			String name = sc.nextLine();
			System.out.println("enter password");
			String password = sc.nextLine();
			System.out.println("Thanks");

			System.out.println("You entered user: " + name + " , password:" + password);
		}
		t.interrupt();// close thread
	}

}
