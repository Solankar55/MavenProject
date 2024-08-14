package com.HOD.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.daoInterface.SubjectMasterDaoInterface;
import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.admin.model.AdminRegistrationModel;

@Repository
public class SubjectMasterDaoClass implements SubjectMasterDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveSubject(HODSubjectMasterModel hodSubjectMasterModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(hodSubjectMasterModel);
	}

	@Override
	public List<String> getSubjectList() {
		// TODO Auto-generated method stub
		List<String> ListOfSubject=new ArrayList<>();
		
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT s.SubjectID,s.SubjectName,a.acadamicYear,stream.streamName,b.branchName,stand.standard FROM subjectmasterhod s left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		ListOfSubject=query.list();
		
		return ListOfSubject;
	}

	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId,a.acadamicYear FROM acadamicyear a where a.ActiveAcadamicYr='Active' and a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map :list){

			mapOfAcadimicYear.put( map.get("acadamicYearId"),map.get("acadamicYear"));

		}
		return mapOfAcadimicYear;
	}

	@Override
	public HashMap<Integer, String> getTeachingStaff() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfTeachingStaff = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId, s.StaffName FROM staffregistration s where s.StaffType='Teaching' and  s.staffstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map :list){

			mapOfTeachingStaff.put( map.get("staffRegistrationId"),map.get("StaffName"));

		}
		return mapOfTeachingStaff;
	}

	@Override
	public HashMap<String, String> GetStreamList() {
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
	public HashMap<Integer, String> SubjectList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfSubjectList = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.SubjectID, s.SubjectName FROM subjectmasterhod s");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map :list){

			mapOfSubjectList.put( map.get("SubjectID"),map.get("SubjectName"));

		}
		return mapOfSubjectList;
	}

	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from branchmaster b where b.streamid='"+id+"' and b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		
		return BranchList;
	}

	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		List<String> StandardList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM standardmaster s where s.branchId='"+branchid+"' and s.stdstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StandardList=query.list();
		
		return StandardList;
	}

	@Override
	public void saveAssignSunjectValue(AssignSubjectTeacherModel assignSubjectTeacherModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(assignSubjectTeacherModel);
	}

	@Override
	public List<String> getDataList(int yearID, int streamID, int branchID, int teacherID, int standardID,
			int subjectID) {
		// TODO Auto-generated method stub
		List<String> DataList; //a.staffRegistrationId='"+teacherID+"' and
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AssignSubjectTeacherID,a.staffRegistrationId FROM assignsubjectteacher a where a.acadamicYearId='"+yearID+"' and a.branchId='"+branchID+"' and a.SubjectID='"+subjectID+"' and  a.standardId='"+standardID+"' and a.streamId='"+streamID+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		DataList=query.list();
		
		return DataList;
	}

	@Override
	public List<String> getAssignSubjectTeacherList() {
		// TODO Auto-generated method stub
		List<String> DataList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AssignSubjectTeacherID,y.acadamicYear,b.branchName,s.streamName,stand.standard,sub.SubjectName,staff.StaffName,a.StatusToTeacher FROM assignsubjectteacher a left join acadamicyear y on y.acadamicYearId=a.acadamicYearId left join branchmaster b on b.branchId=a.branchId left join streammaster s on s.streamId=a.streamId left join standardmaster stand on stand.standardId=a.standardId left join subjectmasterhod sub on sub.SubjectID=a.SubjectID left join staffregistration staff on staff.staffRegistrationId=a.staffRegistrationId where a.StatusToTeacher='Assign'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		DataList=query.list();
		
		return DataList;
	}

	@Override
	public List<String> getTeacherList(int yearId, int streamId, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> DataList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.SubjectID,s.SubjectName FROM subjectmasterhod s where s.acadamicYearId='"+yearId+"' and s.branchId='"+branchid+"' and s.standardId='"+standardID+"' and s.streamId='"+streamId+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		DataList=query.list();
		
		return DataList;
	}

	@Override
	public void setAssignSubjectToDisAssign(int yearID, int streamID, int branchID, int standardID, int teacherID,
			int subjectID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update assignsubjectteacher a set a.StatusToTeacher='DisAssign' where a.acadamicYearId='"+yearID+"'and a.branchId='"+branchID+"' and a.SubjectID='"+subjectID+"'  and a.staffRegistrationId='"+teacherID+"' and a.standardId='"+standardID+"' and a.streamId='"+streamID+"'");
		query.executeUpdate();
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		List<AdminRegistrationModel> adminList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId,a.Address, a.Date, a.Email, a.MobileNumber, a.Name, a.Password, a.Type,a.Username FROM adminregistration a where a.Username='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
		
		adminList=query.list();
		
		return adminList;
	}

	@Override
	public void updateSubjectAssignVlaue(int yearID, int streamID, int branchID, int standardID, int teacherID,
			int subjectID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update assignsubjectteacher a set a.staffRegistrationId='"+teacherID+"' where a.acadamicYearId='"+yearID+"' and a.branchId='"+branchID+"' and a.SubjectID='"+subjectID+"' and a.standardId='"+standardID+"' and a.streamId='"+streamID+"'");
		query.executeUpdate();
	}


	
}
