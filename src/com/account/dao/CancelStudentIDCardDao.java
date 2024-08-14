package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.CancelStudentIDCardDaoInterface;
@Repository
public class CancelStudentIDCardDao implements CancelStudentIDCardDaoInterface {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> cancelIDcardList() {
		// TODO Auto-generated method stub
		List<String> CancelIDList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentFirstName,s.studentLastName,stream.streamName,stand.standard,branch.branchName,s.studentContactNumber,s.studentDateOfBirth,a.acadamicYear,s.studentPermanenetAddress FROM idcardrequest i left join studentadmission s on s.admissionRegId=i.admissionRegId left join streammaster stream on stream.streamId=s.streamId left join standardmaster stand on stand.standardId=s.standardId left join branchmaster branch on branch.branchId=s.branchId left join acadamicyear a on a.acadamicYearId=s.acadamicYearId where i.IDrequestFlag='2' group by s.admissionRegId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		CancelIDList=query.list();
		
		return CancelIDList;
	}
	
	

}
