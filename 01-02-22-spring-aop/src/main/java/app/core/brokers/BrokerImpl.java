package app.core.brokers;

import org.springframework.stereotype.Component;

@Component
public class BrokerImpl implements Broker {

	@Override
	public void sell(int quantity) {
		System.out.println(quantity + " pcs sold");
	}

	@Override
	public void buyStocks(int quantity) {
		System.out.println(quantity + " stocks bought");

	}

	@Override
	public void buyCars(int quantity) {
		System.out.println(quantity + " cars bought");
	}

}
