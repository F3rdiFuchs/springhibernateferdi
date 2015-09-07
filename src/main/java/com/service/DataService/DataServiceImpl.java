package com.service.DataService;

import com.model.Data.Data;
import com.model.Data.DataDAO;

public class DataServiceImpl implements DataService{
	private DataDAO dataDAO;
	
	public DataDAO getDataDAO() {
		return dataDAO;
	}

	public void setDataDAO(DataDAO dataDAO) {
		this.dataDAO = dataDAO;
	}

	public void addData(Data data) {
		this.dataDAO.addData(data);
	}
}
