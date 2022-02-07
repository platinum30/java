package app.core.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.core.beans.Category;
import app.core.beans.Coupon;
import app.core.beans.CouponPurchase;
import app.core.dao.interfaces.CouponsDAO;
import app.core.data.ConnectionPool;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;

public class CouponsDBDAO implements CouponsDAO {

	@Override
	public void addCoupon(Coupon coupon) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "insert into coupons (company_id, category_id, title, description, start_date, end_date, amount, price, image) values (?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, coupon.getCompanyId());
			pstmt.setInt(2, (coupon.getCategory().ordinal() + 1));
			pstmt.setString(3, coupon.getTitle());
			pstmt.setString(4, coupon.getDescription());
			pstmt.setDate(5, java.sql.Date.valueOf(coupon.getStartDate()));
			pstmt.setDate(6, java.sql.Date.valueOf(coupon.getEndDate()));
			pstmt.setInt(7, coupon.getAmount());
			pstmt.setDouble(8, coupon.getPrice());
			pstmt.setString(9, coupon.getImage());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int couponId = rsId.getInt(1);
			coupon.setId(couponId);

			ConnectionPool.getInstance().restoreConnection(con);// return connection back to pool
			throw new CouponSuccess("Coupon added successfully - coupon id is: " + couponId);
		} catch (SQLException e) {
			throw new CouponRTException("add coupon failed ", e);
		}

	}

	@Override
	public void updateCoupon(Coupon coupon) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();

			String sql = "update coupons set  company_id=?,category_id=?,title=?,description=?,start_date=?,end_date=?,amount=?,price=?,image=? where id =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, coupon.getCompanyId());
			pstmt.setInt(2, coupon.getCategory().ordinal() + 1);
			pstmt.setString(3, coupon.getTitle());
			pstmt.setString(4, coupon.getDescription());
			pstmt.setDate(5, java.sql.Date.valueOf(coupon.getStartDate()));
			pstmt.setDate(6, java.sql.Date.valueOf(coupon.getEndDate()));
			pstmt.setInt(7, coupon.getAmount());
			pstmt.setDouble(8, coupon.getPrice());
			pstmt.setString(9, coupon.getImage());
			pstmt.setInt(10, coupon.getId());
			pstmt.executeUpdate();

			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponSuccess("Coupon updated successfully");
		} catch (SQLException e) {
			throw new CouponRTException("update customer failed", e);
		}

	}

	@Override
	public Coupon getOneCoupon(int couponID) throws CouponRTException, CouponSuccess {

		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from coupons where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, couponID);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setCompanyId(rs.getInt("company_id"));
				coupon.setCategory(Category.getCatEnum(rs.getInt("category_id") - 1));
				coupon.setTitle(rs.getString("title"));
				coupon.setDescription(rs.getString("description"));
				coupon.setStartDate(rs.getDate("start_date").toLocalDate());
				coupon.setEndDate(rs.getDate("end_date").toLocalDate());
				coupon.setAmount(rs.getInt("amount"));
				coupon.setPrice(rs.getDouble("price"));
				coupon.setImage(rs.getString("image"));
				ConnectionPool.getInstance().restoreConnection(con);
				return coupon;
			}
			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponRTException("customer " + couponID + " not found");

		} catch (SQLException e) {
			throw new CouponRTException("get all coupons failed ", e);
		}
	}

	@Override
	public void addCouponPurchase(int customerID, int couponID) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "insert into customers_vs_coupons values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, customerID);
			pstmt.setInt(2, couponID);
			pstmt.executeUpdate();

			ConnectionPool.getInstance().restoreConnection(con);// return connection back to pool
			throw new CouponSuccess("Purchase added successfully");
		} catch (SQLException e) {
			throw new CouponRTException("add customer vs coupon failed ", e);
		}

	}

	private void deleteCoupon(String condition) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "delete from coupons" + condition;
			PreparedStatement pstmt = con.prepareStatement(sql);
			int rowCount = pstmt.executeUpdate();

			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponSuccess("coupon deleted - rows effected: " + rowCount);
		} catch (SQLException e) {
			throw new CouponRTException("delete coupon failed", e);
		}

	}

	@Override
	public void deleteCouponByCouponId(int couponID) throws CouponRTException, CouponSuccess {
		deleteCoupon("WHERE id='" + couponID + "'");
	}

	@Override
	public void deleteCouponByCompanyId(int companyId) throws CouponRTException, CouponSuccess {
		deleteCoupon(" WHERE company_id='" + companyId + "'");
	}

	private ArrayList<Coupon> getCoupons(String condition) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from coupons " + condition;

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> list = new ArrayList<Coupon>();
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setCompanyId(rs.getInt("company_id"));
				coupon.setCategory(Category.getCatEnum(rs.getInt("category_id") - 1));
				coupon.setTitle(rs.getString("title"));
				coupon.setDescription(rs.getString("description"));
				coupon.setStartDate(rs.getDate("start_date").toLocalDate());
				coupon.setEndDate(rs.getDate("end_date").toLocalDate());
				coupon.setAmount(rs.getInt("amount"));
				coupon.setPrice(rs.getDouble("price"));
				coupon.setImage(rs.getString("image"));

				list.add(coupon);
			}
			ConnectionPool.getInstance().restoreConnection(con);
			return list;
		} catch (SQLException e) {
			throw new CouponRTException("get all coupons failed ", e);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCoupon() throws CouponRTException, CouponSuccess {
		return getCoupons("");
	}

	@Override
	public ArrayList<Coupon> getAllCouponsByCompanyId(int companyId) throws CouponRTException, CouponSuccess {
		return getCoupons("WHERE company_id='" + companyId + "'");
	}

	@Override
	public ArrayList<Coupon> getAllCompanyCouponsByCategory(int companyId, Category category)
			throws CouponRTException, CouponSuccess {
		int categoryId = category.ordinal() + 1;
		return getCoupons("WHERE company_id='" + companyId + "' AND category_id='" + categoryId + "'");
	}

	private void deletePurchases(String condition) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "delete from customers_vs_coupons " + condition;
			PreparedStatement pstmt = con.prepareStatement(sql);
			int rowCount = pstmt.executeUpdate();

			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponSuccess("Purchase deleted");
		} catch (SQLException e) {
			throw new CouponRTException("delete record failed", e);
		}
	}

	/**
	 * function delete coupon purchases by coupon id.
	 */
	@Override
	public void deletePurchasesByCouponId(int couponID) throws CouponRTException, CouponSuccess {
		deletePurchases("WHERE coupon_id='" + couponID + "'");
	}

	@Override
	public void deletePurchasesByCustomerId(int couponID) throws CouponRTException, CouponSuccess {
		deletePurchases("WHERE coupon_id='" + couponID + "'");
	}

	@Override
	public void deleteCouponPurchase(int customerID, int couponID) throws CouponRTException, CouponSuccess {
		deletePurchases("WHERE coupon_id='" + couponID + "' AND customer_id='" + customerID + "'");
	}

	@Override
	public boolean isCompanyCouponExistsByTitle(int companyId, String couponTitle)
			throws CouponRTException, CouponSuccess {
		ArrayList<Coupon> coupons = getCoupons("WHERE company_i='" + companyId + "' AND title='" + couponTitle + "'");

		return coupons.isEmpty();
	}

	private ArrayList<CouponPurchase> getAllPurchases(String condition) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from customers_vs_coupons " + condition;

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<CouponPurchase> list = new ArrayList<>();
			while (rs.next()) {
				CouponPurchase purchase = new CouponPurchase();
				purchase.setCouponId(rs.getInt("coupon_id"));
				purchase.setCustomerId(rs.getInt("customer_id"));
				list.add(purchase);
			}
			ConnectionPool.getInstance().restoreConnection(con);
			return list;
		} catch (SQLException e) {
			throw new CouponRTException("get all purchases failed ", e);
		}
	}

	@Override
	public boolean isCouponAlreadyPurchased(int customerId, int couponId) throws CouponRTException, CouponSuccess {
		ArrayList<CouponPurchase> list = getAllPurchases(
				" WHERE customer_id='" + customerId + "' AND coupon_id='" + couponId + "'");

		if (list.isEmpty())
			return false;
		return true;
	}

	@Override
	public ArrayList<Coupon> getAllCustomerCoupons(int customerId) throws CouponRTException, CouponSuccess {
		ArrayList<CouponPurchase> list = getAllPurchases(" WHERE customer_id='" + customerId + "'");
		ArrayList<Coupon> customerCoupons = new ArrayList<>();
		for (CouponPurchase couponPurchase : list) {
			customerCoupons.add(getOneCoupon(couponPurchase.getCouponId()));
		}
		return customerCoupons;
	}

	@Override
	public ArrayList<Coupon> getExpierdCoupons() throws CouponRTException, CouponSuccess {
		return getCoupons(" WHERE end_date > CURRENT_DATE()");
	}

}
