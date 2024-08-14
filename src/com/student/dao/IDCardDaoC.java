package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.daoInteerface.IDCardDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentRegistrationModel;
@Repository
public class IDCardDaoC implements IDCardDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StudentRegistrationModel> GetInfo(String username) {
		// TODO Auto-generated method stub
		List<StudentRegistrationModel> studentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StudentRegistrationId,s.StudentName,s.StudentContactNumber,s.StudentEmail FROM studentregistration s where s.StudentUserName='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));
		studentList=query.list();
		
		return studentList;
	}

	@Override
	public List<String> GetStudDetails(String studName, String studCon,String studEmail) {

		List<String> StudentInfo=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentDateOfBirth,s.studentFirstName,s.studentLastName,s.studentContactNumber,s.studentPermanenetAddress,a.acadamicYear,stand.standard,b.branchName,str.streamName FROM studentadmission s left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join branchmaster b on s.branchId=b.branchId left join streammaster str on s.streamId=str.streamId where s.admissionRegId=(select max(s.admissionRegId) as admissionRegId from studentadmission s where s.studentEmail='"+studEmail+"' and s.studentContactNumber='"+studCon+"') and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentInfo=query.list();
		
		return StudentInfo;
	}

	@Override
	public void SaveIDCardRequest(StudentIDCardRequestModel studentIDCardRequestModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(studentIDCardRequestModel);
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
	public List<StudentAdmissionModel> getStudentID(String studName, String studCon, String studEmail) {
		// TODO Auto-generated method stub
		List<StudentAdmissionModel> getList;
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.admissionRegId=(select max(s.admissionRegId) as admissionRegId from studentadmission s where s.studentFirstName='"+studName+"' and s.studentContactNumber='"+studCon+"' and s.studentEmail='"+studEmail+"')");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		
		getList=query.list();
		return getList;
	}

	@Override
	public List<String> getCheackIDRequest(int studID) {
		// TODO Auto-generated method stub
		List<String> getIDRequestlist;
		 
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT i.IDCardRequestID FROM idcardrequest i where i.admissionRegId='"+studID+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		getIDRequestlist=query.list();
		
		return getIDRequestlist;
	}
	
}
