package app.core.facade;

import java.util.ArrayList;

import app.core.beans.Category;
import app.core.beans.Company;
import app.core.beans.Coupon;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;

public class CompanyFacade extends ClientFacade {
	private int companyId;
	private static CompanyFacade instance;

	public static CompanyFacade getInstance() {
		if (instance == null)
			instance = new CompanyFacade();
		return instance;
	}

	@Override
	protected boolean login(String email, String password) throws CouponRTException, CouponSuccess {
		return companiesDAO.isCompanyExists(email, password);
	}

	private CompanyFacade() {
	}

	public void addCoupon(Coupon coupon) throws Exception {
		if (!couponsDAO.isCompanyCouponExistsByTitle(this.companyId, coupon.getTitle()))
			couponsDAO.addCoupon(coupon);
		else
			throw new CouponRTException("this company already have coupon with the same title");

	}

	/**
	 * Function get coupon, check the condition of update by business logic, and
	 * update it on DB
	 * 
	 * if we got false ON condition #NO 1, its means that coupon name have been
	 * changed, and that we have to check if company already have coupon with the
	 * same title (like on creation), condition #NO 2 will check it (I know that i
	 * can join them)
	 * 
	 * @param coupon
	 * @throws CouponRTException
	 */
	public void updateCoupon(Coupon coupon) throws CouponRTException, CouponSuccess {
		Coupon existsCoupon = couponsDAO.getOneCoupon(coupon.getId());
		if (!(existsCoupon.getTitle().equals(coupon.getTitle()))) {// condition #NO 1
			if (!couponsDAO.isCompanyCouponExistsByTitle(this.companyId, coupon.getTitle()))// condition #NO 2
				throw new CouponRTException("this company already have coupon with the same title");
		}

		if (existsCoupon.getCompanyId() == coupon.getCompanyId())// condition #NO 3 - check if company id changed
			couponsDAO.updateCoupon(coupon);
		else
			throw new CouponRTException("update coupon company id is illegal");
	}

	public void deleteCoupon(int couponId) throws CouponRTException, CouponSuccess {
		couponsDAO.deletePurchasesByCouponId(couponId);
		couponsDAO.deleteCouponByCouponId(couponId);
	}

	public ArrayList<Coupon> getCompanyCoupons() throws CouponRTException, CouponSuccess {
		return couponsDAO.getAllCouponsByCompanyId(this.companyId);
	}

	public ArrayList<Coupon> getCompanyCoupons(Category category) throws CouponRTException, CouponSuccess {
		return couponsDAO.getAllCompanyCouponsByCategory(this.companyId, category);
	}

	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws CouponRTException, CouponSuccess {
		ArrayList<Coupon> companyCoupons = couponsDAO.getAllCouponsByCompanyId(this.companyId);
		ArrayList<Coupon> maxPriceCoupons = new ArrayList<Coupon>();
		for (Coupon coupon : companyCoupons) {
			if (coupon.getPrice() <= maxPrice)
				maxPriceCoupons.add(coupon);
		}
		return maxPriceCoupons;
	}

	public Company getCompanyDetails() throws CouponRTException, CouponSuccess {
		return companiesDAO.getCompanyById(this.companyId);
	}

	public int getCompanyIdByEMail(String email) throws CouponRTException, CouponSuccess {
		Company company = companiesDAO.getCompanyByEmail(email);
		return company.getId();
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
