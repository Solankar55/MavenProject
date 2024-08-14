package com.webService.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webService.daoInterface.WebServiceDaoInterface;

@Repository
public class WebServiceDaoClass implements WebServiceDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getYearList() {
		// TODO Auto-generated method stub
		List<String> YearList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT a.acadamicYearId,a.acadamicYear FROM acadamicyear a where a.ActiveAcadamicYr='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		YearList = query.list();
		return YearList;
	}

	@Override
	public List<String> getStreamList() {
		// TODO Auto-generated method stub
		List<String> StreamList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.streamId, s.streamName FROM streammaster s");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		StreamList = query.list();
		return StreamList;
	}

	@Override
	public List<String> getBranchList(int streamId) {
		// TODO Auto-generated method stub
		List<String> BranchList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT b.branchId,b.branchName FROM branchmaster b where b.streamId='"+streamId+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		BranchList = query.list();
		return BranchList;
	}

	@Override
	public List<String> getStandardList(int branchID) {
		// TODO Auto-generated method stub
		List<String> BranchList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.standardId, s.standard FROM standardmaster s where s.branchId='"+branchID+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		BranchList = query.list();
		return BranchList;
	}

	@Override
	public List<String> getStudentList(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		List<String> StudentList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.admissionRegId, s.aadharCardNumber, s.accountNumber, s.admissionDate, s.bankBranch, s.bankIFSCCode, s.bankName, s.fatherEmail, s.fatherFirstName,s.fatherLastName, s.fatherMonthlyIncome, s.fatherOccupation,s.fatherPermananetAddress,s.fathermiddleName,s.status,s.studentCast, s.studentCategory,s.studentContactNumber,s.studentDateOfBirth,s.studentEmail,s.studentFirstName,s.studentGender,s.studentImage,s.studentLastName, s.studentMiddleName,s.studentMotherName,s.studentMotherTongue, s.studentNationality, s.studentParentContactNumber, s.studentPermanenetAddress, s.studentPinCode, s.studentPlaceOfBirth, s.studentReligion, s.studentResidentialAddress, s.studentSubCast FROM studentadmission s where s.acadamicYearId='"+yearID+"' and s.branchId='"+branchID+"' and s.standardId='"+standardID+"' and s.streamId='"+streamID+"' and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		StudentList = query.list();
		return StudentList;
	}

	@Override
	public List<String> getUserAutheticationCheck(String userName, String passWord) {
		// TODO Auto-generated method stub
		List<String> UserDetailList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.StudentRegistrationId, s.StudentAddress, s.StudentContactNumber, s.StudentEmail, s.StudentName FROM studentregistration s where s.StudentPassword='"+passWord+"' and  s.StudentUserName='"+userName+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		UserDetailList = query.list();
		return UserDetailList;
	}

}
