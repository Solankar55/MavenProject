package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.AutoCompleteDaoInterface;

@Repository
public class AutoCompleteDaoClass implements AutoCompleteDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> serchStudentName(String keyword) {
		// TODO Auto-generated method stub  left join acadamicyear a on a.acadamicYearId=s.acadamicYearId where s.ActiveAcadamicYr='Active' and 
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT s.studentnamessc FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId where a.ActiveAcadamicYr='Active' and s.studentnamessc like :keyword");
		query.setString("keyword", "%" + keyword + "%");
		return query.list();
	}

	@Override
	public List<String> getStudentAllDataForPayment(String studentName) {
		// TODO Auto-generated method stub
		int registrationID=0;
		SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.studentnamessc FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId where a.ActiveAcadamicYr='Active' and s.studentnamessc='"+studentName+"'");
		//registrationID=(int)query1.uniqueResult();
		String stduentName=(String) query1.uniqueResult();

		List<String> FetchStudentInfoList;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,a.acadamicYear,s.admissionDate,s.studentLastName,s.studentFirstName,s.studentMiddleName,s.branchId,b.branchName,a.acadamicYearId,s.standardId,s.divisionId,sm.standard,s.streamId,ss.streamName FROM studentadmission s Left join acadamicyear a on s.acadamicYearId=a.acadamicYearId Left join branchmaster b on s.branchId=b.branchId Left join standardmaster sm on sm.standardId=s.standardId left join streammaster ss on ss.streamId=s.streamId where s.studentnamessc ='"+studentName+"' and status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		FetchStudentInfoList = query.list(); 
		return FetchStudentInfoList;
		
		/*List<String> FetchStudentInfoList=new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,a.acadamicYear,s.admissionDate,s.studentLastName,s.studentFirstName,s.studentMiddleName,s.branchId,b.branchName,a.acadamicYearId,s.standardId,s.divisionId,sm.standard,s.streamId,ss.streamName FROM studentadmission s Left join acadamicyear a on s.acadamicYearId=a.acadamicYearId Left join branchmaster b on s.branchId=b.branchId Left join standardmaster sm on sm.standardId=s.standardId left join streammaster ss on ss.streamId=s.streamId where s.studentnamessc ='"+studentName+"' and status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		FetchStudentInfoList = query.list(); 
		return FetchStudentInfoList;*/
	}
	
	
}
