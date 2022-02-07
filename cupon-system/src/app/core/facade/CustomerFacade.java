package app.core.facade;

import java.time.LocalDate;
import java.util.ArrayList;

import app.core.beans.Category;
import app.core.beans.Coupon;
import app.core.beans.Customer;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;

public class CustomerFacade extends ClientFacade {
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public CustomerFacade() {

	}

	@Override
	protected boolean login(String email, String password) throws CouponRTException, CouponSuccess {
		return customersDAO.isCustomerExists(email, password);
	}

	/**
	 * function add coupon purchase. before that function check if coupon is on
	 * stock, if coupon not bought yet by customer, and if coupon not expired, Then
	 * reduce coupon amount by 1
	 * 
	 * @param coupon
	 * @throws CouponRTException
	 */
	public void purchaseCoupon(Coupon coupon) throws CouponRTException, CouponSuccess {
		LocalDate dateNow = LocalDate.now();
		if (coupon.getAmount() == 0)
			throw new CouponRTException("Purchase coupon failed - coupon amount is 0");
		if (couponsDAO.isCouponAlreadyPurchased(this.customerId, coupon.getId()))
			throw new CouponRTException("Purchase coupon failed -  you already purchased this coupon!");
		if (coupon.getEndDate().isBefore(dateNow))
			throw new CouponRTException("Purchase coupon failed -  can't buy expired coupons");
		couponsDAO.addCouponPurchase(this.customerId, coupon.getId());// ADD COUPON PURCHASE
		coupon.setAmount(coupon.getAmount() - 1);
		couponsDAO.updateCoupon(coupon);// Update coupon amount
	}

	public ArrayList<Coupon> getCoustomerCoupons() throws CouponRTException, CouponSuccess {
		return couponsDAO.getAllCustomerCoupons(this.customerId);
	}

	public ArrayList<Coupon> getCoustomerCoupons(Category category) throws CouponRTException, CouponSuccess {
		ArrayList<Coupon> customerCoupons = couponsDAO.getAllCustomerCoupons(this.customerId);
		ArrayList<Coupon> couponsFromCat = new ArrayList<>();
		for (Coupon coupon : customerCoupons) {
			if (coupon.getCategory().equals(category))
				couponsFromCat.add(coupon);
		}
		return couponsFromCat;
	}

	public ArrayList<Coupon> getCoustomerCoupons(double maxPrice) throws CouponRTException, CouponSuccess {
		ArrayList<Coupon> customerCoupons = couponsDAO.getAllCustomerCoupons(this.customerId);
		ArrayList<Coupon> couponsFromCat = new ArrayList<>();
		for (Coupon coupon : customerCoupons) {
			if (coupon.getPrice() <= maxPrice)
				couponsFromCat.add(coupon);
		}
		return couponsFromCat;
	}

	public Customer getCustomerDetails() throws CouponRTException, CouponSuccess {
		return customersDAO.getCustomerById(this.customerId);
	}

	public int getCustomerIdByEmail(String email) throws CouponRTException, CouponSuccess {
		Customer customer = customersDAO.getCustomerByEmail(email);
		return customer.getId();
	}

}
