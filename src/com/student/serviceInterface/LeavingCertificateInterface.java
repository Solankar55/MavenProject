package com.student.serviceInterface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;

public interface LeavingCertificateInterface {

	List<String> GetStudentDetails(String studName, String studCon, String studEmail);

	List<StudentRegistrationModel> getStudInfo(String username);

	void SaveLeavingCertificateRequest(StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel);

	List<String> GetStudDetails(String username);

	int GetLCNumber();

	List<StudentAdmissionModel> getStudID(String studName, String studCon, String studEmailAddress);

	List<String> getCheckIDAvailableOrNot(int studentRequestID);

}
