package com.stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.pages.RespondApplicationPage;
import com.pages.UploadIdentityPage;
import com.pages.ResponseTypePage;
import com.pages.SupportingLetterPage;
import com.pages.ReviewResponsePage;
import com.pages.ObjectionPage;
import com.pages.JudicialOrderPage;
import com.pages.UploadMaterialPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseClass {

    private Scenario scenario;
    private LoginPage loginPage;
    private RespondApplicationPage respondApplicationPage;
    private UploadIdentityPage uploadIdentityPage;
    private ResponseTypePage responseTypePage;
    private SupportingLetterPage supportingLetterPage;
    private ReviewResponsePage reviewResponsePage;
    private ObjectionPage objectionPage;
    private JudicialOrderPage judicialOrderPage;
    private UploadMaterialPage uploadMaterialPage;
    private String filePath = projectPath + "/File/Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";
    private boolean test;
    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("Launch the url in Chrome")
    public void launch_the_url_in_chrome() throws IOException {
        initializeDriver();
        loginPage = new LoginPage(driver, wait);
        respondApplicationPage = new RespondApplicationPage(driver, wait);
        uploadIdentityPage = new UploadIdentityPage(driver, wait);
        responseTypePage = new ResponseTypePage(driver, wait);
        supportingLetterPage = new SupportingLetterPage(driver, wait);
        reviewResponsePage = new ReviewResponsePage(driver, wait);
        objectionPage = new ObjectionPage(driver, wait);
        judicialOrderPage = new JudicialOrderPage(driver, wait);
        uploadMaterialPage = new UploadMaterialPage(driver, wait);
        driver.get(properties.getProperty("url"));
    }

    @Then("Enter the credentials and click the signin button")
    public void enter_the_credentials_and_click_the_signin_button() {
        loginPage.clickLoginLink();
        loginPage.enterUsername(properties.getProperty("username"));
        loginPage.enterPassword(properties.getProperty("password"));
        loginPage.clickSignInButton();
    }

    @When("Click the Respond Application tab")
    public void click_the_respond_application_tab() throws InterruptedException {
        respondApplicationPage.clickRespondApplicationTab();
        TimeUnit.SECONDS.sleep(5);
    }

    @Then("Enter the case number and click the search button and click the select button")
    public void enter_the_case_number_and_click_the_search_button_and_click_the_select_button() throws InterruptedException {
        String caseNumber = scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("Appeal")) ?
                properties.getProperty("Appealcasenumber") :
                (scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("Crime")) ?
                        properties.getProperty("crimecasenumber") : properties.getProperty("civilcasenumber"));
        respondApplicationPage.enterCaseNumber(caseNumber);
        respondApplicationPage.clickSearchButton();
        if(respondApplicationPage.check()==false &( scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound")||scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena")||scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial")))
    	{respondApplicationPage.clickSelectButton();
          test=true;
    	}
    else  if(scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("Civil"))&respondApplicationPage.check()==true)
        {    test = false;
        	if( scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena")) 
        			respondApplicationPage.clickRespondToSubpoena();
        	else
        		respondApplicationPage.click32cApplication();
        }
        //respond to subpoena or 32capplication for crime case
        else  if(scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("Crime")))
        {
        	if( scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena")||scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterial")||scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterialWithRedactedfile")) 
        			respondApplicationPage.clickRespondToSubpoena();
        	else
        		respondApplicationPage.click32cApplication();
        }
        
        
      //respond to subpoena or 32capplication for Appeal case
        else if (scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("Appeal"))) 
        {
        	if(scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena"))
        		respondApplicationPage.clickRespondToSubpoena();
        	else
        		respondApplicationPage.click32cApplication();
        }
     
        
		

    }

    @Then("Upload your identity and click the declaration check box and next button")
    public void upload_your_identity_and_click_the_declaration_check_box_and_next_button() throws InterruptedException {
        uploadIdentityPage.uploadFile(filePath);
        uploadIdentityPage.clickDeclarationCheckBox();
        uploadIdentityPage.clickNextButton();
	    }
       
    @Given("select the Responsetype")
    public void select_the_responsetype() {
        if(scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound")) {
            responseTypePage.selectResponseType("432680001");
        }
        if(scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena") || scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena") || scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena")) {
            responseTypePage.selectResponseType("432680002");
        }
        if(scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial") || scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterial")|| scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterialWithRedactedfile")) {
            responseTypePage.selectResponseType("432680000");
        }
        responseTypePage.clickNextButton();
    }

    @Given("upload a supporting letter")
    public void upload_a_supporting_letter() throws InterruptedException {
        supportingLetterPage.uploadSupportingLetter(filePath);
        if(scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial")||scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterial")||scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterialWithRedactedfile")) {
            supportingLetterPage.clickNextButton();
        } else {
            supportingLetterPage.clickCompleteButton();
        }
    }

    @Then("provide review response and click submit")
    public void provide_review_response_and_click_submit() throws InterruptedException {
        reviewResponsePage.reviewResponse(scenario, properties,test);
        TimeUnit.SECONDS.sleep(5);
        quitDriver();
    }

    @Then("Select the reason for the objection")
    public void select_the_reason_for_the_objection() throws InterruptedException {
        objectionPage.selectReasonForObjection();
        objectionPage.clickNextButton();
    }

    @Then("Upload your identity and click the next button")
    public void upload_your_identity_and_click_the_next_button() throws InterruptedException {
        uploadIdentityPage.uploadFile(filePath);
        uploadIdentityPage.clickNextButton();
    }

    @Then("choose the judicial order")
    public void choose_the_judicial_order() throws InterruptedException {
        judicialOrderPage.chooseJudicialOrder();
        judicialOrderPage.clickNextButton();
    }

    @Then("upload the requested material")
    public void upload_the_requested_material() throws InterruptedException {
        uploadMaterialPage.uploadRequestedMaterial(filePath);
        uploadMaterialPage.clickNextButton();
    }

    @Then("Upload Subpoenaed Material and enter the subpoenaed Description")
    public void upload_subpoenaed_material_and_enter_the_subpoenaed_description() {
        uploadMaterialPage.uploadSubpoenaedMaterial(filePath);
        uploadMaterialPage.enterDescription("Test description");
        uploadMaterialPage.clickNextButton();
    }

    @Then("select I do not wish to upload any redacted versions")
    public void select_i_do_not_wish_to_upload_any_redacted_versions() throws InterruptedException {
    	
    	if ((scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterialWithRedactedfile")))	
    	{
    		uploadMaterialPage.uploadRedactedfile(filePath);
    		uploadMaterialPage.clickRedactedfiledescription();
    		uploadMaterialPage.clickNextButton();
    		
    		   		
    	}
    	else
    	{
        uploadMaterialPage.selectNoRedactedVersions();
        uploadMaterialPage.clickNextButton();
    	}
    }

    @When("select I do not object to inspection")
    public void select_i_do_not_object_to_inspection() {
    	if((scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterialWithRedactedfile")))
    	{
    		uploadMaterialPage.clickObjectionCheck();
    		uploadMaterialPage.clickNextButton();
    		uploadMaterialPage.clickobjectionreasonDPD();
    		uploadMaterialPage.clickobjectionreasonDPDOP1();
    		uploadMaterialPage.clickNextButton();
    		
    	}
    	else
    	{
        uploadMaterialPage.selectNoObjectionToInspection();
        uploadMaterialPage.clickNextButton();
    	}
    }

    @Then("Select yes on Medical Material and click on compleate")
    public void select_yes_on_medical_material_and_click_on_compleate() {
    	uploadMaterialPage.selectYesOnMedicalMaterial();
        uploadMaterialPage.clickCompleteButton();
    }
}
