package com.stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.base.base;
import com.hooks.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends base {
	private hooks hook;
	private String filePath = projectPath + "/File/Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";
	private Scenario scenario;
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;

	}
	@After
	public void quitDriver() throws InterruptedException {
		if (driver != null) {
			TimeUnit.SECONDS.sleep(5);
			driver.quit();
		}
	}

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
	public void select_the_case_type() {
		clickElement(CaseType);
		clickElement(ClaimCase);
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
		
	}



}
