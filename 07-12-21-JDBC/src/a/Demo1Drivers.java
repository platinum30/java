package a;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Demo1Drivers {

	public static void main(String[] args) {
		// to use the database from java, we need a driver
		Enumeration<Driver> drivers = DriverManager.getDrivers();

		System.out.println("===========DRIVERS===========");
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			System.out.println(driver);
		}
		System.out.println("=============================");
	}

}
