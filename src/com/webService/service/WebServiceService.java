package com.webService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webService.daoInterface.WebServiceDaoInterface;
import com.webService.serviceinterface.WebServiceServiceInterface;

@Service
public class WebServiceService implements WebServiceServiceInterface{

	@Autowired
	private WebServiceDaoInterface webServiceDaoInterface;

	public WebServiceDaoInterface getWebServiceDaoInterface() {
		return webServiceDaoInterface;
	}

	public void setWebServiceDaoInterface(WebServiceDaoInterface webServiceDaoInterface) {
		this.webServiceDaoInterface = webServiceDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getYearList() {
		// TODO Auto-generated method stub
		return webServiceDaoInterface.getYearList();
	}

	@Transactional
	@Override
	public List<String> getStreamList() {
		// TODO Auto-generated method stub
		return webServiceDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int streamID) {
		// TODO Auto-generated method stub
		return webServiceDaoInterface.getBranchList(streamID);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int branchID) {
		// TODO Auto-generated method stub
		return webServiceDaoInterface.getStandardList(branchID);
	}

	@Transactional
	@Override
	public List<String> getStudentList(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		return webServiceDaoInterface.getStudentList( yearID,  streamID,  branchID,  standardID);
	}

	@Transactional
	@Override
	public List<String> getUserAuthenticationCheck(String userName, String passWord) {
		// TODO Auto-generated method stub
		return webServiceDaoInterface.getUserAutheticationCheck(userName,passWord);
	}

	
	
}
