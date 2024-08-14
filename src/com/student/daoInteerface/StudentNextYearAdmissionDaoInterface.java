package com.student.daoInteerface;

import java.util.HashMap;
import java.util.List;

import com.account.model.LedgerFeePaidModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;

public interface StudentNextYearAdmissionDaoInterface {

	Integer getStudentInformation(int studentId);

	List<acadamicYearModel> getActiveYear();

	HashMap<String, String> GetYearList();

	HashMap<String, String> SetStream();

	List<String> getStudentDetailInfo(int studId);

	void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster);

	void saveAdmission(StudentAdmissionModel studentAdmissionModel);

	List<LedgerFeePaidModel> getFeeDetails(int studId);

}
