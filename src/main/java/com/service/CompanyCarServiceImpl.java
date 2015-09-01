package com.service;

import java.util.List;

import com.model.CompanyCar;
import com.model.CompanyCarDAO;

public class CompanyCarServiceImpl implements CompanyCarService{
	private CompanyCarDAO companyCarDAO;
	
	public List<CompanyCar> listCompanyCar() {
		return this.companyCarDAO.listCompanyCar();
	}

	public CompanyCarDAO getCompanyCarDAO() {
		return companyCarDAO;
	}

	public void setCompanyCarDAO(CompanyCarDAO companyCarDAO) {
		this.companyCarDAO = companyCarDAO;
	}
	

}
