package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.ApproveBonafideDaoInterface;
@Repository
public class ApproveBonafideDao implements ApproveBonafideDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getRequestBonafideList() {
		// TODO Auto-generated method stub
		
		List<String> BonafideRequestList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,bon.BonafideFlag,s.studentFirstName,s.studentLastName,s.studentDateOfBirth,a.acadamicYear,str.streamName,stand.standard,b.branchName FROM bonafiderequest bon left join studentadmission s on bon.admissionRegId=s.admissionRegId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join streammaster str on s.streamId=str.streamId left join standardmaster stand on s.standardId=stand.standardId left join branchmaster b on s.branchId=b.branchId where bon.BonafideFlag='0' and s.status='Approved'  group by s.admissionRegId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BonafideRequestList=query.list();
		
		return BonafideRequestList;
	}

	@Override
	public void TakeBonafideRequest(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update bonafiderequest b set b.BonafideFlag='1' where b.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}

	@Override
	public void CancelBonafide(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update bonafiderequest b set b.BonafideFlag='2' where b.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}
	
	
}
