package com.account.ServiceClass;

import java.util.List;

import javax.persistence.TableGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.ApproveLeavingDaoInterface;
import com.account.model.LedgerFeePaidModel;
import com.account.serviceInterface.ApproveLeavingServiceInterface;
@Service
public class ApproveLeavingServiceC implements ApproveLeavingServiceInterface{

	@Autowired
	private ApproveLeavingDaoInterface approveLeavingDaoInterface;

	public ApproveLeavingDaoInterface getApproveLeavingDaoInterface() {
		return approveLeavingDaoInterface;
	}

	public void setApproveLeavingDaoInterface(ApproveLeavingDaoInterface approveLeavingDaoInterface) {
		this.approveLeavingDaoInterface = approveLeavingDaoInterface;
	}

	@Transactional
	@Override
	public List<String> GetRequestLeaving() {
		// TODO Auto-generated method stub
		return approveLeavingDaoInterface.getLeavingList();
	}

	@Transactional
	@Override
	public void TakeLeavingRequest(int studID,String conduct, String dateOfLeaving, String reasonOfLeaving,String remark) {
		// TODO Auto-generated method stub
		approveLeavingDaoInterface.TakeLeaving(studID,conduct,  dateOfLeaving,  reasonOfLeaving, remark);
	}

	@Transactional
	@Override
	public void cancelLeaving(int studID) {
		// TODO Auto-generated method stub
		approveLeavingDaoInterface.cancelLeaving(studID);
	}

	@Transactional
	@Override
	public List<LedgerFeePaidModel> getStudentPendingFee(int yearID1, int standardID1, int streamID1, int branchID1,
			int studID) {
		// TODO Auto-generated method stub
		return approveLeavingDaoInterface.getStudentPendingFee( yearID1,  standardID1,  streamID1,  branchID1,
				 studID);
	}

	@Transactional
	@Override
	public void updateStudentStatus(int studID,String conduct, String dateOfLeaving, String reasonOfLeaving,String remark) {
		// TODO Auto-generated method stub
		approveLeavingDaoInterface.updateStudentStatus(studID, conduct,  dateOfLeaving,  reasonOfLeaving, remark);
	}

	
	
	
}
