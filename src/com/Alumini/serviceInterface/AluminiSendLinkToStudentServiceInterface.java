package com.Alumini.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

public interface AluminiSendLinkToStudentServiceInterface {

	List<StudentAdmissionModel> getStudentInfo(String mailID);

	List<StaffRegistrationModel> getStaffList(String username);

	HashMap<String, String> GetYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardList(int branchid);

	List<String> getStudentDetailsForAdmission(int yearId, int streamid, int branchid, int standardID);

	List<StudentAdmissionModel> getStudentMail(int boxValue);


}
