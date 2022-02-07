package app.core.dao.interfaces;

import java.util.ArrayList;

import app.core.beans.Category;
import app.core.beans.Coupon;

public interface CouponsDAO {
	void addCoupon(Coupon coupon) throws Exception;

	void updateCoupon(Coupon coupon) throws Exception;

	void deleteCouponByCouponId(int couponID) throws Exception;

	void deleteCouponByCompanyId(int companyId) throws Exception;

	ArrayList<Coupon> getAllCoupon() throws Exception;

	ArrayList<Coupon> getAllCouponsByCompanyId(int companyId) throws Exception;

	ArrayList<Coupon> getAllCompanyCouponsByCategory(int companyId, Category category) throws Exception;

	boolean isCompanyCouponExistsByTitle(int companyId, String couponTitle) throws Exception;

	Coupon getOneCoupon(int couponID) throws Exception;

	// coupon purchases
	boolean isCouponAlreadyPurchased(int customerId, int couponId) throws Exception;

	void addCouponPurchase(int customerID, int couponID) throws Exception;

	ArrayList<Coupon> getAllCustomerCoupons(int customerId) throws Exception;

	void deleteCouponPurchase(int customerID, int couponID) throws Exception;

	void deletePurchasesByCouponId(int couponID) throws Exception;

	void deletePurchasesByCustomerId(int couponID) throws Exception;

	ArrayList<Coupon> getExpierdCoupons() throws Exception;

}
