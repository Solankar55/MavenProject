package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.LedgerFeePaidModel;
import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;

public interface AccountantNextYearStudentAdmissionDaoInterface {

	HashMap<String, String> GetYearList();

	HashMap<String, String> GetStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardList(int branchid);

	List<String> getStudentDetailsListForAdmission(int yearId, int streamid, int branchid, int standardID);

	List<String> getStudentDetailsForNextYearAdmission(int academicYearID, int streamID, int branchID, int standardID);

	int getStudentCountToTransferAdmission(int yearID, int streamID, int branchID, int standardID);

	List<acadamicYearModel> getStudentACYear(int yearID);

	List<StandardMasterModel> getStudentStandard(int standardId);

	void transferStrudentToNextYear(int rergId, int branchID, int streamID, int acadamicYearID, int standardID,
			String studentBarcode);
	
	/*Student Next Year admission Process*/

	Integer getStudentInfo(int studentId);

	List<acadamicYearModel> getActiveYear();

	List<LedgerFeePaidModel> getFeeDetails(int studentId);

	List<String> getStudentDetailInfo(int studentId);

	void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster);

	void saveAdmission(StudentAdmissionModel studentAdmissionModel);

	Integer getStudentId(int registrationID);

}
