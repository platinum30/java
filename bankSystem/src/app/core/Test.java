package app.core;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client(121, "David", 2000);
		System.out.println("client balance=" + client.getBalance());
		// client.AddAccount(101, 2000);
		System.out.println(client.getAccount(101));
		client.removeAccount(101);
		System.out.println("client balance=" + client.getBalance());
		client.autoUpdateAccount();
		System.out.println(client.getFortune());
	}

}
