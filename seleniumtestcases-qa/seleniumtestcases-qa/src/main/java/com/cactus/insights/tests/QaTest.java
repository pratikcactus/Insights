package com.cactus.insights.tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.cactus.insights.actions.QaActions;

public class QaTest extends BaseTest {

	private QaActions qaActions;

	@Test
	public void QAVerification() throws MalformedURLException, Exception {
		qaActions = new QaActions(driver, test, wait);
		qaActions.QAPageValidation("Community", "Q&A", "Q&A");
	}

	@Test
	public void QAUnauthenticatedUserVerification() throws MalformedURLException, Exception {
		qaActions = new QaActions(driver, test, wait);
		qaActions.QAUnauthenticatedCheck("Community", "Q&A", "Q&A");
	}

	@Test
	public void QAauthenticatedQuestionPostingVerification() throws MalformedURLException, Exception {
		qaActions = new QaActions(driver, test, wait);
		qaActions.QAauthenticatedUserQuestionCheck("Community", "Q&A", "Q&A");
	}

	@Test
	public void QAanonymousQuestionPostingVerification() throws MalformedURLException, Exception {
		qaActions = new QaActions(driver, test, wait);
		qaActions.QAanonymousdUserQuestionCheck("Community", "Q&A", "Q&A");
	}

	@Test
	public void QAErrorMessageVerification() throws MalformedURLException, Exception {
		qaActions = new QaActions(driver, test, wait);
		qaActions.QAErrorMessageCheck("Community", "Q&A", "Q&A");
	}

	@Test
	public void QAReplyMessageVerification() throws MalformedURLException, Exception {
		qaActions = new QaActions(driver, test, wait);
		qaActions.QAReplyCheck("Community", "Q&A", "Q&A");
	}

	@Test
	public void QAUnauthenticatedReplyMessageVerification() throws MalformedURLException, Exception {
		qaActions = new QaActions(driver, test, wait);
		qaActions.QAUnauthenticatedReplyCheck("Community", "Q&A", "Q&A");
	}

}
