package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.StudentStnadardFeeDaoInterface;
import com.account.model.StandardFeeMasterModel;
import com.account.serviceInterface.StudentStandardFeeServiceInterface;
@Service
public class StudentStandardFeeServiceC implements StudentStandardFeeServiceInterface {

	@Autowired
	private StudentStnadardFeeDaoInterface studentStnadardFeeDaoInterface;

	public StudentStnadardFeeDaoInterface getStudentStnadardFeeDaoInterface() {
		return studentStnadardFeeDaoInterface;
	}

	public void setStudentStnadardFeeDaoInterface(StudentStnadardFeeDaoInterface studentStnadardFeeDaoInterface) {
		this.studentStnadardFeeDaoInterface = studentStnadardFeeDaoInterface;
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return studentStnadardFeeDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return studentStnadardFeeDaoInterface.GetStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub

		return studentStnadardFeeDaoInterface.GetBranch(id);
	}

	@Transactional
	@Override
	public List<String> GetStamdardList(int branchID) {
		// TODO Auto-generated method stub
		return studentStnadardFeeDaoInterface.GetStandardList(branchID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetLedgerList() {
		// TODO Auto-generated method stub
		return studentStnadardFeeDaoInterface.GetLedgereList();
	}

	@Transactional
	@Override
	public List<String> GetSubLedgerList(int ledgerId) {
		// TODO Auto-generated method stub
		return studentStnadardFeeDaoInterface.GetSubLedgerList(ledgerId);
	}

	@Transactional
	@Override
	public void SaveFee(StandardFeeMasterModel standardFeeMasterModel) {
		// TODO Auto-generated method stub
		studentStnadardFeeDaoInterface.SaveFeeTODB(standardFeeMasterModel);
	}

	@Transactional
	@Override
	public List<String> GetLegderFeeList() {
		// TODO Auto-generated method stub
		return studentStnadardFeeDaoInterface.GetLedgerFeeList();
	}

	@Transactional
	@Override
	public void UpdateStandardFee(int ledgerID, float standardFee,int SubLedgerId,int stdFeeId) {
		// TODO Auto-generated method stub
		studentStnadardFeeDaoInterface.UpdateStandardFee(ledgerID,standardFee,SubLedgerId,stdFeeId);
	}

	@Transactional
	@Override
	public void DeleteStandardFee(int stdFeeId) {
		// TODO Auto-generated method stub
		studentStnadardFeeDaoInterface.DeleteStandardFeeD(stdFeeId);
	}

	@Transactional
	@Override
	public List<String> getStandardLedger(int yearId, int streamid, int branchid, int standardID, int ledgername) {
		// TODO Auto-generated method stub
		return studentStnadardFeeDaoInterface.getStandardLedger( yearId, streamid,  branchid,  standardID,  ledgername);
	}



}
