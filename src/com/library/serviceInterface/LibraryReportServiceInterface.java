package com.library.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface LibraryReportServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> getInvoice(int invoiceno);

	HashMap<String, String> librarySubjectList();

	HashMap<String, String> getYearList();

	List<String> getBookBankData();

	HashMap<String, String> bookTypeList();

	HashMap getvendorName();

	HashMap getacademicYearList();

	HashMap getBookType();

	List getPublicationList();

	List getTitleList();

	List getAuthorList();

	List<String> getStaffIssueReturnData();

	List<String> getStudentIssueReturnData();

}
