package app.core;

public class Log {
	private long timestamp;
	private int clientid;
	private String description;
	private float amount;

	public Log(long timestamp, int clientid, String description, float amount) {
		super();
		this.timestamp = timestamp;
		this.clientid = clientid;
		this.description = description;
		this.amount = amount;
	}

	public String getData() {
		return "[" + timestamp + ", " + clientid + ", " + description + ", " + amount + "]";
	}

	public static void main(String[] args) {
		Log log = new Log(System.currentTimeMillis(), 101, "withraw", 100);
		System.out.println(log.getData());
		System.out.println(System.currentTimeMillis());
	}
}
