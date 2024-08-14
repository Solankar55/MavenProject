package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.StreamMasterDaoInterface;
import com.account.model.StreamMasterModel;
@Repository
public class StreamMasterDao implements StreamMasterDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void SaveStreamMaster(StreamMasterModel streamMasterModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(streamMasterModel);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StreamMasterModel> getStreamList() {
		// TODO Auto-generated method stub
		List<StreamMasterModel> StreamList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from streammaster s where s.strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StreamList=query.list();
		return StreamList;
	}

	@Override
	public HashMap<String, String> SetStream() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfStream = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT str.streamId,str.streamName from streammaster str where str.strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		System.out.println("listOfmasterLedger"+list);

		for(HashMap map :list){

			mapOfStream.put( map.get("streamId"),map.get("streamName"));

		}
		return mapOfStream;
	}

	@Override
	public void UpdateStream(int streamID, String streamName) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update streammaster s set s.streamName='"+streamName+"' where s.streamId='"+streamID+"'");
		query.executeUpdate();
	}

	@Override
	public void DeleteStream(int streamID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update streammaster str set str.strstatus='Off' where streamId='"+streamID+"'");
		query.executeUpdate();
	}

}
