package com.service.CarService;

import java.util.List;

import com.model.CompanyCar.CompanyCar;
import com.model.CompanyCar.CompanyCarDAO;

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
