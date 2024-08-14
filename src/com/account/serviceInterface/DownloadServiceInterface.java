package com.account.serviceInterface;

import java.util.List;

import com.account.model.DuplicateLeavingCertificateModel;
import com.account.model.LedgerFeePaidModel;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;

public interface DownloadServiceInterface {

	List<String> getStudentDetails(int registrationID);

	void UpdateBonafideFlag(int studID);

	List<String> getStudentIDDetails(int registrationID);

	void updateIDCardFlag(int studentID);

	List<String> getSTudentLCDetails(int registrationID);

	void updateLeavingCertificateFlag(int studentID);

	List<AdminRegistrationModel> CheckAdmin(String username);

	List<String> getStudentDetailsForDuplicateLC(int registrationID);

	void saveDuplicateLcDetails(DuplicateLeavingCertificateModel duplicateLeavingCertificateModel);

	List<String> getStudentDetailsAnyConditionLC(String studentName);

	List<String> getStudentDetailsTogetLC(int studentId);

	List<LedgerFeePaidModel> getStudentDetailsAnyFeeCondition(int studentId);

	void saveLeavingCertificate(StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel);

	List<StudentAdmissionModel> getStudentStatus(int studentId);

	List<String> getStudentDetailsAnyConditionBonafide(int studentId);

	void saveStudentBonfideAnycondition(StudentBonafideRequestModel studentBonafideRequestModel);

	void UpdateBonafideFlagAnyCondition(int studentId);

	List<String> getStudentDataIDAnyCondition(int studentId);

	void saveStudentIdAnyConditionDetails(StudentIDCardRequestModel studentIDCardRequestModel);

}
