package com.cactus.crm.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class PaymentPreferencesSection extends AddEnquiryPage {
	WebElement field_partner_specific_invoicetemplate;

	@FindBy(xpath = "//*[@name='psit-payment-instruction']")

	WebElement paymentInstructions;

	@FindBy(xpath = ".//button[contains(@class,'psit-new-preference')]")
	WebElement newPreferenceButton;

	@FindBy(xpath = ".//button[contains(@class,'psit-previous-submission')]")
	WebElement previousPreferenceButton;


	@FindBy(xpath = "//*[@id='field_psit_cn_inv_tax_certn']//input[@type='file']")
	WebElement VatTaxAppCertificationFiles;

	@FindBy(xpath = ".//*[@id='field_psit_cn_inv_tax_reg_certn']//input[@type='file']")
	WebElement VatTaxGenRegCertificationFiles;

	By byPayerName = By.xpath(".//input[@id='field_psit_payer_name']");

	By byCnpjNumber = By.xpath(".//input[contains(@id,'cnpj_number')]");

	By byCpfNumber = By.xpath(".//input[contains(@id,'cpf_number')]");

	By byCompanyName = By.xpath(".//*[@id='psit-questions']//input[contains(@id,'tic_cpny_nm')]");

	By byBussinessRegName = By.xpath(".//*[@id='psit-questions']//input[contains(@id,'tic_rep_nm')]");


	By byInvoiceName = By.xpath("//input[contains(@id,'field_psit')]");
	// By byInvoiceName=By.xpath("//input[contains(@id,'invoice_name')]");


	By byBussinessRegNo = By.xpath(".//*[@id='psit-questions']//input[contains(@id,'tic_reg_brn')]");

	By byBrnNo = By.xpath(".//*[@id='psit-questions']//input[contains(@id,'brn_no')]");

	By byTicrCellPhnNo = By.xpath(".//*[@id='psit-questions']//input[contains(@id,'ticr_cell_phn_no_number')]");


	By byChineseName = By.xpath(".//input[contains(@id,'chinese_name')]");

	By byVatNo = By.xpath(".//input[contains(@id,'vat_no')]");

	By byPaymentInstructions = By.xpath("//*[@name='psit-payment-instruction']");

	By byInvDesc = By.xpath(".//select[@id='field_psit_cn_inv_gen_desc']");
	By byInvCourierAdd = By
			.xpath(".//*[@name='field_psit_cn_inv_gen_cour_add']");
	By byTypeOfOrg = By.xpath(".//select[@id='field_psit_cn_org_type']");
	By byOrgTaxNumber = By.xpath(".//*[@id='field_psit_cn_org_tax_no']");
	By byCustomerAdd = By.xpath(".//*[@name='field_psit_cn_inv_cus_add']");
	By byTelephoneNumber = By
			.xpath(".//*[@name='field_psit_cn_inv_phone_num']");
	By byTaxRegNumberAndCode = By
			.xpath(".//*[@name='field_psit_cn_inv_tax_num_code']");
	By byBankName = By.xpath(".//*[@name='field_psit_cn_inv_bank_nm']");
	By byAccountNumber = By.xpath(".//*[@name='field_psit_cn_inv_act_num']");
	By byVatApprovalCert = By
			.xpath("//*[@id='field_psit_cn_inv_tax_reg_certn']//input[@type='file']");
	By byVatRegistrationCert = By
			.xpath("//*[@id='field_psit_cn_inv_tax_certn']//input[@type='file']");
	By byFileUploadLoader = By
			.xpath(".//*[@class='qq-upload-spinner-selector qq-upload-spinner']");

	// ------------------//

	public PaymentPreferencesSection(WebDriver driver, WebDriverWait wait,
			ExtentTest test) {
		super(driver, wait, test);
		PageFactory.initElements(driver, this);

		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
	}

	public void enterPaymentPreferencesExistingUser(Map<String, String> testData) {
		/*executor.softWaitforElementToBeClickable(newPreferenceButton, "Element newPreferenceButton to be clickable");
		executor.softWaitforElementToBeClickable(previousPreferenceButton,
				"Element previousPreferenceButton to be clickable");*/
		executor.pause(1);
		if (testData.get("newPaymentPreference").equalsIgnoreCase("yes")
				|| testData.get("newPaymentPreference") == null) {
			executor.softWaitforElementToBeClickable(newPreferenceButton, "Element newPreferenceButton to be clickable");
			executor.actionClick(newPreferenceButton, "Click on New Payment Preference");
			enterPaymentPreferences(testData);
		} else {
			executor.softWaitforElementToBeClickable(previousPreferenceButton,
					"Element previousPreferenceButton to be clickable");
			executor.click(previousPreferenceButton, "Click on New Payment Preference");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

	}

	public void enterPaymentPreferences(Map<String, String> testData) {

		if (testData.get("TypeOfInvoice").contains(" (Monthly)")) {
			String type = testData.get("TypeOfInvoice").replace(" (Monthly)",
					"");
			testData.put("TypeOfInvoice", type);
		}
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
				"Invisibility of spinner");
		executor.moveToElement(field_partner_specific_invoicetemplate);
		executor.selectFromDropDown(field_partner_specific_invoicetemplate, "visbibleText",
				testData.get("TypeOfInvoice"));

		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
				"Invisibility of spinner");
		if (executor.isElementPresent(byPayerName)) {
			executor.softWaitforElementToBeClickable(byPayerName,
					"Payername is clickable");
			executor.sendkeys(byPayerName, testData.get("PayerName"),
					"PayerName");
		}
		if (executor.isElementPresent(byInvoiceName))
			executor.sendkeys(byInvoiceName, testData.get("NameOnInvoice"),
					"Entered Name on invoice  : ");

		if (executor.isElementPresent(byCpfNumber)) {
			executor.sendkeys(byCpfNumber, testData.get("CPFNumber"),
					"cpfNumber");
		}

		if (executor.isElementPresent(byCnpjNumber)) {
			executor.sendkeys(byCnpjNumber, testData.get("CNPJNumber"),
					"CNPJNumber");
		}

		if (executor.isElementPresent(byVatNo)) {
			executor.sendkeys(byVatNo, testData.get("VatNo"), "vatNo");
		}

		if (executor.isElementPresent(byChineseName)) {
			executor.sendkeys(byChineseName, testData.get("ChineseName"),
					"chineseName");
		}

		if (executor.isElementPresent(byTicrCellPhnNo)) {
			executor.sendkeys(byTicrCellPhnNo, testData.get("PhoneNumber"),
					"Korea ticrCellPhnNo");
		}

		if (executor.isElementPresent(byBrnNo)) {
			executor.sendkeys(byBrnNo, testData.get("BRN"), "Korea brnNo");
		}

		if (executor.isElementPresent(byBussinessRegNo)) {
			executor.sendkeys(byBussinessRegNo, testData.get("BRN"),
					"Korea bussinessRegNo");
		}

		if (executor.isElementPresent(byBussinessRegName)) {
			executor.sendkeys(byBussinessRegName, "TestName",
					"Korea bussinessRegName");
		}

		if (executor.isElementPresent(byCompanyName)) {
			executor.sendkeys(byCompanyName, "Test Company",
					"Korea companyName");
		}
		if (executor.isElementPresent(byInvDesc)) {
			executor.sendkeys(byInvDesc, testData.get("InvoiceDescription"),
					"Invoice Description");
		}
		if (executor.isElementPresent(byInvCourierAdd)) {
			executor.sendkeys(byInvCourierAdd,
					"House no.786,Baker Road Beijing",
					"Invoice Courier Description");
		}
		if (executor.isElementPresent(byTypeOfOrg)) {
			executor.sendkeys(byTypeOfOrg, testData.get("TypeOfOrganization"),
					"Type Of Organization");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}
		if (executor.isElementPresent(byOrgTaxNumber)) {
			executor.softWaitforElementToBeClickable(byOrgTaxNumber, "Element byOrgTaxNumber to be clickable");
			executor.sendkeys(byOrgTaxNumber, "741644",
					"Organization tax Number");
		}
		if (executor.isElementPresent(byCustomerAdd)) {
			executor.sendkeys(byCustomerAdd,
					"Eco Park 1102,Andheri East Mumbai", "Customer Address");
		}
		if (executor.isElementPresent(byTelephoneNumber)) {
			executor.sendkeys(byTelephoneNumber, "8121539106",
					"Telephone Number");
		}
		if (executor.isElementPresent(byTaxRegNumberAndCode)) {
			executor.sendkeys(byTaxRegNumberAndCode, "REG-00987",
					"Tax Registration Number/Code");
		}
		if (executor.isElementPresent(byBankName)) {
			executor.sendkeys(byBankName, "Standard Chartered", "Bank Name");
		}
		if (executor.isElementPresent(byAccountNumber)) {
			executor.sendkeys(byAccountNumber, "001276557", "Account Number");

		}
		if (executor.isElementPresent(byVatApprovalCert)) {
			selectUploadFiles(testData.get("UploadJobFiles"),
					VatTaxAppCertificationFiles);
		}
		if (executor.isElementPresent(byVatRegistrationCert)) {
			selectUploadFiles(testData.get("UploadJobFiles"),
					VatTaxGenRegCertificationFiles);
		}
		if (executor.isElementPresent(byPaymentInstructions)) {
			executor.moveToElement(byPaymentInstructions);
			executor.softWaitforElementToBeClickable(paymentInstructions, "Element to be clickable paymentInstructions");
			executor.sendkeys(paymentInstructions, testData.get("PaymentInstructions"), "Enter Payment instructions.");
		}
	}

	public void enterExistingClientPaymentPreferences(
			Map<String, String> testData) {
		if (testData.get("InvoicePreferences").contains("new")) {
			executor.click(newPreferenceButton,
					"click on New Preference Button");
			enterPaymentPreferences(testData);
		} else {
			executor.click(previousPreferenceButton,
					"click on previous Preference Button");
		}

	}

	public void selectUploadFiles(String uploadFile, WebElement element) {

		String[] uploadJobFiles = uploadFile.split(";");

		//int jobFilesExp = uploadJobFiles.length;
		for (int i = 0; i < 1; i++) {
			String filepath = util.getFileAbolutePath(uploadJobFiles[i]);
			executor.fileUploadBySendkeys(element, filepath, "jobFiles");
			executor.softWaitforCondition(ExpectedConditions
					.invisibilityOfElementLocated(byFileUploadLoader),
					"Invisibility of File Loader");
		}

		executor.softWaitforCondition(ExpectedConditions
				.invisibilityOfElementLocated(byFileUploadLoader),
				"Invisibility of File Loader");
	}

}
