package com.student.serviceInterface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

public interface DownloadServiceInterface {

	List<StudentRegistrationModel> getStudInfo(String username);

	List<String> GetDetailInfo(String studName, String studCon);

	List<String> GetStudDetails(String username);

	List<StudentAdmissionModel> getRequestStudInfo(String studName, String studCon, String studEmail);

	int getStudFlag(int studID);

	void UpdateBonafideFlag(int studID);

	int getDownLoadValue(int studID);

	List<String> getStudDetails(String studName, String studCon);

	int checkIDFlag(int studID);

	void updateIDCardFlag(int studentID);

	int checkLeavingCertificateFlag(int studID);

	List<String> GetStudentDetails(String studName, String studCon);

	void updateLeavingCertificateFlag(int studentID);

}
