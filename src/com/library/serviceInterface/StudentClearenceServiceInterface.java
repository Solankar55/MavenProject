package com.library.serviceInterface;

import java.util.HashMap;
import java.util.List;

public interface StudentClearenceServiceInterface {

	HashMap<String, String> getAcadamicYear();

	String getYearbyID(String selectedYr);

	List<String> getFinedetailStud(String dateone, String datetwo, String studId);

	int gettotalfine(String dateone, String datetwo, String studId);

	List<String> getLostbookdetails(String studId);

	Double getLostTotal(String studId);

	List<String> getNotReturnDetails(String studId);

	Double getFineForNotReturn(String studId);

}
