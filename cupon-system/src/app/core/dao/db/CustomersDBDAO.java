package app.core.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.core.beans.Customer;
import app.core.dao.interfaces.CustomersDAO;
import app.core.data.ConnectionPool;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;

public class CustomersDBDAO implements CustomersDAO {
	public static CustomersDBDAO instance;

	public static CustomersDBDAO getInstance() {
		if (instance == null) {
			instance = new CustomersDBDAO();
		}
		return instance;
	}

	private CustomersDBDAO() {

	}

	@Override
	public boolean isCustomerExists(String email, String password) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from customers where email = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			int rowCount = 0;
			while (rs.next()) {
				rowCount++;
			}
			ConnectionPool.getInstance().restoreConnection(con);
			return (rowCount > 0);

		} catch (SQLException e) {
			throw new CouponRTException("check if customer exists failed", e);
		}
	}

	@Override
	public void addCustomer(Customer customer) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "insert into customers values(0,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int customerId = rsId.getInt(1);
			customer.setId(customerId);

			ConnectionPool.getInstance().restoreConnection(con);// return connection back to pool
			throw new CouponSuccess(customer.getFirstName() + " " + customer.getLastName()
					+ " added successfully - customer id is: " + customerId);
		} catch (SQLException e) {
			throw new CouponRTException("add customer failed ", e);
		}

	}

	@Override
	public void updateCustomer(Customer customer) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "update customers set first_name=?,last_name=?, email=?,password=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.setInt(5, customer.getId());
			pstmt.executeUpdate();

			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponSuccess("Customer - " + customer.getFirstName() + " updated");
		} catch (SQLException e) {
			throw new CouponRTException("update customer failed", e);
		}

	}

	@Override
	public void deleteCustomer(int customerID) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "delete from customers where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, customerID);
			int rowCount = pstmt.executeUpdate();

			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponSuccess("Customer deleted successfully");
		} catch (SQLException e) {
			throw new CouponRTException("delete customer failed", e);
		}

	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws CouponRTException, CouponSuccess {

		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from customers";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Customer> list = new ArrayList<Customer>();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				list.add(customer);
			}
			ConnectionPool.getInstance().restoreConnection(con);
			return list;
		} catch (SQLException e) {
			throw new CouponRTException("get all customers failed ", e);
		}
	}

	private Customer getOneCustomer(String condition) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from customers " + condition;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				ConnectionPool.getInstance().restoreConnection(con);
				return customer;
			}
			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponRTException("customer  not found");
		} catch (SQLException e) {
			throw new CouponRTException("get customer failed", e);
		}
	}

	@Override
	public Customer getCustomerById(int customerID) throws CouponRTException, CouponSuccess {
		return getOneCustomer("WHERE id='" + customerID + "'");
	}

	@Override
	public Customer getCustomerByEmail(String customerEmail) throws CouponRTException, CouponSuccess {
		return getOneCustomer("WHERE email='" + customerEmail + "'");
	}

}
