package com.staff.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.model.HODSubjectMasterModel;
import com.staff.daoInterface.AssignmentManagementDaoInterface;

@Repository
public class AssignmentManagementDaoClass implements AssignmentManagementDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getGivenAssignMentList(String SubjectName) {
		// TODO Auto-generated method stub
		List<String> AssignmentList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.AssignmentID, s.AssignmentDate, s.AssignmentMessage, s.AssignmentStatus,a.acadamicYear,b.branchName,stud.studentFirstName,stud.studentLastName,sub.SubjectName,stand.standard,str.streamName FROM studentassignment s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join subjectmasterhod sub on sub.SubjectID=s.SubjectID left join standardmaster stand on stand.standardId=s.standardId left join streammaster str on str.streamId=s.streamId left join studentassignmententeryreport sat on sat.AssignmentID=s.AssignmentID left join studentadmission stud on stud.admissionRegId=sat.admissionRegId where s.AssignmentStatus='Given' and sub.SubjectName='"+SubjectName+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		AssignmentList=query.list();
		return AssignmentList;
	}

	@Override
	public List<String> getRemoveAssignmentList(String subjectName) {
		// TODO Auto-generated method stub
		List<String> AssignmentList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.AssignmentID, s.AssignmentDate, s.AssignmentMessage, s.AssignmentStatus,a.acadamicYear,b.branchName,sub.SubjectName,stand.standard,str.streamName FROM studentassignment s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join subjectmasterhod sub on sub.SubjectID=s.SubjectID left join standardmaster stand on stand.standardId=s.standardId left join streammaster str on str.streamId=s.streamId where s.AssignmentStatus='Remove' and sub.SubjectName='"+subjectName+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		AssignmentList=query.list();
		return AssignmentList;
	}

	@Override
	public String deleteAssignment(int assid) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update studentassignment s set s.AssignmentStatus='Remove' where s.AssignmentID='"+assid+"'");
		int Result=query.executeUpdate();
		String Str=null;
		if(Result==1)
		{
			return Str="Not Deleted";
		}
		else
		{
			return Str="Deleted";
		}
		
	}

	@Override
	public List<HODSubjectMasterModel> GetSubjectList(int staffID) {
		
		List<HODSubjectMasterModel> SubjectList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT sub.SubjectName FROM assignsubjectteacher a left join subjectmasterhod sub on sub.SubjectID=a.SubjectID  where a.staffRegistrationId='"+staffID+"'");
		query.setResultTransformer(Transformers.aliasToBean(HODSubjectMasterModel.class));
		
		SubjectList=query.list();

		
		return SubjectList;
	}

	@Override
	public List<String> getGivenAssignMentListToRemove(String subjectName) {
		// TODO Auto-generated method stub
		List<String> AssignmentList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.AssignmentID, s.AssignmentDate, s.AssignmentMessage, s.AssignmentStatus,a.acadamicYear,b.branchName,stud.studentFirstName,stud.studentLastName,sub.SubjectName,stand.standard,str.streamName FROM studentassignment s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join subjectmasterhod sub on sub.SubjectID=s.SubjectID left join standardmaster stand on stand.standardId=s.standardId left join streammaster str on str.streamId=s.streamId left join studentassignmententeryreport sat on sat.AssignmentID=s.AssignmentID left join studentadmission stud on stud.admissionRegId=sat.admissionRegId where s.AssignmentStatus='Given' and sub.SubjectName='"+subjectName+"' group by s.AssignmentID ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		AssignmentList=query.list();
		return AssignmentList;
	}

}
