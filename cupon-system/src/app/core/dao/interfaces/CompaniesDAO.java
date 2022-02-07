package app.core.dao.interfaces;

import java.util.ArrayList;

import app.core.beans.Company;

public interface CompaniesDAO {
	public boolean isCompanyExists(String email, String password) throws Exception;

	public void addCompany(Company company) throws Exception;

	public void updateCompany(Company company) throws Exception;

	public void deleteCompany(int companyID) throws Exception;

	public ArrayList<Company> getAllCompanies() throws Exception;

	public Company getCompanyById(int companyID) throws Exception;

	public Company getCompanyByName(String companyName) throws Exception;

	public Company getCompanyByEmail(String companyEmail) throws Exception;

	public Company getCompanyByEmailOrName(String companyEmail, String companyName) throws Exception;
}
