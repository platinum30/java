package b.flow.control.loops;
import java.util.Scanner;
public class Demo01While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pass;
		int attempts = 0;
		do {
			System.out.println("enter password (" + attempts + " used from 3)");
			attempts++;
			pass = sc.nextInt();
			
		}while(pass != 123 && attempts < 3);// check if correct pass entered or max attempts reached
		sc.close();
		if(pass == 123) {
		System.out.println("logged in");
		}else {
			System.out.println("login failed");
		}
		sc.close();

	}

}
