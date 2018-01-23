package com.cactus.insights.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

import com.cactus.inits.Config;
import com.cactus.inits.InitTest;

public class BaseTest extends InitTest {
	
	//@Parameters({ "testType", "market" })
	//Row Test Client Site
	@BeforeMethod
	public void setupEditage(){
		testURL = util.getTestURL(configMap);			
		executor.navigateToURL(testURL);
		
		//configMap.put("market", market);
		//partnerMap = dbUtil.getPartnerMap(configMap.get("TestEnvironment"));
		//serviceMap = dbUtil.getServiceMap(configMap.get("TestEnvironment"));
		//salutationTypeMap = dbUtil.getFieldSalutationTypeMap(configMap.get("TestEnvironment"));

	}
}
