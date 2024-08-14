package com.administrator.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.administrator.daoInterface.AdministratorDaoInterface;
@Repository
public class AdministratorDaoC implements AdministratorDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveNewAuthorisedUser(AdminRegistrationModel adminRegistrationModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(adminRegistrationModel);
	}

	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM collegemgmtsystem.acadamicyear a");
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
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("Select s.streamId, s.streamName FROM collegemgmtsystem.streammaster s");
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
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from collegemgmtsystem.branchmaster b where b.streamid='"+id+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		
		return BranchList;
	}

	@Override
	public List<String> getStandardlist(int branchid) {
		// TODO Auto-generated method stub
		List<String> StandardList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM collegemgmtsystem.standardmaster s where s.branchId='"+branchid+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StandardList=query.list();
		
		return StandardList;
	}

	@Override
	public List<String> getStandardWiseReport(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> StudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber, s.studentFirstName, s.studentLastName,stream.streamName,b.branchName,stand.standard,a.acadamicYear FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamid+"' and s.branchId='"+branchid+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+yearId+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentList=query.list();
		
		return StudentList;
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
	public List<String> getUserNameCheck(String userName) {
		
		List<String> list=new ArrayList<>();
		List<String> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		List<String> list3=new ArrayList<>();
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId FROM adminregistration a where a.Username='"+userName+"'");
		list1=query.list();
		list.addAll(list1);
		
		SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId FROM staffregistration s where s.UserName='"+userName+"'");
		list2=query2.list();
		list.addAll(list2);
		
		SQLQuery query3=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StudentRegistrationId FROM studentregistration s where s.StudentUserName='"+userName+"'");
		list3=query3.list();
		list.addAll(list3);
		
		return list;
	}
	
	
}
