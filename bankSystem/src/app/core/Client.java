package app.core;

/**
 * @author plati
 *
 */
public class Client {
	private int id;
	private String name;
	private float balance;
	private Account[] accounts = new Account[5];
	private float commissionRate = 0;
	private float interestRate = 0;
	private Logger logger = Logger.getInstance();

	public Client(int id, String name, float balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		// logger = new Logger("driverName");
	}

	/**
	 * @param id      - account id
	 * @param balance - the starting balance
	 */
	public void AddAccount(Account account) {// add account
		int tempIndex = 0;
		for (int i = 0; i < this.accounts.length; i++) {
			if (this.accounts[i] == null) {// check if there are empty cell in arr
				this.accounts[i] = account;
				Log log = new Log(System.currentTimeMillis(), this.id, "Add Account", account.getBalance());
				logger.log(log);
				break;
			}
			tempIndex++;
		}
		if (tempIndex == 5) {
			System.out.println("Client already have 5 account (maximum allowed)");
		}
	}

	/**
	 * @param index - id of the account to get
	 * @return
	 */
	public Account getAccount(int index) {
		Account tempAccount = null;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				if (accounts[i].getId() == index) {
					tempAccount = accounts[i];
					break;
				}
			}
		}
		return tempAccount;
	}

	/**
	 * the void get account id to remove, check if account exist, and if so, its add
	 * account balance to client balance, remove the account and create log
	 * 
	 * @param id - id of the account to remove
	 * @return
	 */
	public void removeAccount(int id) {// remove account
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				if (accounts[i].getId() == id) {
					Log log1 = new Log(System.currentTimeMillis(), this.id, "Remove Account", accounts[i].getBalance());
					this.balance += accounts[i].getBalance(); // add account balance to client balance
					Log log2 = new Log(System.currentTimeMillis(), this.id, "Increase Client balance",
							accounts[i].getBalance());
					accounts[i] = null;
					break;
				} else {
					System.out.println("account not found");
				}
			}
		}
	}

	/**
	 * void add amount to client balance minus commission rate, and create a log
	 * 
	 * @param amount - amount to deposit
	 */

	public void deposit(float amount) {
		float commission = amount * this.commissionRate;
		this.balance += (amount - commission);
		Log log = new Log(System.currentTimeMillis(), this.id, "Deposit", (amount - commission));
		logger.log(log);
	}

	/**
	 * void check if client have enough balance, and if so, remove the amount and
	 * commessionRate from balance, and create a log
	 * 
	 * @param amount - amount to withdrawal
	 */
	public void withraw(float amount) {
		if (this.balance >= amount) {// check if client have enough balance
			this.balance = this.balance - amount - this.commissionRate;
			Log log = new Log(System.currentTimeMillis(), this.id, "Withraw", amount);
			logger.log(log);
		} else {
			System.out.println("There is not enough balance");
		}

	}

	/**
	 * void update client balance according to the interest
	 */
	public void autoUpdateAccount() {
		for (Account currentAccount : this.accounts) {
			if (currentAccount != null) {
				float interestValue = currentAccount.getBalance() * (this.interestRate / 100);
				currentAccount.setBalance(interestValue);
				Log log = new Log(System.currentTimeMillis(), currentAccount.getId(), "Account balance increased",
						interestValue);
				logger.log(log);
			}
		}
	}

	public float getFortune() {
		float sum = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				sum += accounts[i].getBalance();
			}
		}
		sum += this.balance;
		return sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public static void main(String[] args) {
		Client client = new Client(101, "Avidan", 5000);
		Account account = new Account(101, 20000);
		client.AddAccount(account);
		System.out.println(client.getAccount(1));
		System.out.println(client.getAccount(101));

	}
}
