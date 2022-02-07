package app.core.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import app.core.exceptions.CouponRTException;

public class ConnectionPool {
	private Set<Connection> connections = new HashSet<Connection>();
	public static final int POOL_SIZE = 5;
	private String dbUrl = "jdbc:mysql://localhost:3306/coupon_system";
	private String user = "root";
	private String pass = "1234";
	private boolean open;

	private static ConnectionPool instance;

	private ConnectionPool() throws CouponRTException {
		// add 5 connections to pool
		for (int i = 0; i < POOL_SIZE; i++) {
			try {
				this.connections.add(DriverManager.getConnection(dbUrl, user, pass));
			} catch (SQLException e) {
				throw new CouponRTException(e);
			}
		}
		// System.out.println("pool started with " + connections.size() + "
		// connections");
		open = true;
	}

	public static ConnectionPool getInstance() throws CouponRTException {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	public synchronized Connection getConnection() throws CouponRTException {
		if (!open) {
			throw new CouponRTException("can't get connection - pool is closed");
		}
		while (this.connections.isEmpty()) {
			try {
				System.out.println("waiting for connection...");
				wait();
			} catch (InterruptedException e) {
				throw new CouponRTException(e);
			}
		}
		Iterator<Connection> it = connections.iterator();
		Connection con = it.next();
		it.remove();
		// System.out.println("get connection seccessfully");
		return con;
	}

	public synchronized void restoreConnection(Connection con) {
		this.connections.add(con);
		notifyAll();
		// System.out.println("connection returned");
	}

	public synchronized void closeAllConnections() {
		open = false;
		while (this.connections.size() < POOL_SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Iterator<Connection> it = this.connections.iterator();
		while (it.hasNext()) {
			try {
				it.next().close();
				it.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("pool closed with " + connections.size() + "
		// connections");

	}

}
