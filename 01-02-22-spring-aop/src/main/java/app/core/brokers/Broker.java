package app.core.brokers;

public interface Broker {
	public void sell(int quantity);

	public void buyStocks(int quantity);

	public void buyCars(int quantity);
}
