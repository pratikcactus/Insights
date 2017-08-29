package com.cactus.editage.tests;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cactus.inits.InitTest;

public class BaseTest extends InitTest {
	
	@Parameters({ "testType", "market" })
	@BeforeMethod
	public void setupEditage(@Optional("ecf") String testType, @Optional("ENG") String market){
		testURL = util.getTestURL(testType, market, configMap);
		executor.navigateToURL(testURL);

		configMap.put("market", market);
		//partnerMap = dbUtil.getPartnerMap(configMap.get("TestEnvironment"));
		//serviceMap = dbUtil.getServiceMap(configMap.get("TestEnvironment"));
		//salutationTypeMap = dbUtil.getFieldSalutationTypeMap(configMap.get("TestEnvironment"));

	}
}
