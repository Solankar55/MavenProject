package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.AccountantNextYearStudentAdmissionDaoInterface;
import com.account.model.LedgerFeePaidModel;
import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.account.serviceInterface.AccountantNextYearStudentAdmissionServiceInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;

@Service
public class AccountantNextYearStudentAdmissionServiceClass implements AccountantNextYearStudentAdmissionServiceInterface{

	@Autowired
	private AccountantNextYearStudentAdmissionDaoInterface accountantNextYearStudentAdmissionDaoInterface;

	public AccountantNextYearStudentAdmissionDaoInterface getAccountantNextYearStudentAdmissionDaoInterface() {
		return accountantNextYearStudentAdmissionDaoInterface;
	}

	public void setAccountantNextYearStudentAdmissionDaoInterface(
			AccountantNextYearStudentAdmissionDaoInterface accountantNextYearStudentAdmissionDaoInterface) {
		this.accountantNextYearStudentAdmissionDaoInterface = accountantNextYearStudentAdmissionDaoInterface;
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.GetStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStandardList(branchid);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsForAdmission(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStudentDetailsListForAdmission(yearId,streamid,branchid,standardID);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsForNextYear(int academicYearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStudentDetailsForNextYearAdmission(academicYearID,streamID,branchID,standardID);
	}

	@Transactional
	@Override
	public int getStudentCount(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStudentCountToTransferAdmission(yearID,streamID,branchID,standardID);
	}

	@Transactional
	@Override
	public List<acadamicYearModel> getStudentACYear(int yearID) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStudentACYear(yearID);
	}

	@Transactional
	@Override
	public List<StandardMasterModel> getStudentStandard(int standardId) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStudentStandard(standardId);
	}

	@Transactional
	@Override
	public void transferStrudentToNextYear(int rergId, int branchID, int streamID, int acadamicYearID, int standardID,
			String studentBarcode) {
		// TODO Auto-generated method stub
		accountantNextYearStudentAdmissionDaoInterface.transferStrudentToNextYear( rergId,  branchID,  streamID,  acadamicYearID,  standardID,
				 studentBarcode);
	}

	/*Student next Admssion process*/
	@Transactional
	@Override
	public Integer getStudentInfo(int studentId) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStudentInfo(studentId);
	}

	@Transactional
	@Override
	public List<acadamicYearModel> getActiveYear() {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getActiveYear();
	}

	@Transactional
	@Override
	public List<LedgerFeePaidModel> getFeeDetails(int studentId) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getFeeDetails(studentId);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailInfo(int studentId) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStudentDetailInfo(studentId);
	}

	@Transactional
	@Override
	public void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster) {
		// TODO Auto-generated method stub
		accountantNextYearStudentAdmissionDaoInterface.saveBracodeMaster( studentBarcodeMaster);
	}

	@Transactional
	@Override
	public void saveAdmission(StudentAdmissionModel studentAdmissionModel) {
		// TODO Auto-generated method stub
		accountantNextYearStudentAdmissionDaoInterface.saveAdmission( studentAdmissionModel);
	}

	@Transactional
	@Override
	public Integer getStudentId(int registrationID) {
		// TODO Auto-generated method stub
		return accountantNextYearStudentAdmissionDaoInterface.getStudentId( registrationID);
	}
	
	
}
