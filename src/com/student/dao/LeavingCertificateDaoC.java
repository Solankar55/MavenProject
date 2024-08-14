package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.daoInteerface.LeavingCertificateDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;
@Repository
public class LeavingCertificateDaoC implements LeavingCertificateDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> GetStudentDetails(String studName, String studCon,String studEmail) {
		
		List<String> StudentDetails=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentCategory,s.studentCast,s.studentDateOfBirth,s.studentFirstName,s.studentLastName,s.studentGender,s.studentMotherTongue,s.studentNationality,s.studentPlaceOfBirth,s.studentReligion,s.studentSubCast,a.acadamicYear,stand.standard,s.admissionDate FROM studentadmission s left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId where  s.admissionRegId=(select max(s.admissionRegId) as admissionRegId from studentadmission s where s.studentEmail='"+studEmail+"' and s.studentContactNumber='"+studCon+"') and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentDetails=query.list();
		
		return StudentDetails;
	}

	@Override
	public List<StudentRegistrationModel> GetStudentInfo(String username) {
		// TODO Auto-generated method stub
		List<StudentRegistrationModel> studentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StudentRegistrationId,s.StudentName,s.StudentContactNumber,s.StudentEmail FROM studentregistration s where s.StudentUserName='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));
		studentList=query.list();
		
		return studentList;
	}

	@Override
	public void SaveLeavingCertificateRequest(
			StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(studentLeavingCertificateRequestModel);
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
	public int getLCNumber() {
		// TODO Auto-generated method stub
		List LCNumber=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(l.LeavingCertificateReuestId) FROM leavingcertificaterequest l");
		LCNumber=query.list();
		
		int number=0;
		if(LCNumber.get(0)==null)
		{
			return number+1;
		}
		else
		{
			return number=(int)LCNumber.get(0)+1;
		}
		
		
	}

	@Override
	public List<StudentAdmissionModel> getStudID(String studName, String studCon, String studEmailAddress) {
		// TODO Auto-generated method stub
		List<StudentAdmissionModel> StudInfo=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.admissionRegId=(select max(s.admissionRegId) as admissionRegId from studentadmission s where s.studentContactNumber='"+studCon+"' and s.studentEmail='"+studEmailAddress+"')");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		StudInfo=query.list();
		return StudInfo;
	}

	@Override
	public List<String> getCheckStudPresentOrNot(int studentRequestID) {
		// TODO Auto-generated method stub
		List<String> GetCheck=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM leavingcertificaterequest l where l.admissionRegId='"+studentRequestID+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetCheck=query.list();
		
		return GetCheck;
	}
	
	
}
