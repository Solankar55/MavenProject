package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.ApproveStudentIDCardDaoInterface;
@Repository
public class ApproveStudentIDCardDao implements ApproveStudentIDCardDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> GetRequestIDCardList() {
		// TODO Auto-generated method stub
		
		List<String> IDCardRequestList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,i.IDrequestFlag,s.studentFirstName,s.studentLastName,s.studentPermanenetAddress,s.studentContactNumber,s.studentDateOfBirth,a.acadamicYear,str.streamName,stand.standard,b.branchName FROM idcardrequest i left join studentadmission s on i.admissionRegId=s.admissionRegId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join streammaster str on s.streamId=str.streamId left join standardmaster stand on s.standardId=stand.standardId left join branchmaster b on s.branchId=b.branchId where i.IDrequestFlag='0' and s.status='Approved'  group by s.admissionRegId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		IDCardRequestList=query.list();
		
		return IDCardRequestList;
	}

	@Override
	public void TakeIDCardRequest(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update idcardrequest i set i.IDrequestFlag='1' where i.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}

	@Override
	public void cancelIDCard(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update idcardrequest i set i.IDrequestFlag='2' where i.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}
	
	
}
