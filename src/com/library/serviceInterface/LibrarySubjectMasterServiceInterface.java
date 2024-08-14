package com.library.serviceInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.LibrarySubjectMaster;

public interface LibrarySubjectMasterServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<LibrarySubjectMaster> librarySubjectSimpleList();

	void librarySubjectSave(LibrarySubjectMaster lsm);

	void updateLibraryData(int id, String subject);

	void deleteLibraryData(int id);

}
