package com.library.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface BookIssueReturnServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	HashMap<String, String> getMessageSt(String bookId);

	List<String> getBookBarcodeInfo(String bookBarcode);

	List<String> getStudentBarcodeInfo(String studentBarcode);

	List<String> getStaffDetails(String staffBarcode);

	String getActiveyr();

	int getalrIdforPG(String bookId);

	List<String> GetbookIssure(int alrID, int studentId, String readerId, String bookId);

	String getDetails(int alrID, int studentId, String readerId, String bookId);

	int getalrIdforDegree(String bookId);

	int getalrIdforDiploma(String bookId);

	int getalrIdforOther(String bookId);

	void issueBookToLecturerPostDegree(int alrID, String readerId, String bookId, int staffID);

	String getDetailsStaff(int alrID, int staffID, String readerId, String bookId);

	void issueBookToLecturerDegree(int alrID, String readerId, String bookId, int staffID);

}
