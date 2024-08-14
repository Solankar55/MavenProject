package com.account.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.StandardMasterDaoInterface;
import com.account.model.StandardMasterModel;

@Repository
public class StandardMasterDao implements StandardMasterDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void SaveStandard(StandardMasterModel standardMasterModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(standardMasterModel);
	}

	@Override
	public List<StandardMasterModel> GetListOfStandard() {
		// TODO Auto-generated method stub
		List<StandardMasterModel> StandardList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.standardId,s.standard,b.branchName,a.streamName FROM standardmaster s left join branchmaster b on s.branchId=b.branchId left join streammaster a on s.streamId=a.streamId where s.stdstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StandardList=query.list();
		return StandardList;
	}

	@Override
	public void UpdateStandard(int stndardID, String standard) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update standardmaster s set s.standard='"+standard+"' where s.standardId='"+stndardID+"'");
		query.executeUpdate();
	}

	@Override
	public void deleteStandard(int stndardID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update standardmaster std set std.stdstatus='Off' where std.standardId='"+stndardID+"'");
		query.executeUpdate();
	}

}
