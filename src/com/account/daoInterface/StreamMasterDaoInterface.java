package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.StreamMasterModel;

public interface StreamMasterDaoInterface {

	void SaveStreamMaster(StreamMasterModel streamMasterModel);

	List<StreamMasterModel> getStreamList();

	HashMap<String, String> SetStream();

	void UpdateStream(int streamID, String streamName);

	void DeleteStream(int streamID);

}
