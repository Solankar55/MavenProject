package com.TAP.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.StaffRegistrationModel;
import com.TAP.model.StudentRegistrationTAPModel;
import com.student.model.StudentAdmissionModel;

public interface StudentLinkDaoInterface {

	HashMap<String, String> GetYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardList(int branchid);

	List<String> getStudentDetailsForAdmission(int yearId, int streamid, int branchid, int standardID);

	int getTAPID();

	void saveStudentRegistrationTAPDetails(StudentRegistrationTAPModel studentRegistrationTAPModel);

	List<StudentAdmissionModel> getStudentMail(int boxValue);

	List<StaffRegistrationModel> getStaffList(String username);


}
