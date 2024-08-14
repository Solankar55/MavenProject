package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.daoInteerface.DownloadDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

@Repository
public class DownloadDaoC implements DownloadDaoInterface{

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
	public List<String> GetDetailInfo(String studName, String studCon) {
		// TODO Auto-generated method stub
		List<String> StudentDetail=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentFirstName,s.studentLastName,s.studentDateOfBirth,a.acadamicYear,stand.standard FROM studentadmission s left join standardmaster stand on s.standardId=stand.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.studentFirstName='"+studName+"' and s.studentContactNumber='"+studCon+"' and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentDetail=query.list();
		
		return StudentDetail;
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
	public List<StudentAdmissionModel> getRequestStudInfo(String studName, String studCon, String studEmail) {
		// TODO Auto-generated method stub
		List<StudentAdmissionModel> StudInfoBonafide=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.studentFirstName='"+studName+"' and s.studentContactNumber='"+studCon+"' and s.studentEmail='"+studEmail+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		StudInfoBonafide=query.list();
		return StudInfoBonafide;
	}

	@Override
	public int getFlagStud(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select b.BonafideFlag FROM bonafiderequest b left join studentregistration s on s.StudentRegistrationId=b.admissionRegId where b.admissionRegId='"+studID+"'");
		//query.setResultTransformer(Transformers.TO_LIST);
		
		System.out.println(query.list().get(0));
		Object Count=query.list().get(0);
		Integer i=Integer.parseInt(Count.toString());
		System.out.println("flag"+i);
		return i;
	}

	@Override
	public void updateBonafideFlag(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update bonafiderequest b set b.BonafideFlag='2', b.DownloadCount='1'  where b.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}

	@Override
	public int getDownloadValue(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(b.DownloadCount)as downloadCount FROM bonafiderequest b where b.admissionRegId='"+studID+"'");
		//query.setResultTransformer(Transformers.TO_LIST);
		
		System.out.println(query.list().get(0));
		Object Count=query.list().get(0);
		Integer i=Integer.parseInt(Count.toString());
		System.out.println("flag"+i);
		return i;
	}

	@Override
	public List<String> getStudDetails(String studName, String studCon) {
		// TODO Auto-generated method stub
		List<String> StudentInfo=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentDateOfBirth,s.studentFirstName,s.studentLastName,s.studentContactNumber,s.studentPermanenetAddress,a.acadamicYear,stand.standard,b.branchName,str.streamName FROM studentadmission s left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join branchmaster b on s.branchId=b.branchId left join streammaster str on s.streamId=str.streamId where s.studentFirstName='"+studName+"' and s.studentContactNumber='"+studCon+"' and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentInfo=query.list();
		
		return StudentInfo;
	}

	@Override
	public int checkIDFlag(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT i.IDrequestFlag FROM idcardrequest i where i.admissionRegId='"+studID+"'");
		//query.setResultTransformer(Transformers.TO_LIST);
		
		System.out.println(query.list().get(0));
		Object Count=query.list().get(0);
		Integer i=Integer.parseInt(Count.toString());
		System.out.println("flag"+i);
		return i;
	}

	@Override
	public void updateIDCardFlag(int studentID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update idcardrequest i set i.IDrequestFlag='2' where i.admissionRegId='"+studentID+"'");
		query.executeUpdate();
	}

	@Override
	public int checkLeavingCertificateFlag(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LeavingCertificateFlag FROM leavingcertificaterequest l where l.admissionRegId='"+studID+"'");
		//query.setResultTransformer(Transformers.TO_LIST);
		
		System.out.println(query.list().get(0));
		Object Count=query.list().get(0);
		Integer i=Integer.parseInt(Count.toString());
		System.out.println("flag"+i);
		return i;
	}

	@Override
	public List<String> GetStudentDetails(String studName, String studCon) {
		// TODO Auto-generated method stub
		List<String> StudentDetails=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentCategory,s.studentCast,s.studentDateOfBirth,s.studentFirstName,s.studentLastName,s.studentGender,s.studentMotherTongue,s.studentNationality,s.studentPlaceOfBirth,s.studentReligion,s.studentSubCast,a.acadamicYear,stand.standard,s.admissionDate FROM studentadmission s left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId where s.studentFirstName='"+studName+"' and s.studentContactNumber='"+studCon+"' and s.status='LC Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentDetails=query.list();
		
		return StudentDetails;
	}

	@Override
	public void updateLeavingCertificateFlag(int studentID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update leavingcertificaterequest l left join studentadmission s on s.admissionRegId=l.admissionRegId set l.LeavingCertificateFlag='2',s.status='Cancel' where l.admissionRegId='"+studentID+"' ");
		query.executeUpdate();
	}
	
	
}
