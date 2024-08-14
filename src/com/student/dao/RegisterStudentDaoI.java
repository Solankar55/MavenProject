package com.student.dao;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

public interface RegisterStudentDaoI {

	void RegisterStudent(StudentRegistrationModel studentRegistrationModel);

	List<String> GetStudentList(String uN, String pS);

	List<StudentRegistrationModel> getStudDetailsForEdit(String username);

	List<String> getStudInfo(String username);

	List<String> getStudUserDetails(String studentName,String studContact);

	List<String> getUserNameList(String userNameValue, String studEmail, String studContact);

	List<String> getStudentDetailsInfo(String studentName, String studentContact, String studentEmail);

	List<StudentRegistrationModel> checkStudent(String username);

	List<StudentRegistrationModel> getStudDetails(String uN, String pS);

	List<StudentAdmissionModel> getStudentStatus(String sName, String sMail, String sContact);

	List<StudentRegistrationModel> getStudDetailsHome(String username);

}
