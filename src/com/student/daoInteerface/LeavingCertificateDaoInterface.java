package com.student.daoInteerface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;

public interface LeavingCertificateDaoInterface {

	List<String> GetStudentDetails(String studName, String studCon, String studEmail);

	List<StudentRegistrationModel> GetStudentInfo(String username);

	void SaveLeavingCertificateRequest(StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel);

	List<String> GetStudDetails(String username);

	int getLCNumber();

	List<StudentAdmissionModel> getStudID(String studName, String studCon, String studEmailAddress);

	List<String> getCheckStudPresentOrNot(int studentRequestID);

}
