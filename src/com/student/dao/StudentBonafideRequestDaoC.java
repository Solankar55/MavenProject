package com.student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.daoInteerface.StudentBonafideDeoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentRegistrationModel;
@Repository
public class StudentBonafideRequestDaoC implements StudentBonafideDeoInterface {

	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StudentRegistrationModel> getStudInfo(String username) {
		// TODO Auto-generated method stub
		List<StudentRegistrationModel> studentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StudentRegistrationId,s.StudentName,s.StudentContactNumber,s.StudentEmail FROM studentregistration s where s.StudentUserName='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));
		studentList=query.list();
		
		return studentList;
	}

	@Override
	public List<String> getDetailInfo(String studName, String studCon,String studEmail) {
		// TODO Auto-generated method stub
		List<String> StudentDetail=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentDateOfBirth,s.studentFirstName,s.studentLastName,s.studentContactNumber,s.studentPermanenetAddress,a.acadamicYear,stand.standard,b.branchName,str.streamName FROM studentadmission s left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join branchmaster b on s.branchId=b.branchId left join streammaster str on s.streamId=str.streamId where s.admissionRegId=(select max(s.admissionRegId) as admissionRegId from studentadmission s where s.studentEmail='"+studEmail+"' and s.studentContactNumber='"+studCon+"') and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentDetail=query.list();
		
		return StudentDetail;
	}

	@Override
	public void SaveRequest(StudentBonafideRequestModel studentBonafideRequestModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(studentBonafideRequestModel);
	}

	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		List<String> GetStudInfo=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from studentregistration where StudentUserName='"+username+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetStudInfo=query.list();
		return GetStudInfo;
	}

	@Override
	public List<StudentAdmissionModel> getStudInfoOfRequest(String studName, String studCon,String StudEmail) {
		// TODO Auto-generated method stub
		List<StudentAdmissionModel> StudInfoBonafide=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.admissionRegId=(select max(s.admissionRegId) as admissionRegId from studentadmission s where s.studentContactNumber='"+studCon+"' and s.studentEmail='"+StudEmail+"')");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		StudInfoBonafide=query.list();
		return StudInfoBonafide;
	}

	@Override
	public int getBonafideCount(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select count(b.BonafideRequestId) as BonafideRequestId FROM bonafiderequest b left join studentregistration s on s.StudentRegistrationId=b.admissionRegId where b.admissionRegId='"+studID+"'");
		//query.setResultTransformer(Transformers.TO_LIST);
		
		System.out.println(query.list().get(0));
		Object Count=query.list().get(0);
		Integer i=Integer.parseInt(Count.toString());
		System.out.println("cout"+i);
		return i;
	}

}
