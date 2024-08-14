package com.account.ServiceClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.account.daoInterface.CommerceReportDaoInterface;
import com.account.serviceInterface.CommerceReportServiceInterface;
@Service
public class CommerceReportServiceC implements CommerceReportServiceInterface{

	@Autowired
	private CommerceReportDaoInterface commerceReportDaoInterface;

	public CommerceReportDaoInterface getCommerceReportDaoInterface() {
		return commerceReportDaoInterface;
	}

	public void setCommerceReportDaoInterface(CommerceReportDaoInterface commerceReportDaoInterface) {
		this.commerceReportDaoInterface = commerceReportDaoInterface;
	}

	
}
