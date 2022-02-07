package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo2Connect {

	public static void main(String[] args) {
		String userName = "root";
		String password = "1234";
		String url = "jdbc:mysql://localhost:3306/db1";
		try (Connection con = DriverManager.getConnection(url, userName, password)) {
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("disconnected");
	}

}
