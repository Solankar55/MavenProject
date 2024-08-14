package com.HOD.daoInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface StaffInformationEditDaoInterface {

	List<String> getStaffInfo();

	void updateStaffInfo(int staffId, String staffName, String staffMb, String staffEmail, String staffQ, String staffD,
			String staffT, String barcode, String staffAdd, String staffExp);

	void deleteStaffInfo(int staffId);

	List<AdminRegistrationModel> CheckAdmin(String username);

}
