package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAO {// DAO = Data access Object
	private String userName = "root";
	private String password = "1234";
	private String url = "jdbc:mysql://localhost:3306/db1";

	public void create(Person person) {
		String sql = "insert into person values(0, ";
		sql += "'" + person.getName() + "', ";
		sql += "'" + person.getAge() + "');";
		System.out.println(sql);
		try (Connection con = DriverManager.getConnection(url, userName, password)) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(person + " was added to DB");
	}

	public void create2(Person person) {
		String sql = "insert into person values(0, ?, ?);";
		System.out.println(sql);
		try (Connection con = DriverManager.getConnection(url, userName, password)) {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, person.getName());// 1 is the index of ? on sql query
			stmt.setInt(2, person.getAge());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(person + " was added to DB");
	}

	public static void main(String[] args) {
		PersonDAO dao = new PersonDAO();
		String name = "Michael";
		Person person = new Person(0, name, 1);
		dao.create2(person);
	}
}
