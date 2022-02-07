package a;

public class Application {
	public static void main(String[] args) {
		BrokerProxy brk = new BrokerProxy();
		brk.buy(4);
		brk.buy(1);
		brk.sell(2);

		System.out.println("========== statistics");
		System.out.println("buy quantity = ");
		System.out.println("========== statistics");
	}
}
