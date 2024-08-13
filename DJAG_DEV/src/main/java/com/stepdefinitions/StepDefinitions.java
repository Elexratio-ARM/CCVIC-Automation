package com.stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Provide Claim information")
	public void provide_claim_information() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Enter the amount and interest claiming")
	public void enter_the_amount_and_interest_claiming() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("select yes on claim any other costs and click on next")
	public void select_yes_on_claim_any_other_costs_and_click_on_next() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}


}
