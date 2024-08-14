package com.AcademicMaster.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.AcademicMaster.daoInterface.ParentYearDepartmentDaoInterface;
import com.AcademicMaster.model.ParentMessageEntryModel;
import com.AcademicMaster.model.ParentMessageModel;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

@Repository
public class ParentYearDepartmentDaoClass implements ParentYearDepartmentDaoInterface {

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
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapToYear=new HashMap();
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM acadamicyear a where a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map:list)
		{
			mapToYear.put(map.get("acadamicYearId"), map.get("acadamicYear"));
		}
		return mapToYear;
	}

	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		List<HashMap> Streamlist=new ArrayList<>();
		HashMap mapOfStream = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("Select s.streamId, s.streamName FROM streammaster s where s.strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Streamlist=query.list();
		
		for(HashMap map :Streamlist){

			mapOfStream.put( map.get("streamId"),map.get("streamName"));

		}
		return mapOfStream;
	}

	@Override
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from branchmaster b where b.streamid='"+id+"' and b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		
		return BranchList;
	}

	@Override
	public List<String> GetStamdardList(int branchid) {
		// TODO Auto-generated method stub
		List<String> StandardList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM standardmaster s where s.branchId='"+branchid+"' and s.stdstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StandardList=query.list();
		
		return StandardList;
	}

	@Override
	public List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> StudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber,s.fatherFirstName,s.fatherLastName,s.fatherEmail,s.fatherContactNumber,s.studentFirstName, s.studentLastName,stream.streamName,b.branchName,stand.standard,a.acadamicYear FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamid+"' and s.branchId='"+branchid+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+yearId+"' and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public void saveParentMessageModel(ParentMessageModel parentMessageModel) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(parentMessageModel);
		
	}

	@Override
	public int getMaxParentID() {
		// TODO Auto-generated method stub
		
		List getMaxIDList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT  max(p.parentMessageID) as parentMessageID FROM parentmessagemodel p");
		getMaxIDList=query.list();
		
		int maxID=0;
		
		if(getMaxIDList.get(0)==null)
		{
			return maxID+1;
		}
		else
		{
			return maxID=(int)getMaxIDList.get(0);
		}
	
	}

	@Override
	public void saveParentMessageEntryModel(ParentMessageEntryModel parentMessageEntryModel) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(parentMessageEntryModel);
		
	}

	@Override
	public List<StudentAdmissionModel> getStudentContactN(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.fatherContactNumber FROM studentadmission s where s.admissionRegId='"+studID+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		
		List<StudentAdmissionModel> Stud;
		Stud=query.list();
		return Stud;
	}
	
	
}
