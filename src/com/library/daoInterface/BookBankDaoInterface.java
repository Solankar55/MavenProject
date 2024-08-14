package com.library.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface BookBankDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	HashMap<String, String> getMessageSt(String bookId);

	List<String> getStudentList(String studentId);

	List<String> getStudentBookBankList(String studbarcode);

	String getActiveyr();

	int getMaxAlrID();

	int getalrIdforPostDegree(String bookId);

	List<String> getbookIssure(int alrid, int alrID, int studentId, String readerId, String bookId);

	String getDetails(int alrID, int studentId, String readerId, String bookId);

	int getalrIdforDegree(String bookId);

	int getalrIdforDiploma(String bookId);

	int getalrIdforOther(String bookId);

}
