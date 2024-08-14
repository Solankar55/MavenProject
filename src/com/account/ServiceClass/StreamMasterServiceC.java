package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.StreamMasterDaoInterface;
import com.account.model.StreamMasterModel;
import com.account.serviceInterface.StreamMasterInterface;
@Service
public class StreamMasterServiceC implements StreamMasterInterface{

	@Autowired
	private StreamMasterDaoInterface streamMasterDaoInterface;
	
	@Transactional
	@Override
	public void AddStream(StreamMasterModel streamMasterModel) {
		// TODO Auto-generated method stub
		streamMasterDaoInterface.SaveStreamMaster(streamMasterModel);
	}

	public StreamMasterDaoInterface getStreamMasterDaoInterface() {
		return streamMasterDaoInterface;
	}

	public void setStreamMasterDaoInterface(StreamMasterDaoInterface streamMasterDaoInterface) {
		this.streamMasterDaoInterface = streamMasterDaoInterface;
	}

	@Transactional
	@Override
	public List<StreamMasterModel> GetStream() {
		// TODO Auto-generated method stub
		return streamMasterDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public HashMap<String, String> SetStream() {
		// TODO Auto-generated method stub
		return streamMasterDaoInterface.SetStream();
	}

	@Transactional
	@Override
	public void UpdateStream(int streamID, String streamName) {
		// TODO Auto-generated method stub
		streamMasterDaoInterface.UpdateStream(streamID,streamName);
	}

	@Transactional
	@Override
	public void DeleteStream(int streamID) {
		// TODO Auto-generated method stub
		streamMasterDaoInterface.DeleteStream(streamID);
	}

}
