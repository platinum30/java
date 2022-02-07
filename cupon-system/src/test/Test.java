package test;

import java.time.LocalDate;

import app.core.beans.Category;
import app.core.beans.Company;
import app.core.beans.Coupon;
import app.core.dao.db.CompaniesDBDAO;
import app.core.dao.db.CouponsDBDAO;
import app.core.facade.AdminFacade;

public class Test {

	public static void main(String[] args) throws Exception {
		Company company = new Company("h&ma", "aplatinum30@gmail.com", "addda");
		AdminFacade adminFacade = new AdminFacade();
//		try {
//			// adminFacade.addCompany(company);
//		} catch (CouponException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (CouponRTException e) {
//			System.err.println(e.getMessage());
//		}

		// CompaniesDBDAO compDAO = new CompaniesDBDAO();
		// CustomersDBDAO custDAO = new CustomersDBDAO();
		CompaniesDBDAO companyDBDAO = CompaniesDBDAO.getInstance();
		AdminFacade adminF = new AdminFacade();
		Company company3 = new Company("ZARadsaac", "platinumht@gmail.com", "1ddda");
		// adminF.addCompany(company3);
		// adminF.deleteCompany(6);
		// compDAO.addCompany(company);

		// Company company2 = compDAO.getOneCompany(6);
		// System.out.println(company2);

		// System.out.println(compDAO.getAllCompanies());

		// if (compDAO.isCompanyExists("platinum30@gmail.com", "addda")) {
		// System.out.println("yes");
		// } else {
		// System.out.println("no");
		// }
		// compDAO.deleteCompany(9);
		// compDAO.updateCompany(company3);

		// Customer cust = new Customer(0, "tzah", "zazon", "platinum30@gmail.com",
		// "password", null);
		// custDAO.deleteCustomer(2);
		// System.out.println(custDAO.getAllCustomer());
		// System.out.println(custDAO.getOneCustomer(3));

		// int companyId Category category String title; String description; LocalDate
		// startDate; LocalDate endDate; int amount;
		// double price; String image;
//
		Coupon coupon = new Coupon();
		coupon.setCategory(Category.FOOD);
		coupon.setTitle("test title1");
		coupon.setCompanyId(7);
		coupon.setDescription("test desc1");
		coupon.setStartDate(LocalDate.now());
		coupon.setEndDate(LocalDate.of(2022, 1, 27));
		coupon.setAmount(10);
		coupon.setPrice(10.5);
		coupon.setImage("image.jpg");
		coupon.setId(3);
		System.out.println(Category.FOOD.ordinal());
//		System.out.println(coupon.getStartDate());
//		System.out.println(coupon.getEndDate());
//
		CouponsDBDAO couponDAO = new CouponsDBDAO();

//		// couponDAO.deleteCoupon(3);
		// couponDAO.addCoupon(coupon);
		// System.out.println(couponDAO.getAllCoupon("where company_id=6"));
		// System.out.println(couponDAO.getAllCompanyCoupons(6));
//		// System.out.println(couponDAO.getOneCoupon(4));
		// couponDAO.addCouponPurchase(3, 17);
		System.out.println("is? " + couponDAO.isCouponAlreadyPurchased(3, 18));
//		couponDAO.deleteCouponPurchase(1, 5);
		LocalDate dateNow = LocalDate.now();
		LocalDate date = LocalDate.of(2022, 01, 28);
		System.out.println(date.isBefore(dateNow));

	}

}
