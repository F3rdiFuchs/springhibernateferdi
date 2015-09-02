package com.service.GuarantorService;

import java.util.List;

import com.model.Guarantor.Guarantor;
import com.model.Guarantor.GuarantorDAO;

public class GuarantorServiceImpl implements GuarantorService{
	private GuarantorDAO guarantorDAO;
	
	public List<Guarantor> listGuarantor() {
		// TODO Auto-generated method stub
		return this.guarantorDAO.listGuarantor();
	}

	public GuarantorDAO getGuarantorDAO() {
		return guarantorDAO;
	}

	public void setGuarantorDAO(GuarantorDAO guarantorDAO) {
		this.guarantorDAO = guarantorDAO;
	}
}
