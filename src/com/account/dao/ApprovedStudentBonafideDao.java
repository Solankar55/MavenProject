package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.ApprovedStudentBonafideDaoInterface;
@Repository
public class ApprovedStudentBonafideDao implements ApprovedStudentBonafideDaoInterface{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> GetApprovedBonafideList() {
		// TODO Auto-generated method stub
		List<String> ApprovedBonafideList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentFirstName,s.studentLastName,stream.streamName,stand.standard,a.acadamicYear,s.studentDateOfBirth FROM bonafiderequest b left join studentadmission s on s.admissionRegId=b.admissionRegId left join streammaster stream on stream.streamId=s.streamId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on a.acadamicYearId=s.acadamicYearId where b.BonafideFlag='1' group by s.admissionRegId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		ApprovedBonafideList=query.list();
		return ApprovedBonafideList;
	}
	
	

}
