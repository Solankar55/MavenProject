package com.student.serviceInterface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentRegistrationModel;

public interface IDCardServiceInterface {

	List<StudentRegistrationModel> getStudInfo(String username);

	List<String> getStudDetails(String studName, String studCon, String studEmail);

	void SaveIDCardRequest(StudentIDCardRequestModel studentIDCardRequestModel);

	List<String> GetStudDetails(String username);

	List<StudentAdmissionModel> getStudentID(String studName, String studCon, String studEmail);

	List<String> getIdRequestCheck(int studID);

}
