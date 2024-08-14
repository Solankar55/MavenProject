package com.library.serviceInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.LibraryAcademicYearModel;

public interface AcademicMasterLibraryServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> getYearList();

	void saveLabAcademicMaster(LibraryAcademicYearModel libraryAcademicYearModel);

	void updateYearOfLibrary(int yearId, String yearLab);

	void deleteYearOfLibrary(int yearId);

}
