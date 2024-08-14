package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.ApprovedLeavingCertificateDaoInterface;
@Repository
public class ApprovedLeavingCertificateDao implements ApprovedLeavingCertificateDaoInterface{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> approvedLeavingCertificateList() {
		// TODO Auto-generated method stub
		List<String> ApprovedLeavingCertificateList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentFirstName,s.studentLastName,stream.streamName,stand.standard,branch.branchName,s.studentDateOfBirth,a.acadamicYear,s.studentNationality,s.studentMotherTongue,s.studentPlaceOfBirth,s.studentCast,s.studentCategory,s.studentReligion,s.studentSubCast,s.studentGender FROM leavingcertificaterequest l left join studentadmission s on s.admissionRegId=l.admissionRegId left join streammaster stream on stream.streamId=s.streamId left join standardmaster stand on stand.standardId=s.standardId left join branchmaster branch on branch.branchId=s.branchId left join acadamicyear a on a.acadamicYearId=s.acadamicYearId where s.status='LC Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		ApprovedLeavingCertificateList=query.list();
		return ApprovedLeavingCertificateList;
	}
	
	

}
