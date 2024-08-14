package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.StandardReportDaoInterface;
import com.account.serviceInterface.StandardReportServiceInterface;
import com.admin.model.AdminRegistrationModel;
@Service
public class StandardReportServiceC implements StandardReportServiceInterface{

	@Autowired
	private StandardReportDaoInterface standardReportDaoInterface;

	
	public StandardReportDaoInterface getStandardReportDaoInterface() {
		return standardReportDaoInterface;
	}


	public void setStandardReportDaoInterface(StandardReportDaoInterface standardReportDaoInterface) {
		this.standardReportDaoInterface = standardReportDaoInterface;
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.GetStreamList();
	}


	@Transactional
	@Override
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> GetStamdardList(int branchid) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getStandardList(branchid);
	}

	@Transactional
	@Override
	public List<String> getStandardWiseList(int yearId,int streamid,int branchid,int standardID) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.GetStandardWiseList(yearId,streamid,branchid,standardID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.checkAdmin(username);
	}

	@Transactional
	@Override
	public List<String> getRefundAmtDetailList() {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getRefundAmtDetailList();
	}


	@Transactional
	@Override
	public HashMap<String, String> getYearListFee() {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getYearListFee();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamListFee() {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getStreamListFee();
	}


	@Transactional
	@Override
	public List<String> getBranchListFee(int id) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getBranchListFee(id);
	}


	@Transactional
	@Override
	public List<String> getStandardListFee(int branchid) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getStandardListFee(branchid);
	}


	@Transactional
	@Override
	public List<String> getPendingFee(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getPendingFee( yearId,  streamid,  branchid,  standardID);
	}

	@Transactional
	@Override
	public List<String> getCompletedFee(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getCompletedFee( yearId,  streamid,  branchid,  standardID) ;
	}

	@Transactional
	@Override
	public List<String> getStudentTransactionReport(String studentName) {
		// TODO Auto-generated method stub
		return standardReportDaoInterface.getStudentTransactionReport(studentName);
	}

	
}
