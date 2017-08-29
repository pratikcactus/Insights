package com.cactus.insights.tests;

import org.testng.annotations.BeforeMethod;

import com.cactus.inits.Config;
import com.cactus.inits.InitTest;

public class BaseTest extends InitTest {
	
	//@Parameters({ "testType", "market" })
	//Row Test Client Site
	@BeforeMethod
	public void setupEditage(){
		testURL = Config.insightURL;			
		executor.navigateToURL(testURL);

		//configMap.put("market", market);
		//partnerMap = dbUtil.getPartnerMap(configMap.get("TestEnvironment"));
		//serviceMap = dbUtil.getServiceMap(configMap.get("TestEnvironment"));
		//salutationTypeMap = dbUtil.getFieldSalutationTypeMap(configMap.get("TestEnvironment"));

	}
}
