package a;

public class BrokerImpl implements Broker {

	@Override
	public void sell(int quantity) {
		System.out.println(quantity + " pcs bought");
	}

	@Override
	public void buy(int quantity) {
		System.out.println(quantity + " pcs sold");
	}

}
