package com.stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.Toolkit;

import java.awt.datatransfer.StringSelection;

import java.awt.event.KeyEvent;
import org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyAgreementSpi.ECVKO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.base;
import com.hooks.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends base {
	private hooks hook;
	private String filePath = projectPath + "\\FileStorage\\Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";
	private String fileupload = projectPath + "\\FileStorage\\Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";
	private Scenario scenario;
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;

	}
	/*
	 * @After public void quitDriver() throws InterruptedException { if (driver !=
	 * null) { TimeUnit.SECONDS.sleep(5); driver.quit(); } }
	 */

	@Given("Launch the url in Chrome")
	public void launch_the_url_in_chrome() throws IOException {
		initializeDriver();

		driver.get(properties.getProperty("url"));
		PageFactory.initElements(driver, hooks.class);
	}

	@Given("Click on use B2C button")
	public void click_on_use_b2c_button() {
		clickElement(b2c);
	}

	@Then("Enter the credentials and click the signin button")
	public void enter_the_credentials_and_click_the_signin_button() {
		sendKeysToElement(email, properties.getProperty("username"));
		sendKeysToElement(password, properties.getProperty("password"));
		clickElement(sigin);
	}


	@Given("Ckick on start case")
	public void ckick_on_start_case() {
		clickElement(startCase);
	}

	@Then("Select court type")
	public void select_court_type() {
		clickElement(CourtType);
		clickElement(MagistratesCourt);
	}

	@Then("Select the case type")
	public void select_the_case_type() throws InterruptedException {
		clickElement(CaseType);  // Click on CaseType element

		if(scenario.getSourceTagNames().contains( "@MagistratesCourtStartACase"))
			clickElement(ClaimCase);
		else if (scenario.getSourceTagNames().contains( "@Originatingapplication"))
			clickElement(OriginatingApp);
		sleep(5);
		clickElement(Proceed);
	}

	@Then("Slect the form type")
	public void slect_the_form_type() {
		clickElement(FormTypedropdown);
		clickElement(GuidedForm);
		clickElement(Proceed);

	}

	@Then("Select next on the Checklist page")
	public void select_next_on_the_checklist_page() {
		clickElement(ChecklistNext);
	}

	@When("Provide Claim information")
	public void provide_claim_information() {
		clickElement(creditcardcheckbox);
		clickElement(YES1);
		clickElement(No2);
		sendKeysToElement(Fromdate, ("2023-08-15"));
		Fromdate.sendKeys(Keys.TAB);
		sendKeysToElement(Fromdate, ("2023"));
		sendKeysToElement(TODate, ("2023-08-15"));
		TODate.sendKeys(Keys.TAB);
		sendKeysToElement(TODate, ("2023"));
		sendKeysToElement(Suburb,("Sunny Banks"));
	}

	@Then("Enter the amount and interest claiming")
	public void enter_the_amount_and_interest_claiming() {
		sendKeysToElement(claiming1,("200"));
		sendKeysToElement(claiming2,("200"));
	}

	@Then("select No on claim any other costs and click on next")
	public void select_no_on_claim_any_other_costs_and_click_on_next() {
		clickElement(Yes3);
		clickElement(No4);
		clickElement(next);
	}
	@When("select yes on  claim settled by Counsel and Enter one fact for claim")
	public void select_yes_on_claim_settled_by_counsel_and_enter_one_fact_for_claim() {
		clickElement(No);
		sendKeysToElement(ClaimPact,("Test Pact"));
		clickElement(next);
	}

	@Then("Enter  relief being claimed and click on next")
	public void enter_relief_being_claimed_and_click_on_next() {
		sendKeysToElement(ClaimPact,("Test Pact"));
		clickElement(next);   
	}
	@Then("select yes on Plaintiff legally represented and provide the Plaintiff infomartion")
	public void select_yes_on_plaintiff_legally_represented_and_provide_the_plaintiff_infomartion() {
		clickElement(YES1);
		clickElement(YES2);
		sendKeysToElement(Incapacity,("100"));
		clickElement(Individual);
		clickElement(Individual);
		sendKeysToElement(LPFname,("Dan"));
		sendKeysToElement(LPLname,("Humphrey"));
		sendKeysToElement(Serachaddress1,("red"));
		clickElement(Searchicon2);
		clickElement(AddressA);
		sendKeysToElement(Email1,("TEst11@auto.mation"));
		sendKeysToElement(plaintifPHNO,("9911223344"));

		sendKeysToElement(LPFirstname,("Chuck "));
		sendKeysToElement(LPlastname,("Bass"));
		sendKeysToElement(Serachaddress2,("red"));
		clickElement(Searchicon3);
		clickElement(AddressB);
		sendKeysToElement(Email2,("TData11@auto.mation"));
		sendKeysToElement(PractitionerPhNo,("9911998844"));
		clickElement(Yes3);
		clickElement(next);
	}
	@But ("Select yes on the defendant sued and provide defendant details")
	public void select_yes_on_the_defendant_sued_and_provide_defendant_details() throws InterruptedException {
		clickElement(YES1);
		sendKeysToElement(Incapacity,("1000"));
		clickElement(Individual);
		sendKeysToElement(DefName,("serena "));
		sendKeysToElement(DeLName,("van der woodsen"));
		sendKeysToElement(DefAddressSearch,("red"));
		clickElement(Searchicon2);
		clickElement(AddressA);
		sleep(5);
		clickElement(next);

	}
	@Then("Select the heard Magistrates Court")
	public void select_the_heard_magistrates_court() {
		clickElement(heardingcourt);
		clickElement(heardingcourtop1);
		clickElement(next);
	}

	@When("review the cost and click on next")
	public void review_the_cost_and_click_on_next() {
		clickElement(next);
	}

	@When("Click on review the application and submit")
	public void click_on_review_the_application_and_submit() {
		clickElement(Reviewapplication);
		clickElement(Submit);
		clickElement(Ok);
	}
	@Given("click next button on the about you")
	public void click_next_button_on_the_about_you() {
		clickElement(AboutYouNo);
		clickElement(next);
	}

	@Given("provide the requirements for originating application page")
	public void provide_the_requirements_for_originating_application_page() throws InterruptedException {

		clickElement(selectorigiapp);
		clickElement(birth);
		clickElement(No);
		clickElement(next);

	}

	@Given("select the applicant type provide the  Applicant information")
	public void select_the_applicant_type_provide_the_applicant_information() throws InterruptedException {
		clickElement(YES1);
		clickElement(Individual);
		sleep(2);
		sendKeysToElement(firstname, "Thor");
		sendKeysToElement(lastname, "odinson");
		sendKeysToElement(Serachaddress1,("red"));
		clickElement(Searchicon2);
		clickElement(AddressA);
		sendKeysToElement(mail,("TEst11@auto.mation"));
		sendKeysToElement(phnumber,("9911223344"));


		sendKeysToElement(LPeFname,("Chuck "));
		sendKeysToElement(LPeLname,("Bass"));
		sendKeysToElement(Serachaddress2,("red"));
		clickElement(Searchicon3);
		clickElement(AddressB);
		sendKeysToElement(Email2,("TData11@auto.mation"));
		sendKeysToElement(PetitionerPhNo,("9911998844"));
		clickElement(YES2);
		clickElement(next);

	}

	@Given("select the party type and provide the respondent information")
	public void select_the_party_type_and_provide_the_respondent_information() throws InterruptedException {
		clickElement(Individual);
		sleep(2);
		sendKeysToElement(firstname, "Thor");
		sendKeysToElement(lastname, "odinson");
		sendKeysToElement(respondentaddress, "red");
		clickElement(Searchicon2);
		clickElement(AddressC);
		sleep(5);
		clickElement(next);

	}

	@Then("select the court location and upload the document and click review button")
	public void select_the_court_location_and_upload_the_document_and_click_review_button() throws InterruptedException, AWTException {
		clickElement(courtlocation);
		clickElement(courtinul);
		sleep(2);
		clickElement(form5);
		Robot robot = new Robot();


		StringSelection stringSelection = new StringSelection(fileupload);
		sleep(3);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);


		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		sleep(3);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);


		clickElement(reviewapp);


	}

	@Then("click submit button and click ok button and click pay later button")
	public void click_submit_button_and_click_ok_button_and_click_pay_later_button() throws InterruptedException {
		clickElement(submit);
		sleep(20);
		clickElement(ok);

	}

	@Given("click join a case tab and enter LodNumber and click search button")
	public void click_join_a_case_tab_and_enter_lod_number_and_click_search_button() throws InterruptedException {
		clickElement(joinacase);
		sendKeysToElement(joinacasesearch, "Q117-24");
		clickElement(searchbutton);
		sleep(3);
	}
	@Given("click select button and click are you already a party or not")
	public void click_select_button_and_click_are_you_already_a_party_or_not() throws InterruptedException {
		clickElement(actionselect);
		if(scenario.getSourceTagNames().contains("@JoinACaseApplicant")||scenario.getSourceTagNames().contains("@JoinACaseDefantant"))
		{
			clickElement(YES1);
		}
		else {
			
			clickElement(noforjoincase);
		}
		sleep(3);
	}

	@Given("select the document type and form type")
	public void select_the_document_type_and_form_type() throws InterruptedException {
		if(scenario.getSourceTagNames().contains("@JoinACaseQCAT"))
		{
			clickElement(doctypejoincase);
			clickElement(Qcatform);
			sleep(3);
		}
		else if(scenario.getSourceTagNames().contains("@JoinACaseForm45"))
		{
			clickElement(doctypejoincase);
			clickElement(Form45form);
			sleep(3);
		}

	}

	@Given("select parties in address for service page")
	public void select_parties_in_address_for_service_page() throws InterruptedException {
		clickElement(creditcardcheckbox);
	}

	@Given("upload affidavit for address for service page")
	public void upload_affidavit_for_address_for_service_page() throws AWTException, InterruptedException {
		clickElement(uploadaffidavit);
		Robot rb = new Robot();

		StringSelection stringSelection = new StringSelection(fileupload);
		sleep(3);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		sleep(3);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);   
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	@Given("provide address for address for service page and click review application button")
	public void provide_address_for_address_for_service_page_and_click_review_application_button() throws InterruptedException {
		sendKeysToElement(Addresslookupjoinacase, "red");
		clickElement(Addresslookupjoinacaseicon);
		clickElement(AddressforQCATCaseaccessrequest);
		clickElement(reviewapplicationforqcatajc);
		clickElement(submitforjoinacase);
		sleep(10);
		clickElement(okforjoinacase);
		sleep(10);
	}
	@Given("select the role and provide the address")
	public void select_the_role_and_provide_the_address() throws InterruptedException {
		clickElement(Applicantforjoinacase);
		sendKeysToElement(textareajoinacase, "text for testing");
		clickElement(Individual);
		sendKeysToElement(LPFname, "Thor");
		sendKeysToElement(LPLname, "Odinson");
		sendKeysToElement(Addresslookupforjoinacase, "red");
		sleep(2);
		clickElement(Addressiconforjoinacase);
		clickElement(Addresscjoincase);
		sleep(3);
		sendKeysToElement(Email1, "thor@123.com");
		sendKeysToElement(plaintifPHNO, "1234567898");
	}

	@Given("select the interpreter required or not")
	public void select_the_interpreter_required_or_not() {
		clickElement(No2);
	}

	@Given("select the checkboxes for acknowledgement")
	public void select_the_checkboxes_for_acknowledgement() {
		clickElement(informationtrue);
		clickElement(informationtrue2);
	}

	@Given("click reviewapplication and click submit and then click ok")
	public void click_reviewapplication_and_click_submit_and_then_click_ok() throws InterruptedException {
		clickElement(Reviewapplication);
		clickElement(submit);
		sleep(10);
		clickElement(ok);
	}
	@Given("select relevant party")
	public void select_relevant_party() {
		if(scenario.getSourceTagNames().contains("@JoinACaseApplicant"))
		{
			clickElement(selectrelaventpartyApp);
		}
		else if(scenario.getSourceTagNames().contains("@JoinACaseDefantant"))
		{
			clickElement(selectrelaventpartyDef);
		}
	}

	@Given("click submit and click ok")
	public void click_submit_and_click_ok() throws InterruptedException {
		clickElement(submitjoinacase);
		sleep(10);
		clickElement(ok);
		sleep(5);
	}

}















