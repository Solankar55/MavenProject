package com.student.daoInteerface;

import java.util.HashMap;
import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

public interface LibraryBooksRecordDaoInterface {

	HashMap<String, String> getBookSubList();

	HashMap<String, String> getBookTitleList();

	HashMap<String, String> getBookAuthourList();

	List<String> getBookInfo(String bookName);

	List<String> getBookSubInfo(String bookName, String bookfor);

	List<String> getBookAuthorInfo(String authorName);

	List<StudentRegistrationModel> getStudInfo(String username);

	List<String> getBookPublisherInfo(String bookName);

	List<StudentAdmissionModel> getStudAdmissionInfo(String studCon, String studEmail);

	List<String> getStudDetails(String username1);

}
