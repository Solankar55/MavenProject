package com.library.daoInterface;

import java.util.List;

import com.library.model.LostBookStaff;

public interface BookLostStaffDaoInterface {

	List<String> getLostStaffBookList();

	List<Object[]> activeYR();

	List checkStaffRegistrationIdAvailability(int staffId);

	void saveToDatabase(LostBookStaff lostBookStaff);

	void updateBookCollegeRemark(int accessionLibraryRegisterId);

	int getAccesssionLibraryRegisterId(String bookId, String bookFor);

}
