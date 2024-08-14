package com.staff.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.model.StaffRegistrationModel;
import com.staff.daoInterface.AssignmentToStudentDaoInterface;
import com.staff.model.StudentAssignmentEnteryReportModel;
import com.staff.model.StudentAssignmentModel;

@Repository
public class AssignmentToStudentDaoClass implements AssignmentToStudentDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> DataList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"
						+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));

		DataList = query.list();

		return DataList;
	}

	@Override
	public List<String> GetCheckAvability(int staffID) {
		// TODO Auto-generated method stub
		List<String> CheckList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT * FROM assignsubjectteacher a where a.staffRegistrationId='" + staffID + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		CheckList = query.list();

		return CheckList;
	}

	@Override
	public HashMap<String, String> GetYearList(int staffID) {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT DISTINCT a.acadamicYearId,y.acadamicYear FROM assignsubjectteacher a left join acadamicyear y on y.acadamicYearId=a.acadamicYearId where a.staffRegistrationId='"
						+ staffID + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		for (HashMap map : list) {

			mapOfAcadimicYear.put(map.get("acadamicYearId"), map.get("acadamicYear"));

		}
		return mapOfAcadimicYear;
	}

	@Override
	public HashMap<String, String> GetBranchlist(int staffID) {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfBranchYear = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT DISTINCT a.branchId,y.branchName FROM assignsubjectteacher a left join branchmaster y on y.branchId=a.branchId where a.staffRegistrationId='"
						+ staffID + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		for (HashMap map : list) {

			mapOfBranchYear.put(map.get("branchId"), map.get("branchName"));

		}
		return mapOfBranchYear;
	}

	@Override
	public HashMap<String, String> GetStreamList(int staffID) {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfStreamYear = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT DISTINCT a.streamId,y.streamName FROM assignsubjectteacher a left join streammaster y on y.streamId=a.streamId  where a.staffRegistrationId='"
						+ staffID + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		for (HashMap map : list) {

			mapOfStreamYear.put(map.get("streamId"), map.get("streamName"));

		}
		return mapOfStreamYear;
	}

	@Override
	public HashMap<String, String> GetStandardList(int staffID) {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfStandardYear = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT DISTINCT a.standardId,y.standard FROM assignsubjectteacher a left join standardmaster y on y.standardId=a.standardId  where a.staffRegistrationId='"
						+ staffID + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		for (HashMap map : list) {

			mapOfStandardYear.put(map.get("standardId"), map.get("standard"));

		}
		return mapOfStandardYear;
	}

	@Override
	public HashMap<String, String> GetSubjectList(int staffID) {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfSubjectList = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT distinct a.SubjectID,s.SubjectName FROM assignsubjectteacher a left join subjectmasterhod s on s.SubjectID=a.SubjectID where a.staffRegistrationId='"
						+ staffID + "' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		for (HashMap map : list) {

			mapOfSubjectList.put(map.get("SubjectID"), map.get("SubjectName"));

		}
		return mapOfSubjectList;
	}

	@Override
	public List<String> GetStudentList(int yearID, int streamID, int branchID, int standardID, int subjectID) {
		// TODO Auto-generated method stub
		List<String> getStudentList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.admissionRegId,s.studentFirstName,s.studentLastName,a.acadamicYear,stream.streamName,stand.standard,branch.branchName FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join streammaster stream on stream.streamId=s.streamId left join standardmaster stand on stand.standardId=s.standardId left join branchmaster branch on branch.branchId=s.branchId where s.status='Approved' and  s.acadamicYearId='"
						+ yearID + "' and s.branchId='" + branchID + "' and s.standardId='" + standardID
						+ "' and s.streamId='" + streamID + "' and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		getStudentList = query.list();

		return getStudentList;
	}

	@Override
	public void saveStudentAssignment(StudentAssignmentModel studentAssignmentModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentAssignmentModel);
	}

	@Override
	public int getMaxAssignmentID() {
		// TODO Auto-generated method stub
		List studentID;
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT max(s.AssignmentID) as AssignmentID FROM studentassignment s");
		studentID=query.list();
		
		int maxID=0;
		if(studentID.get(0)==null)
		{
			return maxID+1;
		}
		else
		{
			maxID=(int)studentID.get(0);
			return maxID;
		}
		
	}

	@Override
	public void saveStudentRecordWithAssignment(StudentAssignmentEnteryReportModel studentAssignmentEnteryReportModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentAssignmentEnteryReportModel);
	}

}
