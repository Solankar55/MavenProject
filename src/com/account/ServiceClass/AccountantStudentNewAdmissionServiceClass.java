package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.AccountantStudentNewAdmissionDaoInterface;
import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.account.serviceInterface.AccountantStudentNewAdmissionServiceInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentRegistrationModel;

@Service
public class AccountantStudentNewAdmissionServiceClass implements AccountantStudentNewAdmissionServiceInterface{

	@Autowired
	private AccountantStudentNewAdmissionDaoInterface accountantStudentNewAdmissionDaoInterface;

	public AccountantStudentNewAdmissionDaoInterface getAccountantStudentNewAdmissionDaoInterface() {
		return accountantStudentNewAdmissionDaoInterface;
	}

	public void setAccountantStudentNewAdmissionDaoInterface(
			AccountantStudentNewAdmissionDaoInterface accountantStudentNewAdmissionDaoInterface) {
		this.accountantStudentNewAdmissionDaoInterface = accountantStudentNewAdmissionDaoInterface;
	}

	@Transactional
	@Override
	public int getStudentID() {
		// TODO Auto-generated method stub
		return accountantStudentNewAdmissionDaoInterface.getStudentID();
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return accountantStudentNewAdmissionDaoInterface.getYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> SetStream() {
		// TODO Auto-generated method stub
		return accountantStudentNewAdmissionDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		return accountantStudentNewAdmissionDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int id) {
		// TODO Auto-generated method stub
		return accountantStudentNewAdmissionDaoInterface.getStandardList(id);
	}

	@Transactional
	@Override
	public void saveAdmission(StudentAdmissionModel studentAdmissionModel) {
		// TODO Auto-generated method stub
		accountantStudentNewAdmissionDaoInterface.SaveStudentAdmission(studentAdmissionModel);
	}

	@Transactional
	@Override
	public List<acadamicYearModel> getStudentACYear(int yearID) {
		// TODO Auto-generated method stub
		return accountantStudentNewAdmissionDaoInterface.getStudentAcyear(yearID);
	}

	@Transactional
	@Override
	public List<StandardMasterModel> getStudentStandard(int standardId) {
		// TODO Auto-generated method stub
		return accountantStudentNewAdmissionDaoInterface.getStudentStandard(standardId);
	}

	@Transactional
	@Override
	public void saveRegisterDetails(StudentRegistrationModel studentRegistrationModel) {
		// TODO Auto-generated method stub
		accountantStudentNewAdmissionDaoInterface.saveRegisterDetails(studentRegistrationModel);
	}

	@Transactional
	@Override
	public void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster) {
		// TODO Auto-generated method stub
		accountantStudentNewAdmissionDaoInterface.saveBracodeMaster( studentBarcodeMaster);
	}

	@Transactional
	public List<String> getStudentCheckId(int studentId) {
		// TODO Auto-generated method stub
		return accountantStudentNewAdmissionDaoInterface.getStudentCheckId(studentId);
	}
	
	
}
