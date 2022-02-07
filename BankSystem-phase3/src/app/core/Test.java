package app.core;

import app.core.exception.BankException;

public class Test {

	public static void main(String[] args) {
		Client cl = new Client(101, "Yossi", 5000.5F);
		try {
			cl.withdraw(10000);
		} catch (BankException e) {
			System.out.println(e.getMessage());

		}

	}

}
