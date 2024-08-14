package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.DivisionMasterDaoInterface;
import com.account.model.DivisionMasterModel;
@Repository
public class DivisionMasterDao implements DivisionMasterDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public HashMap<String, String> getStudStdList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfStudentStandard = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT standardId, standard FROM standardmaster");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		System.out.println("listOfStudentStandard"+list);

		for(HashMap map :list){

			mapOfStudentStandard.put( map.get("standardId"),map.get("standard"));

		}
		return mapOfStudentStandard;
	}

	@Override
	public void SaveDivision(DivisionMasterModel divisionMasterModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(divisionMasterModel);
	}

	@Override
	public List<DivisionMasterModel> GetListOfDivision() {
		// TODO Auto-generated method stub
		List<DivisionMasterModel> DivisionList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT d.divisionId, d.diviosin,s.standard,b.branchName,a.streamName FROM collegemgmtsystem.divisionmaster d left join collegemgmtsystem.streammaster a on d.streamId=a.streamId left join collegemgmtsystem.standardmaster s on d.standardId=s.standardId left join collegemgmtsystem.branchmaster b on d.branchId=b.branchId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		DivisionList=query.list();
		
		return DivisionList;
	}

	@Override
	public void UpdateDivision(int divId, String division) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update collegemgmtsystem.divisionmaster d set d.diviosin='"+division+"' where d.divisionId='"+divId+"'");
		query.executeUpdate();
	}

	@Override
	public void deleteDivision(int divId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("delete FROM divisionmaster where divisionId='"+divId+"'");
		query.executeUpdate();
	}
}
