package com.library.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface LibraryReportDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> getInvoice(int invoiceno);

	List getAuthorList();

	List getTitleList();

	HashMap getBookType();

	HashMap getacademicYearList();

	HashMap getvendorName();

	HashMap<String, String> bookTypeList();

	List<String> getBookBankData();

	HashMap<String, String> getYearList();

	HashMap<String, String> librarySubjectList();

	List getPublicationList();

	List<String> getStaffIssueReturnData();

	List<String> getStudentIssueReturnData();

}
