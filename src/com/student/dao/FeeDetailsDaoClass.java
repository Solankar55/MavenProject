package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.daoInteerface.FeeDetailsDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

@Repository
public class FeeDetailsDaoClass implements FeeDetailsDaoInterface {

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

		List<StudentRegistrationModel> getStudentList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT * FROM studentregistration s where s.StudentUserName='" + username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));

		getStudentList = query.list();

		return getStudentList;
	}

	@Override
	public List<Object[]> getCheckStudInfo(String studName, String studCon, String studEmail) {
		// TODO Auto-generated method stub
		List<Object[]> StudentList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("select s.admissionRegId,s.acadamicYearId,s.branchId,s.standardId,s.streamId from studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join streammaster stream on stream.streamId=s.streamId where s.studentFirstName='"+studName+"' and s.studentContactNumber='"+studCon+"' and s.studentEmail='"+studEmail+"'");
		//query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));

		StudentList = query.list();

		return StudentList;
	}

	@Override
	public List<String> getFeeDetails(int studentID, int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub

		List<String> feepaidDetails;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.FeePaidID, l.AcademicYear,l.AlreadyPaidFees,l.PaidFees,l.PendingFees, l.Standard,l.feeStatus, l.totalFee,(l.admissionRegId)as StudentID FROM ledgerfeepaid l left join acadamicyear a on l.AcdemicYearID=a.acadamicYearId left join branchmaster b on l.BranchID=b.branchId left join standardmaster st on l.StandardID=st.standardId left join streammaster str on l.StreamID=str.streamId where l.FeePaidID =(SELECT max(l.FeePaidID) as FeePaidID FROM ledgerfeepaid l where l.admissionRegId='"+studentID+"' and l.AcdemicYearID='"+yearID+"' and l.BranchID='"+branchID+"' and l.StandardID='"+standardID+"' and l.StreamID='"+streamID+"')");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		feepaidDetails=query.list();
		
		return feepaidDetails;
		

	}

	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		List<String> GetStudInfo = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("select * from studentregistration where StudentUserName='" + username + "' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetStudInfo = query.list();
		return GetStudInfo;
	}

}
