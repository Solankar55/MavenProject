package com.library.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.AccessionLibraryRegisterDaoInterface;
import com.library.model.QuantityDataMaster;
import com.library.serviceInterface.AccessionLibraryRegisterServiceInterface;

@Service
@Transactional
public class AccessionLibraryRegisterServiceClass implements AccessionLibraryRegisterServiceInterface {

	@Autowired
	private AccessionLibraryRegisterDaoInterface accessionLibraryRegisterDaoInterface;

	public AccessionLibraryRegisterDaoInterface getAccessionLibraryRegisterDaoInterface() {
		return accessionLibraryRegisterDaoInterface;
	}

	public void setAccessionLibraryRegisterDaoInterface(
			AccessionLibraryRegisterDaoInterface accessionLibraryRegisterDaoInterface) {
		this.accessionLibraryRegisterDaoInterface = accessionLibraryRegisterDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return accessionLibraryRegisterDaoInterface.checkAdmin(username);
	}

	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return accessionLibraryRegisterDaoInterface.getYearList();
	}

	@Override
	public HashMap<String, String> librarySubjectList() {
		// TODO Auto-generated method stub
		return accessionLibraryRegisterDaoInterface.librarySubjectList();
	}

	@Override
	public HashMap<String, String> BookTypeList() {
		// TODO Auto-generated method stub
		return accessionLibraryRegisterDaoInterface.bookTypeList();
	}

	@Override
	public HashMap getvendorName() {
		// TODO Auto-generated method stub
		return accessionLibraryRegisterDaoInterface.getVendorName();
	}

	@Override
	public List<String> vendorDis(String id) {
		// TODO Auto-generated method stub
		return accessionLibraryRegisterDaoInterface.venderDis(id);
	}

	@Override
	public void purchaseBook(QuantityDataMaster quantityDataMaster, HttpServletRequest req) {
		// TODO Auto-generated method stub
		accessionLibraryRegisterDaoInterface.purchaseBook(quantityDataMaster, req);
	}

	@Override
	public List<String> getpurchaseBookList() {
		// TODO Auto-generated method stub
		return accessionLibraryRegisterDaoInterface.getpurchaseBookList();
	}

	@Override
	public void updateBook(QuantityDataMaster quantityDataMaster, HttpServletRequest req) {
		// TODO Auto-generated method stub
		accessionLibraryRegisterDaoInterface.updateBook(quantityDataMaster, req);
	}

}
