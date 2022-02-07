package app.core.facade;

import app.core.dao.db.CompaniesDBDAO;
import app.core.dao.db.CouponsDBDAO;
import app.core.dao.db.CustomersDBDAO;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;

public abstract class ClientFacade {
	protected CompaniesDBDAO companiesDAO = CompaniesDBDAO.getInstance();
	protected CustomersDBDAO customersDAO = CustomersDBDAO.getInstance();
	protected CouponsDBDAO couponsDAO = new CouponsDBDAO();

	protected abstract boolean login(String email, String password) throws CouponRTException, CouponSuccess;
}
