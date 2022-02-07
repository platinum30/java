package app.core.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.core.beans.Company;
import app.core.dao.interfaces.CompaniesDAO;
import app.core.data.ConnectionPool;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;

public class CompaniesDBDAO implements CompaniesDAO {
	private CompaniesDBDAO() {

	}

	public static CompaniesDBDAO instance;

	public static CompaniesDBDAO getInstance() {
		if (instance == null) {
			instance = new CompaniesDBDAO();
		}
		return instance;
	}

	@Override
	public boolean isCompanyExists(String email, String password) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from companies where email = ? and password = ?";
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
			throw new CouponRTException("check if company exists failed", e);
		}
	}

	@Override
	public void addCompany(Company company) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "insert into companies values(0,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int companyID = rsId.getInt(1);
			company.setId(companyID);
			ConnectionPool.getInstance().restoreConnection(con);// return connection back to pool
			throw new CouponSuccess(company.getName() + " added successfully - company id is: " + companyID);
		} catch (SQLException e) {
			throw new CouponRTException("add company failed ", e);
		}

	}

	@Override
	public void updateCompany(Company company) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "update companies set name=?, email=?,password=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.setInt(4, company.getId());
			pstmt.executeUpdate();

			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponSuccess(company.getName() + " Updated successfully");
		} catch (SQLException e) {
			throw new CouponRTException("update company failed", e);
		}

	}

	@Override
	public void deleteCompany(int companyID) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "delete from companies where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, companyID);
			int rowCount = pstmt.executeUpdate();
			ConnectionPool.getInstance().restoreConnection(con);
			throw new CouponSuccess("Company deleted successfully");
		} catch (SQLException e) {
			throw new CouponRTException("delete company failed", e);
		}

	}

	@Override
	public ArrayList<Company> getAllCompanies() throws CouponRTException, CouponSuccess {

		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from companies";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Company> list = new ArrayList<Company>();
			while (rs.next()) {
				Company company = new Company();
				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));
				list.add(company);
			}
			ConnectionPool.getInstance().restoreConnection(con);
			return list;
		} catch (SQLException e) {
			throw new CouponRTException("get all companies failed ", e);
		}
	}

	/**
	 * function get condition (like - where id=1) and return Company object with all
	 * company details from the database. if company not found, function throws
	 * coupon exception
	 * ------------------------------------------------------------------------------
	 * i made this function in order to shorten the code and make code maintenance
	 * much more easy.
	 */

	private Company getOneCompany(String condition) throws CouponRTException, CouponSuccess {
		try {
			Connection con = ConnectionPool.getInstance().getConnection();
			String sql = "select * from companies " + condition;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ConnectionPool.getInstance().restoreConnection(con);
			if (rs.next()) {
				Company company = new Company();
				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));
				return company;
			}
			throw new CouponRTException("company not found");
		} catch (SQLException e) {
			throw new CouponRTException("get company failed", e);
		}

	}

	@Override
	public Company getCompanyById(int companyID) throws CouponRTException, CouponSuccess {
		return getOneCompany("WHERE id='" + companyID + "'");
	}

	/**
	 * function get company name and return company object with all info from DB
	 * 
	 * @param String companyName
	 * @throws CouponRTException
	 * @return Company
	 */
	@Override
	public Company getCompanyByName(String companyName) throws CouponRTException, CouponSuccess {
		return getOneCompany("WHERE name='" + companyName + "'");
	}

	/**
	 * function get company email and return company object with all info from DB
	 * 
	 * @param String companyEmail
	 * @throws CouponRTException
	 * @return Company
	 */
	@Override
	public Company getCompanyByEmail(String companyEmail) throws CouponRTException, CouponSuccess {
		return getOneCompany("WHERE email='" + companyEmail + "'");
	}

	/**
	 * function get company email and return company object with all info from DB
	 * 
	 * @param String companyEmail
	 * @throws CouponRTException
	 * @return Company
	 */
	@Override
	public Company getCompanyByEmailOrName(String companyEmail, String companyName)
			throws CouponRTException, CouponSuccess {
		return getOneCompany("WHERE email='" + companyEmail + "' OR name='" + companyName + "'");
	}

}
