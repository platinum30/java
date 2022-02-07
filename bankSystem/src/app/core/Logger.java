package app.core;

public class Logger {
	private String driverName;
	private static Logger instance = new Logger(null);

	private Logger(String driverName) {
		this.driverName = driverName;
	}

	public void log(Log log) {
		System.out.println(log.getData());
	}

	public Log[] getLogs() {
		Log[] logArr = new Log[10];
		return logArr;
	}

	public static Logger getInstance() {
		return instance;
	}
}
