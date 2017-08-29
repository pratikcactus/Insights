package com.cactus.utils;


import java.util.HashMap;
import java.util.Map;

public class DataMapUtil {

	public Map<String, String> getFLMap(Map<String, String> testData){
		Map<String,String> flMap =new HashMap<String,String>();
		
		flMap.put("Flag", testData.get("Flag"));
		flMap.put("PMId", testData.get("PMId"));
		flMap.put("PMPassword", testData.get("PMPassword"));
		flMap.put("CMId", testData.get("CMId"));
		flMap.put("CMPassword", testData.get("CMPassword"));
		flMap.put("ClientCode", testData.get("ClientCode"));
		flMap.put("ClientEmail", testData.get("ClientEmail"));
		flMap.put("Resource", testData.get("Resource"));
		flMap.put("FLPassword", testData.get("FLPassword"));
		flMap.put("EnquiryCode", testData.get("EnquiryCode"));
		flMap.put("JobCode", testData.get("JobCode"));
		flMap.put("UploadFiles", testData.get("UploadFiles"));
		flMap.put("ForceToSubmitReason", "Covering letter not uploaded: not relevant");
		flMap.put("testEnv", testData.get("testEnv"));
		flMap.put("status", testData.get("status"));
		flMap.put("JobToBeDeliveredBy", testData.get("JobToBeDeliveredBy"));
		flMap.put("EnquiryType",  testData.get("EnquiryType"));
		return flMap;
	}
	

	public Map<String, String> getEnqMap(Map<String, String> testData){
		Map<String,String> enqMap =new HashMap<String,String>();
		
		enqMap.put("Flag", testData.get("Flag"));
		enqMap.put("LoginID", testData.get("LoginID"));
		enqMap.put("LoginPassword", testData.get("LoginPassword"));
		
		enqMap.put("ClientCode", testData.get("ClientCode"));
		enqMap.put("ClientEmail", testData.get("ClientEmail"));
		
		enqMap.put("EnquiryCode", testData.get("EnquiryCode"));
		enqMap.put("UploadFiles", testData.get("UploadFiles"));
		enqMap.put("testEnv", testData.get("testEnv"));
		enqMap.put("status", testData.get("status"));
		enqMap.put("JobToBeDeliveredBy", testData.get("JobToBeDeliveredBy"));
		enqMap.put("EnquiryType",  testData.get("EnquiryType"));
		return enqMap;
	}

	
}
