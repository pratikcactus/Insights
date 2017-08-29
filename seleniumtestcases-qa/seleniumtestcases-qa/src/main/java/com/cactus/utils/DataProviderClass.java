package com.cactus.utils;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;


import com.cactus.inits.InitTest;

public class DataProviderClass {

	@DataProvider // (parallel=true)
	public Object[][] newEnquiryData() {
		return new ExcelUtil().getUserDataFromExcel("testData_CRM_Set1.xlsx", "NewEnqData");
	}

	@DataProvider // (parallel=true)
	public Object[][] existingEnquiryData() {
		return new ExcelUtil().getUserDataFromExcel("testData_CRM_Set1.xlsx", "ExistingEnqData");
	}

	@DataProvider // (parallel=true)
	public Object[][] editPMAndCMData() {
		return new ExcelUtil().getUserDataFromExcel("testData_CRM_Set1.xlsx", "EditCMPM");
	}

	@DataProvider // (parallel=true)
	public Object[][] enquiryClientData() {
		return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "EnqData");
	}

	@DataProvider(name = "enquiryDataAll")
	public Object[][] enquiryDataAll(ITestContext context) {
		String market = context.getCurrentXmlTest().getParameter("Market");
		String dataSet = context.getCurrentXmlTest().getParameter("DataSet");

		if (context.getCurrentXmlTest().getParameter("DataSet") == null
				|| context.getCurrentXmlTest().getParameter("DataSet").equalsIgnoreCase("")) {
			dataSet = InitTest.getConfigMap().get("Dataset");
			;
		}

		if (dataSet != null && dataSet.equalsIgnoreCase("Upload")) {
			return new ExcelUtil().getUserDataFromExcel("testDataUpload.xlsx", "Job");
		} else if (dataSet != null && dataSet.equalsIgnoreCase("Custom")) {
			return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "Custom");
		} else {
			if (market.equalsIgnoreCase("JPN")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "JPN");
			} else if (market.equalsIgnoreCase("TWN")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "TWN");
			} else if (market.equalsIgnoreCase("CRPEN")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "CRPEN");
			} else if (market.equalsIgnoreCase("CRPJP")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "CRPJP");
			} else if (market.equalsIgnoreCase("KOR")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "KOR");
			} else if (market.equalsIgnoreCase("BRZ")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "BRZ");
			} else if (market.equalsIgnoreCase("KINO")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "KINO");
			} else if (market.equalsIgnoreCase("BSKO")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "BSKO");
			} else if (market.equalsIgnoreCase("KUP")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "KUP");
			} else if (market.equalsIgnoreCase("CHN")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "CHN");
			} else if (market.equalsIgnoreCase("ENG")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "ENG");
			} else if (market.equalsIgnoreCase("ENGIN")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "ENGIN");
			} else if (market.equalsIgnoreCase("GER")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "GER");
			} else if (market.equalsIgnoreCase("OSA")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "OSA");
			} else if (market.equalsIgnoreCase("IND")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "IND");
			} else if (market.equalsIgnoreCase("BRL")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "BRL");
			} else if (market.equalsIgnoreCase("WKH")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "WKH");
			} else if (market.equalsIgnoreCase("HDW")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "HDW");
			} else if (market.equalsIgnoreCase("NMO")) {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "NMO");
			} else {
				return new ExcelUtil().getUserDataFromExcel("testData_CRM.xlsx", "JPN");
			}
		}

	}
}
