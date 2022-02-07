package app.core;

public class Account {
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}

	private int id;
	private float balance;

	public Account(int id, float balance) {
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
		Log log = new Log(System.currentTimeMillis(), 101, "SET BALANCE", balance);
	}

}
