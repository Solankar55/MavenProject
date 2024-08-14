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
import com.staff.daoInterface.StaffMenuDaoInterface;
import com.staff.model.StudentAttendance;
import com.staff.model.StudentEnteryOfAttendance;

@Repository
public class StaffMenuDao implements StaffMenuDaoInterface {

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

		List<StaffRegistrationModel> DataList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"
						+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));

		DataList = query.list();

		return DataList;
	}

	@Override
	public List<String> getCheckAvabality(int staffID) {
		// TODO Auto-generated method stub
		List<String> CheckList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT * FROM assignsubjectteacher a where a.staffRegistrationId='" + staffID + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		CheckList = query.list();

		return CheckList;
	}

	@Override
	public List<String> CheckClassInchargeOrNot(int staffID) {
		// TODO Auto-generated method stub
		List<String> CheckList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT * FROM assignclassincharge a where a.staffRegistrationId='" + staffID + "'");
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
	public int getMaxStudentAttendanceID() {
		// TODO Auto-generated method stub
		List b;
		int StudentAttendanceID = 0;
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT max(s.AttendanceID) as AttendanceID FROM studentattendance s");
		b = query.list();

		if (b.get(0) == null) {
			return StudentAttendanceID + 1;
		} else {
			return StudentAttendanceID = (int) b.get(0);
		}
	}

	@Override
	public void saveSubjectVisStudentAttendance(StudentAttendance studentAttendance) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentAttendance);
	}

	@Override
	public void saveStudentAttendanceBySubjectVis(StudentEnteryOfAttendance studentEnteryOfAttendance) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentEnteryOfAttendance);
	}

	@Override
	public List<String> getSubjectListStaff(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub

		List<String> getSubjectList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT s.SubjectID, s.SubjectName FROM subjectmasterhod s where s.acadamicYearId='"
						+ yearID + "' and s.branchId='" + branchID + "'and s.standardId='" + standardID
						+ "' and s.streamId='" + streamID + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getSubjectList = query.list();

		return getSubjectList;
	}

	@Override
	public List<Object[]> getStudentListForAtt(int yrId, int streamId, int branchId, int standId, int subId) {

		List<Object[]> getStudentList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.admissionRegId,s.studentFirstName,s.studentLastName,s.studentMiddleName FROM studentadmission s where s.acadamicYearId='"
						+ yrId + "' and s.branchId='" + branchId + "'and s.standardId='" + standId
						+ "' and s.streamId='" + streamId + "' and s.status='Approved'");
		//query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStudentList = query.list();

		return getStudentList;
	}

	@Override
	public List gettotalNoOFLect(int yrId, int streamId, int branchId, int standId, int subId) {

		Integer gettotalNoOFLect = 0;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT sum(s.NumberOfLect)as NumberOfLect FROM studentattendance s where s.acadamicYearId='" + yrId
						+ "' and s.branchId='" + branchId + "' and s.SubjectID ='" + subId + "' and  s.standardId ='"
						+ standId + "' and s.streamId ='" + streamId + "'");

		List No = query.list();

		return No;

	}

}
