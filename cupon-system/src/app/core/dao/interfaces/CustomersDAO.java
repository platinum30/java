package app.core.dao.interfaces;

import java.util.ArrayList;

import app.core.beans.Customer;

public interface CustomersDAO {
	public boolean isCustomerExists(String email, String password) throws Exception;

	public void addCustomer(Customer customer) throws Exception;

	public void updateCustomer(Customer customer) throws Exception;

	public void deleteCustomer(int customerID) throws Exception;

	public ArrayList<Customer> getAllCustomer() throws Exception;

	public Customer getCustomerById(int customerID) throws Exception;

	public Customer getCustomerByEmail(String customerEmail) throws Exception;
}
