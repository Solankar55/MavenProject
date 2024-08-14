package com.HOD.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.daoInterface.ClassInChargeDaoInterface;
import com.HOD.model.AssignClassInchargeModel;
import com.HOD.model.StaffRegistrationModel;

@Repository
public class ClassInChargeDaoClass implements ClassInChargeDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
	public HashMap<Integer, String> getTeachingStaff() {
		List<StaffRegistrationModel> teachingStaff = new ArrayList<>();
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery("SELECT s.StaffName,s.staffRegistrationId,s.StaffType FROM staffregistration s where s.StaffType='Teaching' and  s.staffstatus='On'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		teachingStaff=query.list();
		
		HashMap<Integer, String> ListOfStaff = new HashMap<>();
		for(int i=0;i<teachingStaff.size();i++){
			
		int StaffId=teachingStaff.get(i).getStaffRegistrationId();
		
		String StaffName=teachingStaff.get(i).getStaffName();
				
			
			ListOfStaff.put(StaffId,StaffName);
			
		}
				
		return ListOfStaff;
	}

	@Override
	public List<String> getDataList(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		List<String> ListData=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AssignClassInchargeId, a.Status FROM assignclassincharge a where a.acadamicYearId='"+yearID+"'and a.branchId='"+branchID+"' and a.standardId='"+standardID+"' and a.streamId='"+streamID+"' ");
		query.setResultTransformer(Transformers.TO_LIST);
		ListData=query.list();
		
		return ListData;
	}

	@Override
	public void saveAssignValue(AssignClassInchargeModel assignClassInchargeModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(assignClassInchargeModel);
	}

	@Override
	public List<String> getAssignInchargeList() {
		// TODO Auto-generated method stub
		
		List<String> AssignInChargeList=new ArrayList<>();
		
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AssignClassInchargeId,a.Status, acyear.acadamicYear,b.branchName,s.StaffName,standard.standard,stream. streamName FROM assignclassincharge a left join acadamicyear acyear on a.acadamicYearId=acyear.acadamicYearId left join branchmaster b on b.branchId=a.branchId left join staffregistration s on s.staffRegistrationId=a.staffRegistrationId left join standardmaster standard on standard.standardId=a.standardId left join streammaster stream on stream.streamId=a.streamId where a.OkOrNot='Complete' and a.Status='Assigned'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		AssignInChargeList=query.list();
		
		return AssignInChargeList;
	}

	@Override
	public String deleteClassInChrage(String elementid) {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("update assignclassincharge a set a.OkOrNot='Delete' where a.AssignClassInchargeId='"+elementid+"'");
		int i=query.executeUpdate();
		String str=null;
		if(i>0)
		{
			 str= "deleted";

		}else
		{
			 str= "not deleted";

		}
		return str;

	}

	@Override
	public void setClassInchargeDisAssignClass(int yearID, int streamID, int branchID, int standardID, int teacherID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update assignclassincharge a set a.status='DisApprove' where a.acadamicYearId='"+yearID+"' and a.branchId='"+branchID+"' and a.staffRegistrationId='"+teacherID+"' and a.standardId='"+standardID+"' and a.streamId='"+streamID+"'");
		query.executeUpdate();
	}

	@Override
	public void updateClassInChargeAssignValue(int yearID, int streamID, int branchID, int standardID, int teacherID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update assignclassincharge a set a.staffRegistrationId='"+teacherID+"' where a.acadamicYearId='"+yearID+"' and  branchId='"+branchID+"' and a.standardId='"+standardID+"' and a.streamId='"+streamID+"'");
		query.executeUpdate();
	}
	
	
}
