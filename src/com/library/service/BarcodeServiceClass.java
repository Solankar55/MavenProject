package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BarcodeDaoInterface;
import com.library.model.Barcodemodel;
import com.library.serviceInterface.BarcodeServiceInterface;

@Service
@Transactional
public class BarcodeServiceClass implements BarcodeServiceInterface{

	@Autowired
	private BarcodeDaoInterface barcodeDaoInterface;

	public BarcodeDaoInterface getBarcodeDaoInterface() {
		return barcodeDaoInterface;
	}

	public void setBarcodeDaoInterface(BarcodeDaoInterface barcodeDaoInterface) {
		this.barcodeDaoInterface = barcodeDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return barcodeDaoInterface.checkAdmin(username);
	}

	@Override
	public List<String> getBarcodedBookList(String bookFor) {
		// TODO Auto-generated method stub
		return barcodeDaoInterface.getBarcodedBookList( bookFor);
	}

	@Override
	public HashMap<Integer, String> getAccessionId(String bookfor, String inDate) {
		// TODO Auto-generated method stub
		return barcodeDaoInterface.getAccessionId(bookfor,inDate);
	}

	@Override
	public void saveBarcode(Barcodemodel barcodemodel) {
		// TODO Auto-generated method stub
		barcodeDaoInterface.saveBarcode(barcodemodel);
	}
	
	
}
