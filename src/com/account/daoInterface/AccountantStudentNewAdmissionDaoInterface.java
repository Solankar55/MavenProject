package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentRegistrationModel;

public interface AccountantStudentNewAdmissionDaoInterface {

	int getStudentID();

	HashMap<String, String> getYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardList(int id);

	void SaveStudentAdmission(StudentAdmissionModel studentAdmissionModel);

	List<acadamicYearModel> getStudentAcyear(int yearID);

	List<StandardMasterModel> getStudentStandard(int standardId);

	void saveRegisterDetails(StudentRegistrationModel studentRegistrationModel);

	void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster);

	List<String> getStudentCheckId(int studentId);

}
