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
import org.openqa.selenium.interactions.Actions;
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


	@Given("Click on start case")
	public void ckick_on_start_case() {
		clickElement(startCase);
	}

	@Then("Select court type")
	public void select_court_type() {
		clickElement(CourtType);
		if(scenario.getSourceTagNames().contains( "@MagistratesCourtStartACase")||scenario.getSourceTagNames().contains("@Originatingapplication"))
		{
			clickElement(MagistratesCourt);
		}
		else if (scenario.getSourceTagNames().contains("@QCATResidentialTenancyDisputes"))
		{
			clickElement(QCAT);
		}
	}


	@Then("Select the case type")
	public void select_the_case_type() throws InterruptedException {
		clickElement(CaseType);  // Click on CaseType element

		if(scenario.getSourceTagNames().contains( "@MagistratesCourtStartACase"))
			clickElement(ClaimCase);
		else if (scenario.getSourceTagNames().contains("@QCATResidentialTenancyDisputes"))
			clickElement(RTD);
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

	@Then("Select tenant on making the application")
	public void select_tenant_on_making_the_application() {
		clickElement(Tenant);
		clickElement(next);
	}

	@Then("Select Tribunal order on orders and Yes on form20")
	public void select_tribunal_order_on_orders_and_yes_on_form20() throws InterruptedException {
		sleep(5); 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click()", others);
		JavascriptExecutor js1 = (JavascriptExecutor)driver; 
		js1.executeScript("arguments[0].click()", Checkbox1);
		clickElement(YES1);


	}

	@When("provide date the Notice and upload form20 file")
	public void provide_date_the_notice_and_upload_form20_file() throws InterruptedException {
		sleep(5);
		sendKeysToElement(interestDate, ("2024-08-15"));
		Fromdate.sendKeys(Keys.TAB);
		sendKeysToElement(interestDate, ("2024"));
	}

	@Then("Enter the reason you are applying and click next")
	public void enter_the_reason_you_are_applying_and_click_next() throws AWTException, InterruptedException {
		sendKeysToElement(ReasonFA, ("Test reason"));
		clickElement(No8);
		clickElement(next);
		
	}

	

	@Then("Enter the date lease agreement and click on next")
	public void enter_the_date_lease_agreement_and_click_on_next() {
		clickElement(typeofLease);
		sendKeysToElement(leaseDate, ("2024-08-15"));
		Fromdate.sendKeys(Keys.TAB);
		sendKeysToElement(leaseDate, ("2024"));
		clickElement(No);
		clickElement(next);
	}

	@When("select yes on seeking cost and upload the supporting file")
	public void select_yes_on_seeking_cost_and_upload_the_supporting_file() {
		clickElement(No1);
		clickElement(No2);
		clickElement(next);
	}
	
	@Then("select yes on property information and provide properties details")
	public void select_yes_on_property_information_and_provide_properties_details() {
		clickElement(No1);
		sendKeysToElement(propertyAddress, ("red"));
		clickElement(Searchicon2);
		clickElement(AddressA);
		clickElement(next);
	}

	@Then("Select the court location on click on next")
	public void select_the_court_location_on_click_on_next() {
		clickElement(courtLocation);
		clickElement(courtLocationop1);
		clickElement(next);
	}

	@When("Fill the applicant details")
	public void fill_the_applicant_details() {
		clickElement(No1);
		clickElement(Individual);
		sendKeysToElement(firstname, ("blair "));
		sendKeysToElement(lastname, ("waldorf"));
		sendKeysToElement(address4, ("red"));
		clickElement(Searchicon2);
		clickElement(AddressA);
		sendKeysToElement(Email1, ("ABC@kk.co"));
		sendKeysToElement(plaintifPHNO, ("1122334455"));
		clickElement(straitIslander);
		clickElement(straitIslanderop1);
		
		
		
	}

	@Then("Fill the respondent details")
	public void fill_the_respondent_details() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Select Yes on lodge and pay and review the application")
	public void select_yes_on_lodge_and_pay_and_review_the_application() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("click on submit")
	public void click_on_submit() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@Given("click submit and click ok")
	public void click_submit_and_click_ok() throws InterruptedException {
		sleep(5);
		clickElement(submit);
		sleep(10);
		clickElement(ok);
		sleep(5);
	}
	
	@Then("Search the case number and click file a document tab")
	public void search_the_case_number_and_click_file_a_document_tab() throws InterruptedException {
	  
		clickElement(cases);
		String caseno = null;
		if(scenario.getSourceTagNames().contains("@FileaDocumentForMagistrate"))
		{
			caseno="McCaseNumber";
		}
		else if(scenario.getSourceTagNames().contains("@FileaDocumentForQcat"))
		{
			caseno="QcatCaseNumber";
		}
	 if(caseno!=null) {
	   sendKeysToElement(casenumbersearchbox, properties.getProperty(caseno));
	 }
	   sleep(2);
	   clickElement(casenumbersearchboxicon);
	   clickElement(casenumber);
	   clickElement(fileadocument);
	   sleep(5);
	}

	@Then("Select the document group and type and form type and click proceed")
	public void select_the_document_group_and_type_and_form_type_and_click_proceed() throws InterruptedException, AWTException {
		
   clickElement(documentgroup);
   WebElement doc=null;
   WebElement docType=null;
   if(scenario.getSourceTagNames().contains("@FileaDocumentForMagistrate"))
   {
	   doc=Notices;
	   docType=Form93;
	   
   }
   else if(scenario.getSourceTagNames().contains("@FileaDocumentForQcat"))
	{
		doc=Completeapplication;
		docType=DocumentType;
	}
   clickElement(doc);
   sleep(2);
   clickElement(DocumentType);
   sleep(2);
   Robot rb = new Robot();
   rb.keyPress(KeyEvent.VK_UP);
   rb.keyRelease(KeyEvent.VK_UP);
   clickElement(docType);
   clickElement(Proceed);
   
	}

	@Then("fill the details of Application and matter details page and click next")
	public void fill_the_details_of_application_and_matter_details_page_and_click_next() throws InterruptedException {
		clickElement(PartfilingDef);
		sendKeysToElement(FNOfParty, "Thor odinson");
		clickElement(PersonToAttend);
		sendKeysToElement(HearingDate, "20-08-2024");
		sendKeysToElement(HearingTime, "12:00");
		sendKeysToElement(NameForFileDocument, "Thor Odinson");
		sendKeysToElement(AddressLookupForFileADoc, "red");
		sleep(3);
		clickElement(AddressIconForFileADoc);
		clickElement(AddressForFileADoc);
		sleep(2);
		clickElement(No);
		sendKeysToElement(textareajoinacase, "test  a scenario");
		clickElement(next);
	 
	}

	@Then("fill the details of lodge and pay page and click review apllication")
	public void fill_the_details_of_lodge_and_pay_page_and_click_review_apllication() throws InterruptedException {
	  clickElement(No);
	  clickElement(No2);
	 
	  clickElement(Checkbox5);
	  clickElement(Checkbox6);
	  clickElement(reviewapp);
	}
	@Then("fill the details of document information")
	public void fill_the_details_of_document_information() throws InterruptedException, AWTException {
		clickElement(PartfilingDef);
		clickElement(uploadaffidavit);
		clickElement(SelectFile);
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
		sleep(1);
		clickElement(Save);
		sleep(3);
		sendKeysToElement(Addresslookupjoinacase, "red");
		sleep(3);
		clickElement(AddressIconForFileADoc);
		clickElement(Address2);
		sendKeysToElement(Email1,("TEst11@auto.mation"));
		sendKeysToElement(mail, "9876543212");
		clickElement(next);
		clickElement(Reviewapplication);
	}

}















