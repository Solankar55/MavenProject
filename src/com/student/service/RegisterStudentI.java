package com.student.service;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

public interface RegisterStudentI {

	void RegisterStudent(StudentRegistrationModel studentRegistrationModel);

	List<String> GetStudentDetails(String uN, String pS);

	List<StudentRegistrationModel> GetDetailsForEdit(String username);

	List<String> GetStudDetails(String username);

	List<String> getStudentList(String studentName, String studContact);

	List<String> getUserNameList(String userNameValue, String studEmail, String studContact);

	List<String> getStudentDetailInfo(String studentName, String studentContact, String studentEmail);

	List<StudentRegistrationModel> CheckStudent(String username);

	List<StudentRegistrationModel> getStudDetails(String uN, String pS);

	List<StudentAdmissionModel> getStudentStatus(String sName, String sMail, String sContact);

	List<StudentRegistrationModel> getStudDetailsHome(String username);


}
