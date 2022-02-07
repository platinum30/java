package a;

public class BrokerProxy implements Broker {
	private BrokerImpl brk = new BrokerImpl();
	private int countBuy;
	private int countSell;

	@Override
	public void sell(int quantity) {
		brk.buy(quantity);
		countSell += quantity;
	}

	@Override
	public void buy(int quantity) {
		brk.buy(quantity);
		countBuy += quantity;
	}

}
