package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4Select {

	public static void main(String[] args) {
		String userName = "root";
		String password = "1234";
		String url = "jdbc:mysql://localhost:3306/db1";
		try (Connection con = DriverManager.getConnection(url, userName, password)) {
			System.out.println("connected");
			// ==================================================
			String query = "select * from person;";
			System.out.println(query);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// get the row data
				int id = rs.getInt("id");// get data from column by col name
				String name = rs.getString(2);// get data from column by col num/id
				int age = rs.getInt(3);
				System.out.println(id + ", " + name + ", " + age);
			}
			// ==================================================
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("disconnected");
	}

}
