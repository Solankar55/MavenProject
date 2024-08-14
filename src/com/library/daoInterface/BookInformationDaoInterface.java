package com.library.daoInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface BookInformationDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> searchSubject(String parameter);

	List<String> searchTitle(String parameter);

	List<String> searchAuthor(String parameter);

	List<String> getSubjectWiseList(String subjectName);

	List<String> getTitleWiseList(String titleName);

	List<String> getAuthorWiseList(String authorName);

	List<String> getBookSubTitleInfo(String subName, String titleName, String authorName);

	List<String> getBookSubAuthorInfo(String subName, String titleName, String authorName);

	List<String> getBookList(String subName, String titleName, String authorName);

	List<String> getBookTitleAuthorList(String subName, String titleName, String authorName);

}
