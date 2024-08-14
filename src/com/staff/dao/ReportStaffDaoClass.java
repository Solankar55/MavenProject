package com.staff.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.staff.daoInterface.ReportStaffDaoInterface;

@Repository
public class ReportStaffDaoClass implements ReportStaffDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<HODSubjectMasterModel> GetSubjectList(int staffID) {
		// TODO Auto-generated method stub

		List<HODSubjectMasterModel> SubjectList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT sub.SubjectName,sub.SubjectID FROM assignsubjectteacher a left join subjectmasterhod sub on sub.SubjectID=a.SubjectID  where a.staffRegistrationId='"+staffID+"'");
		query.setResultTransformer(Transformers.aliasToBean(HODSubjectMasterModel.class));
		
		SubjectList=query.list();

		
		return SubjectList;
	}

	@Override
	public List<String> getStudentList(int subjectID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT stud.admissionRegId, s.CurrentDate, s.LectEndTimeDate, s.LectStartTimeDate, s.NumberOfLect,studAd.studentFirstName,studAd.studentLastName,staff.StaffName,subm.SubjectName FROM studentattendance s left join studententeryofattendance stud on stud.AttendanceID=s.AttendanceID left join assignsubjectteacher a on a.SubjectID=s.SubjectID left join staffregistration staff on staff.staffRegistrationId=a.staffRegistrationId left join subjectmasterhod subm on subm.SubjectID=s.SubjectID left join studentadmission studAd on studAd.admissionRegId=stud.admissionRegId where s.SubjectID='"+subjectID+"' and studAd.status='Approved' and s.AttendanceID=(SELECT max(s.AttendanceID) as AttendanceID FROM studentattendance s where s.SubjectID='"+subjectID+"')");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> StudentList;
		StudentList=query.list();
		
		return StudentList;
		
	}

	@Override
	public List<Object[]> getStudentD(int subjectID) {
		// TODO Auto-generated method stub
		List<Object[]> studentD;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.AttendanceID,s.acadamicYearId,s.branchId,s.standardId,s.streamId FROM studentattendance s where s.SubjectID='"+subjectID+"'");
		studentD=query.list();
		return studentD;
	}

	@Override
	public List<String> getStudentPresentList(Integer attendenceID, Integer yearID, Integer branchID,
			Integer standardID, Integer streamID) {
		// TODO Auto-generated method stub
		List<String> StudentList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentFirstName,s.studentLastName,(SELECT s.CurrentDate FROM studentattendance s where s.AttendanceID='"+attendenceID+"') as CurrentDate,(SELECT s.NumberOfLect FROM studentattendance s where s.AttendanceID='"+attendenceID+"') as NumberOfLect,(SELECT s.LectEndTimeDate FROM studentattendance s where s.AttendanceID='"+attendenceID+"') as LectEndTimeDate,(SELECT s.LectStartTimeDate FROM studentattendance s where s.AttendanceID='"+attendenceID+"') as LectStartTimeDate,(SELECT s.SubjectName FROM subjectmasterhod s left join studentattendance sa on s.SubjectID=sa.SubjectID left join assignsubjectteacher a on a.SubjectID=s.SubjectID left join staffregistration st on st.staffRegistrationId=a.staffRegistrationId where sa.AttendanceID='"+attendenceID+"') as SubjectName,(SELECT st.StaffName FROM subjectmasterhod s left join studentattendance sa on s.SubjectID=sa.SubjectID left join assignsubjectteacher a on a.SubjectID=s.SubjectID left join staffregistration st on st.staffRegistrationId=a.staffRegistrationId where sa.AttendanceID='"+attendenceID+"') as StaffName FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join standardmaster st on st.standardId=s.standardId left join streammaster str on str.streamId=s.streamId where s.acadamicYearId='"+yearID+"' and s.branchId='"+branchID+"' and s.standardId='"+standardID+"' and s.streamId='"+streamID+"' and s.status='Approved' and s.admissionRegId not in (SELECT s.admissionRegId FROM studententeryofattendance s where s.StudentPresenty='Absent' and s.AttendanceID=(select max(ss.AttendanceID) as AttendanceID from studententeryofattendance ss )) order by s.admissionRegId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentList=query.list();
		return StudentList;
	}
	
	
}
