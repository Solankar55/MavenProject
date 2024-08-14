package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.DownloadDaoInterface;
import com.account.model.DuplicateLeavingCertificateModel;
import com.account.model.LedgerFeePaidModel;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;

@Repository
public class DownloadDaoClass implements DownloadDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getStudentDetails(int registrationID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT b.BonafideDate,s.admissionRegId,s.studentContactNumber,s.studentDateOfBirth,s.studentEmail,s.studentFirstName,s.studentLastName,a.acadamicYear,stand.standard,str.streamName,br.branchName FROM bonafiderequest b left join studentadmission s on s.admissionRegId=b.admissionRegId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join streammaster str on s.streamId=str.streamId left join branchmaster br on br.branchId=s.branchId where b.admissionRegId='"+registrationID+"' ");
		/*and b.BonafideFlag='1'*/
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> studData;
		studData=query.list();
		return studData;
		
		
	}

	@Override
	public void updateBonafideFlag(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update bonafiderequest b set b.BonafideFlag='2' where b.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}

	@Override
	public List<String> getStudentIDDetails(int registrationID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentContactNumber,s.studentDateOfBirth,s.studentPermanenetAddress,s.studentEmail,s.studentFirstName,s.studentLastName,a.acadamicYear,stand.standard,str.streamName,br.branchName FROM idcardrequest b left join studentadmission s on s.admissionRegId=b.admissionRegId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join streammaster str on s.streamId=str.streamId left join branchmaster br on br.branchId=s.branchId where b.admissionRegId='"+registrationID+"' ");
		/*and b.IDrequestFlag='1'*/
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> studDetails;
		studDetails=query.list();
		return studDetails;
	}

	@Override
	public void updateIDCardFlag(int studentID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update idcardrequest i set i.IDrequestFlag='2' where i.admissionRegId='"+studentID+"'");
		query.executeUpdate();
	}

	@Override
	public List<String> getSTudentLCDetails(int registrationID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentContactNumber,s.studentDateOfBirth,s.studentPermanenetAddress,s.studentEmail,s.studentFirstName,s.studentLastName,s.studentPlaceOfBirth,s.studentGender,s.studentNationality,s.studentCategory,s.studentCast,s.admissionDate,s.studentReligion,b.LeavingCertificateDate,a.acadamicYear,stand.standard,str.streamName,br.branchName FROM leavingcertificaterequest b left join studentadmission s on s.admissionRegId=b.admissionRegId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join streammaster str on s.streamId=str.streamId left join branchmaster br on br.branchId=s.branchId where b.admissionRegId='"+registrationID+"' and b.LeavingCertificateFlag='1'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> studInfo;
		studInfo=query.list();
		return studInfo;
	}

	@Override
	public void updateLeavingCertificateFlag(int studentID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update leavingcertificaterequest l left join studentadmission s on s.admissionRegId=l.admissionRegId set l.LeavingCertificateFlag='2',s.status='Cancel' where l.admissionRegId='"+studentID+"' ");
		query.executeUpdate();
	}

	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		List<AdminRegistrationModel> adminData;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId, a.Address, a.Date, a.Email, a.MobileNumber, a.Name, a.Password, a.Type, a.Username FROM adminregistration a where a.Username='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
		
		adminData=query.list();
		
		return adminData;
	}

	@Override
	public List<String> getStudentDetailsForDuplicateLC(int registrationID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentContactNumber,s.studentDateOfBirth,s.studentPermanenetAddress,s.studentEmail,s.studentFirstName,s.studentLastName,s.studentPlaceOfBirth,s.studentGender,s.studentNationality,s.studentCategory,s.studentCast,s.admissionDate,s.studentReligion,b.LeavingCertificateDate,a.acadamicYear,stand.standard,str.streamName,br.branchName FROM leavingcertificaterequest b left join studentadmission s on s.admissionRegId=b.admissionRegId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join streammaster str on s.streamId=str.streamId left join branchmaster br on br.branchId=s.branchId where b.admissionRegId='"+registrationID+"' and b.LeavingCertificateFlag='2' and s.status='Cancel'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> studInfo;
		studInfo=query.list();
		return studInfo;
	}

	@Override
	public void saveDuplicateLcDetails(DuplicateLeavingCertificateModel duplicateLeavingCertificateModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(duplicateLeavingCertificateModel);
	}

	@Override
	public List<String> getStudentDetailsAnyConditionLC(String studentName) {
		// TODO Auto-generated method stub
		
		int studentId=0;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.studentnamessc='"+studentName+"'");
		studentId=(int)query.uniqueResult();
		
		SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.admissionDate,s.studentnamessc,s.studentPlaceOfBirth,s.studentNationality,s.studentReligion,s.studentGender,s.studentDateOfBirth,s.studentCategory,s.studentCast,a.acadamicYear,stand.standard FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join standardmaster stand on stand.standardId=s.standardId where s.admissionRegId='"+studentId+"'");
		query2.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		/*SQLQuery query3=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.AlreadyPaidFees,l.PaidFees,l.PendingFees,l.feeStatus FROM ledgerfeepaid l where l.FeePaidID=(select max(a.admissionRegId) as admissionRegId from ledgerfeepaid a where a.admissionRegId='"+studentId+"')");
		query3.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		*/
		List<String> getStudentDetails=new ArrayList<>();
		//getStudentDetails=query2.list();
		//getStudentDetails.addAll(query3.list());
		getStudentDetails.addAll(query2.list());
		return getStudentDetails;
	}

	@Override
	public List<String> getStudentDetailsTogetLC(int studentId) {
		// TODO Auto-generated method stub
		SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,str.streamName,s.admissionDate,s.studentnamessc,s.studentPlaceOfBirth,s.studentNationality,s.studentReligion,s.studentGender,s.studentDateOfBirth,s.studentCategory,s.studentCast,a.acadamicYear,stand.standard FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join standardmaster stand on stand.standardId=s.standardId left join streammaster str on str.streamId=s.streamId where s.admissionRegId='"+studentId+"'");
		query2.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> studInfo=new ArrayList<>();
		studInfo=query2.list();
		return studInfo;
	}

	@Override
	public List<LedgerFeePaidModel> getStudentDetailsAnyFeeCondition(int studentId) {
		// TODO Auto-generated method stub
		SQLQuery query3=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.AlreadyPaidFees,l.PaidFees,l.PendingFees,l.feeStatus FROM ledgerfeepaid l where l.FeePaidID=(select max(a.FeePaidID) as FeePaidID from ledgerfeepaid a where a.admissionRegId='"+studentId+"')");
		query3.setResultTransformer(Transformers.aliasToBean(LedgerFeePaidModel.class));
		
		List<LedgerFeePaidModel> studFeeDetails=new ArrayList<>();
		studFeeDetails=query3.list();
		return studFeeDetails;
	}

	@Override
	public void saveLeavingCertificate(StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentLeavingCertificateRequestModel);
		
		int studID=studentLeavingCertificateRequestModel.getStudentAdmissionModel().getAdmissionRegId();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update studentadmission s set  s.status='LC Approved' where s.admissionRegId='"+studID+"'");
		query.executeUpdate();
	}

	@Override
	public List<StudentAdmissionModel> getStudentStatus(int studentId) {
		// TODO Auto-generated method stub
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.status FROM studentadmission s where s.admissionRegId='"+studentId+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		
		List<StudentAdmissionModel> studentDetails=new ArrayList<>();
		studentDetails=query.list();
		
		return studentDetails;
	}

	@Override
	public List<String> getStudentDetailsAnyConditionBonafide(int studentId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentContactNumber,s.studentDateOfBirth,s.studentEmail,s.studentFirstName,s.studentLastName,a.acadamicYear,stand.standard,str.streamName,br.branchName FROM studentadmission s left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join streammaster str on s.streamId=str.streamId left join branchmaster br on br.branchId=s.branchId where s.admissionRegId='"+studentId+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> getStudentDetails=new ArrayList<>();
		getStudentDetails=query.list();
		return getStudentDetails;
	}

	@Override
	public void saveStudentBonfideAnyCondition(StudentBonafideRequestModel studentBonafideRequestModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentBonafideRequestModel);
	}

	@Override
	public void updateBonafideAnyCondition(int studentId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update bonafiderequest b set b.BonafideFlag='2' where b.admissionRegId='"+studentId+"'");
		query.executeUpdate();
	}

	@Override
	public List<String> getStudentDataIDAnyCondition(int studentId) {
		// TODO Auto-generated method stub
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentContactNumber,s.studentDateOfBirth,s.studentPermanenetAddress,s.studentEmail,s.studentFirstName,s.studentLastName,a.acadamicYear,stand.standard,str.streamName,br.branchName FROM studentadmission s left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join standardmaster stand on s.standardId=stand.standardId left join streammaster str on s.streamId=str.streamId left join branchmaster br on br.branchId=s.branchId where s.admissionRegId='"+studentId+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> studentDetails=new ArrayList<>();
		studentDetails=query.list();
		
		return studentDetails;
	}

	@Override
	public void saveStudentIdAnyConditionDetails(StudentIDCardRequestModel studentIDCardRequestModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentIDCardRequestModel);
	}


	
	
}
