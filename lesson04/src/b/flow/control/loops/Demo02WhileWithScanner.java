package b.flow.control.loops;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Demo02WhileWithScanner {

	public static void main(String[] args) {
		//option 1 - input dialog
		//String pass = JOptionPane.showInputDialog("enter password");
		//while(pass != "123") {
			//option 1 - input dialog
		//	String name = JOptionPane.showInputDialog("worng password, try again");
		//	System.out.println(name);
		//}
		//System.out.println("logged in");
		
		
		System.out.println("enter pass: ");
		Scanner sc = new Scanner(System.in);
		int pass = sc.nextInt();
		
		int attempts = 3;
		while(pass != 123 && attempts > 1) {
			attempts--;
			System.out.println("worng pass, try again");
			System.out.println("you have " + attempts + " attempts left");
			pass = sc.nextInt();

			
		}
		if(pass == 123) {
		System.out.println("logged in");
				sc.close();
		}else {
			System.out.println("login failed");
		}

	}

}
