package com.account.daoInterface;

import java.util.List;

import com.account.model.TransportMasterModel;
import com.admin.model.AdminRegistrationModel;

public interface MasterTransportDaoInterface {

	void TransportMgmt(TransportMasterModel transportMasterModel);

	List<TransportMasterModel> fetchMasterTransport();

	void UpdateTransportCharges(int transID, String transCharge);

	void DeleteTransport(int transID);

	List<AdminRegistrationModel> checkAdmin(String username);

}
