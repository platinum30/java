package app.core.facade;

import java.util.ArrayList;

import app.core.beans.Company;
import app.core.beans.Coupon;
import app.core.beans.Customer;
import app.core.dao.db.CustomersDBDAO;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;

public class AdminFacade extends ClientFacade {
	private final String email = "admin@admin.com";
	private final String password = "admin";
	private static AdminFacade instance;

	public static AdminFacade getInstance() {
		if (instance == null)
			instance = new AdminFacade();
		return instance;
	}

	@Override
	public boolean login(String email, String password) {
		if (this.email.equals(email) && this.password.equals(password))
			return true;
		return false;
	}

//companies
	/**
	 * function add company to Mysql DB if company name and email are unique, else
	 * function will throw exception
	 * 
	 * @param company
	 * @throws CouponRTException
	 */
	public void addCompany(Company company) throws CouponRTException, CouponSuccess {
		String name = company.getName();
		String email = company.getEmail();
		boolean error = false;
		try {
			Company c = companiesDAO.getCompanyByEmailOrName(email, name);
			if (c != null)
				error = true;
		} finally {
			if (error)
				throw new CouponRTException("add company failed, company with the same name or email is already exist.");
			else
				companiesDAO.addCompany(company);
		}

	}

	/**
	 * function update company if company name have not changed
	 * 
	 * @param company
	 * @throws CouponRTException
	 */
	public void updateCompany(Company company) throws CouponRTException, CouponSuccess {
		Company company2 = companiesDAO.getCompanyById(company.getId());

		if (!company2.getName().equals(company.getName()))
			throw new CouponRTException("update company failed - update company name is illegal");

		if (!company.getEmail().equals(company2.getEmail())) {// check if email changed
			boolean error = false;
			try {
				if (companiesDAO.getCompanyByEmail(company.getEmail()) != null)
					error = true;
			} finally {
				if (error)
					throw new CouponRTException(
							"update company failed - company with the same email address is already exists");
				else
					companiesDAO.updateCompany(company);
			}
		}
	}

	public void deleteCompany(int companyId) throws CouponRTException, CouponSuccess {
		ArrayList<Coupon> companyCoupons = couponsDAO.getAllCouponsByCompanyId(companyId);
		for (Coupon coupon : companyCoupons) {
			couponsDAO.deletePurchasesByCouponId(coupon.getId());// delete all company coupons purchases
		}

		try {
			couponsDAO.deleteCouponByCompanyId(companyId);// delete all company coupons
		} catch (CouponSuccess e) {

		} finally {
			companiesDAO.deleteCompany(companyId);// finally delete company
		}

	}

	public ArrayList<Company> getAllCompanies() throws CouponRTException {
		return companiesDAO.getAllCompanies();
	}

	public Company getOneCompany(int companyId) throws CouponRTException, CouponSuccess {
		return companiesDAO.getCompanyById(companyId);
	}

	// customers
	public void addCustomer(Customer customer) throws CouponRTException, CouponSuccess {
		boolean error = false;
		try {
			if (customersDAO.getCustomerByEmail(customer.getEmail()) != null)
				error = true;
		} catch (CouponRTException e) {
			customersDAO.addCustomer(customer);
		} finally {
			if (error)
				throw new CouponRTException("Customer with the same Email address already exists");
		}

	}

	public void updateCustomer(Customer customer) throws CouponRTException, CouponSuccess {
		boolean error = false;
		try {
			if (!(customer.getEmail()
					.equals(CustomersDBDAO.getInstance().getCustomerById(customer.getId()).getEmail()))) {
				// here we check if customer email changed

				// if we are here, customer email changed, and we have to check if its already
				// exists
				if (customersDAO.getCustomerByEmail(customer.getEmail()) != null)
					error = true;
			}
		} finally {
			if (error)
				throw new CouponRTException("Customer with the same Email address already exists");
			else
				customersDAO.updateCustomer(customer);
		}

	}

	public void deleteCustomer(int customerId) throws CouponRTException, CouponSuccess {
		try {
			couponsDAO.deletePurchasesByCustomerId(customerId);// First delete all customer coupon purchases
		} catch (CouponSuccess e) {
			customersDAO.deleteCustomer(customerId);// then delete the customer
		}

	}

	public ArrayList<Customer> getAllCustomers() throws CouponRTException, CouponSuccess {
		return customersDAO.getAllCustomer();
	}

	public Customer getOneCustomer(int customerId) throws CouponRTException, CouponSuccess {
		return customersDAO.getCustomerById(customerId);
	}

}
