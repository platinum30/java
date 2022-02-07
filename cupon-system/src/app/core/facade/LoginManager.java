package app.core.facade;

import app.core.beans.ClientType;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;

public class LoginManager {
	private static LoginManager instance;

	public static LoginManager getInstance() {
		if (instance == null) {
			instance = new LoginManager();
		}
		return instance;
	}

	private LoginManager() {

	}

	public ClientFacade login(String email, String password, ClientType clientType)
			throws CouponRTException, CouponSuccess {
		switch (clientType.ordinal()) {
		case 0:// admin
			AdminFacade adminFacade = new AdminFacade();
			if (adminFacade.login(email, password)) {
				return adminFacade;
			} else {
				throw new CouponRTException("Login failed - email or password is incorrect");
			}

		case 1:// company
			CompanyFacade companyFacade = CompanyFacade.getInstance();
			if (companyFacade.login(email, password)) {
				companyFacade.setCompanyId(companyFacade.getCompanyIdByEMail(email));
				return companyFacade;
			} else {
				throw new CouponRTException("Login failed - email or password is incorrect");
			}
		case 2:// customer
			CustomerFacade customerFacade = new CustomerFacade();
			if (customerFacade.login(email, password)) {
				customerFacade.setCustomerId(customerFacade.getCustomerIdByEmail(email));
				return customerFacade;
			} else {
				throw new CouponRTException("Login failed - email or password is incorrect");
			}
		default:
			return null;
		}

	}
}
