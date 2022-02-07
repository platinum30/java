package a;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Test {
	public static void main(String[] args) {
		int mispar = Integer.MIN_VALUE;
		long aaasdas = 111111111;
		double b = 1.1;
		String c = "xacaascsacas";

		/*
		 * System.out.println("byte min - " + Byte.MIN_VALUE);
		 * System.out.println("byte max - " + Byte.MAX_VALUE);
		 * System.out.println("============================");
		 * System.out.println("int min - " + Integer.MIN_VALUE);
		 * System.out.println("int max - " + Integer.MAX_VALUE);
		 * System.out.println("============================");
		 * System.out.println("double min - " + Double.MIN_VALUE);
		 * System.out.println("double max - " + Double.MAX_VALUE);
		 * System.out.println("============================");
		 * System.out.println("float min - " + Float.MIN_VALUE);
		 * System.out.println("float max - " + Float.MAX_VALUE);
		 * System.out.println("============================");
		 * System.out.println("Short min - " + Short.MIN_VALUE);
		 * System.out.println("Short max - " + Short.MAX_VALUE);
		 * System.out.println("============================");
		 */
		String lc;
		System.out.println("===welcome to alarm clock===");

		while (true) {
			lc = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
			if (lc.equals("22:38:00")) {
				java.awt.Toolkit.getDefaultToolkit().beep();
			}
		}
		/*
		 * while (true) { Scanner sc = new Scanner(System.in); int a;
		 * System.out.println("pelase type something"); a = sc.nextInt(); if (a == 1) {
		 * System.out.println("yay"); } else { System.out.println("nope"); } }
		 */

	}

}
