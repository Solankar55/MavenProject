package com.library.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.Barcodemodel;

public interface BarcodeServiceInterface {

	List<AdminRegistrationModel> CheckAdmin(String username);

	List<String> getBarcodedBookList(String bookFor);

	HashMap<Integer, String> getAccessionId(String bookfor, String inDate);

	void saveBarcode(Barcodemodel barcodemodel);

}
