package com.library.serviceInterface;

import java.util.List;

import com.library.model.LostBookStaff;

public interface BookLostStaffServiceInterface {

	List<String> getLostStaffBookList();

	List<Object[]> activeYR();

	List checkStaffRegistrationIdAvailability(int staffId);

	void SaveToDatabase(LostBookStaff lostBookStaff);

	void updateBookCollegeRemark(int accessionLibraryRegisterId);

	int getAccessionLibraryRegisterId(String bookId, String bookFor);

}
