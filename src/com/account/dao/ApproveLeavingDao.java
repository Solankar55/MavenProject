package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.ApproveLeavingDaoInterface;
import com.account.model.LedgerFeePaidModel;
@Repository
public class ApproveLeavingDao implements ApproveLeavingDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getLeavingList() {
		// TODO Auto-generated method stub
		
		List<String> LeavingRequestList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,l.LeavingCertificateFlag,s.studentFirstName,s.studentLastName,s.studentDateOfBirth,a.acadamicYear,str.streamName,stand.standard,b.branchName,s.studentSubCast,s.studentReligion,s.studentPlaceOfBirth,s.studentNationality,s.studentMotherTongue,s.studentGender,s.studentCategory,s.studentCast,s.acadamicYearId,s.standardId,s.streamId,s.branchId FROM leavingcertificaterequest l left join studentadmission s on l.admissionRegId=s.admissionRegId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join streammaster str on s.streamId=str.streamId left join standardmaster stand on s.standardId=stand.standardId left join branchmaster b on s.branchId=b.branchId where l.LeavingCertificateFlag='0' and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		LeavingRequestList=query.list();
		
		return LeavingRequestList;
	}

	@Override
	public void TakeLeaving(int studID,String conduct, String dateOfLeaving, String reasonOfLeaving,String remark) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update leavingcertificaterequest l set l.LeavingCertificateFlag='1',l.Conduct='"+conduct+"',l.DateOfLeaving='"+dateOfLeaving+"',l.ReasonForLeaving='"+reasonOfLeaving+"',l.Remark='"+remark+"' where l.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}

	@Override
	public void cancelLeaving(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update leavingcertificaterequest l set l.LeavingCertificateFlag='2' where l.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}

	@Override
	public List<LedgerFeePaidModel> getStudentPendingFee(int yearID1, int standardID1, int streamID1, int branchID1,
			int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.PendingFees  FROM ledgerfeepaid l where l.AcdemicYearID='"+yearID1+"' and l.BranchID='"+branchID1+"' and l.StandardID='"+standardID1+"' and l.StreamID='"+streamID1+"' and l.admissionRegId='"+studID+"' and l.FeePaidID=(SELECT max(l.FeePaidID) as FeePaidID  FROM ledgerfeepaid l where l.AcdemicYearID='"+yearID1+"' and l.BranchID='"+branchID1+"' and l.StandardID='"+standardID1+"' and l.StreamID='"+streamID1+"' and l.admissionRegId='"+studID+"')");
		query.setResultTransformer(Transformers.aliasToBean(LedgerFeePaidModel.class));
		
		List<LedgerFeePaidModel> listStd;
		listStd=query.list();
		
		return listStd;
		
	}

	@Override
	public void updateStudentStatus(int studID,String conduct, String dateOfLeaving, String reasonOfLeaving,String remark) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update studentadmission s set  s.status='LC Approved' where s.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}
	
}
