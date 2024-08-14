package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.ApprovedLeavingCertificateDaoInterface;
import com.account.serviceInterface.ApprovedLeavingCertificateServiceInterface;
@Service
public class ApprovedLeavingCertificateServiceC implements ApprovedLeavingCertificateServiceInterface {
	
	@Autowired
	private ApprovedLeavingCertificateDaoInterface approvedLeavingCertificateDaoInterface;

	public ApprovedLeavingCertificateDaoInterface getApprovedLeavingCertificateDaoInterface() {
		return approvedLeavingCertificateDaoInterface;
	}

	public void setApprovedLeavingCertificateDaoInterface(
			ApprovedLeavingCertificateDaoInterface approvedLeavingCertificateDaoInterface) {
		this.approvedLeavingCertificateDaoInterface = approvedLeavingCertificateDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getApprovedLeavingList() {
		// TODO Auto-generated method stub
		return approvedLeavingCertificateDaoInterface.approvedLeavingCertificateList();
	}
	
	

}
