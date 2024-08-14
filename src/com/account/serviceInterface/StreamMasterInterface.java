package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.StreamMasterModel;

public interface StreamMasterInterface {

	void AddStream(StreamMasterModel streamMasterModel);

	List<StreamMasterModel> GetStream();

	HashMap<String, String> SetStream();

	void UpdateStream(int streamID, String streamName);

	void DeleteStream(int streamID);

}
