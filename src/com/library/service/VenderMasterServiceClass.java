package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.VenderMasterDaoInterface;
import com.library.model.VendorMasterModel;
import com.library.serviceInterface.VenderMasterServiceInterface;

@Service
@Transactional
public class VenderMasterServiceClass implements VenderMasterServiceInterface{

	@Autowired
	private VenderMasterDaoInterface venderMasterDaoInterface;

	public VenderMasterDaoInterface getVenderMasterDaoInterface() {
		return venderMasterDaoInterface;
	}

	public void setVenderMasterDaoInterface(VenderMasterDaoInterface venderMasterDaoInterface) {
		this.venderMasterDaoInterface = venderMasterDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return venderMasterDaoInterface.checkAdmin( username);
	}

	@Override
	public List<String> getVenderList() {
		// TODO Auto-generated method stub
		return venderMasterDaoInterface.getVenderList();
	}

	@Override
	public void submitVendor(VendorMasterModel vendorMasterModel) {
		// TODO Auto-generated method stub
		venderMasterDaoInterface.submitVendor( vendorMasterModel);
	}

	@Override
	public void updateVendor(VendorMasterModel vendorMasterModel) {
		// TODO Auto-generated method stub
		venderMasterDaoInterface.updateVendor(vendorMasterModel);
	}

	@Override
	public void deleteVendor(int id) {
		// TODO Auto-generated method stub
		venderMasterDaoInterface.deleteVendor( id);
	}
	
	
}
