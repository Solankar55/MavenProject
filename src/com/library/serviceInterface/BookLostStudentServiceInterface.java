package com.library.serviceInterface;

import java.util.List;

import com.library.model.LostBookStudent;

public interface BookLostStudentServiceInterface {

	public void LostBookDataSave(String BookFor, String StudentName, int BookId, int StudentId);

	public List<Object[]> getActiveyr();

	public void SaveToDatabase(LostBookStudent lostBookStudent);

	public int getAccessionLibraryRegisterId(String bookId, String bookFor);

	public List checkStudentRegistrationIdAvailability(int studentRegId);

	public void updateBookCollegeRemark(int accessionLibraryRegisterId);

	public List<String> getBookLostList();

}
