package com.account.ServiceClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.account.daoInterface.ArtReportDaoInterface;
import com.account.serviceInterface.ArtReportServiceInterface;
@Service
public class ArtReportServiceC implements ArtReportServiceInterface{

	@Autowired
	private ArtReportDaoInterface artReportDaoInterface;

	public ArtReportDaoInterface getArtReportDaoInterface() {
		return artReportDaoInterface;
	}

	public void setArtReportDaoInterface(ArtReportDaoInterface artReportDaoInterface) {
		this.artReportDaoInterface = artReportDaoInterface;
	}

	
}
