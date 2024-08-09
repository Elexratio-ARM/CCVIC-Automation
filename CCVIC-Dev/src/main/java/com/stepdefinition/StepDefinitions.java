package com.stepdefinition;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.caseparty.pages.CasePartyObjectionPage;

import com.caseparty.pages.NavigateObjectionPage;

import com.github.dockerjava.api.model.Driver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.pages.LoginPage;
import com.pages.RespondApplicationPage;
import com.pages.UploadIdentityPage;
import com.pages.ResponseTypePage;
import com.pages.SupportingLetterPage;
import com.pages.ReviewResponsePage;
import com.pages.FileDocumentPage;
import com.pages.ObjectionPage;
import com.pages.JudicialOrderPage;
import com.pages.UploadMaterialPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
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
    //casepartyobjections

    private NavigateObjectionPage navigateObjectionPage;

    private CasePartyObjectionPage casePartyObjectionPage;
    private FileDocumentPage fileDocumentPage;
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
        fileDocumentPage = new FileDocumentPage(driver, wait);
        //caseparty objection

        navigateObjectionPage = new NavigateObjectionPage(wait, driver);

        casePartyObjectionPage = new CasePartyObjectionPage(wait, driver);
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
        	if( scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial") || scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound") ||scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena")) 
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
        	if(scenario.getSourceTagNames().contains("@AppealSubmitSubpoenaedMaterial") ||scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena"))
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
        if(scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial")||scenario.getSourceTagNames().contains("@AppealSubmitSubpoenaedMaterial") || scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterial")|| scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterialWithRedactedfile")) {
            responseTypePage.selectResponseType("432680000");
        }
        responseTypePage.clickNextButton();
    }

    @Given("upload a supporting letter")
    public void upload_a_supporting_letter() throws InterruptedException {
        supportingLetterPage.uploadSupportingLetter(filePath);
        if(scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial")||scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterial")||scenario.getSourceTagNames().contains("@CrimeSubmitSubpoenaedMaterialWithRedactedfile")||scenario.getSourceTagNames().contains("@AppealSubmitSubpoenaedMaterial")) {
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
    @When("click on File storage dropdown and click on upload")
	public void click_on_File_storage_dropdown_and_click_on_upload() {
		uploadMaterialPage.Waitloader();

		uploadMaterialPage.clickFileStorage();
		uploadMaterialPage.clickUploadfile();


	}

	@Then("Upload file from local storage")
	public void upload_file_from_local_storage() throws InterruptedException {

		uploadMaterialPage.uploadFileupload(filePath);
		uploadMaterialPage.clickCloseicon();

	}
	@When("select case number")
	public void select_case_number() {
		fileDocumentPage.clickCaseNoPo1();
	}

	@Then("Click on file a document")
	public void click_on_file_a_document() {
		uploadMaterialPage.Waitloader();
		fileDocumentPage.clickFileAdocument();
	}

	@And("upload file on the choose file option")
	public void upload_file_on_the_choose_file_option() throws InterruptedException {
		fileDocumentPage.uploadChooseFile(filePath);
	}

	@Then("Select document type and provide document name")
	public void select_document_type_and_provide_document_name() {
		uploadMaterialPage.Waitloader();
		fileDocumentPage.clickCoverletterOP();
		if ((scenario.getSourceTagNames().contains(" @FileADocumentCoverletter")))
		{
			fileDocumentPage.clickCoverletterOP();
		}
		else if((scenario.getSourceTagNames().contains("@FileADocumentObjection"))){
			fileDocumentPage.clickObjectionop();
		}
		else if((scenario.getSourceTagNames().contains("@FileADocumentSubpoenaMaterial"))){
			fileDocumentPage.clickSubpoenaMaterialOP();
		}
		else if((scenario.getSourceTagNames().contains("@FileADocumentWithdrawal"))){
			fileDocumentPage.clickWithdrawalop();
		}

		fileDocumentPage.clickDocumentName();
	}

	@But("Select medical materials and click on submit")
	public void select_medical_materials_and_click_on_submit() {
		fileDocumentPage.clickMedicRadio();
		fileDocumentPage.clickSubmit();
		fileDocumentPage.clickOk();
	}
	@When("navigate to inspection and click on inspection")
	public void navigate_to_inspection_and_click_on_inspection() throws InterruptedException {
		TimeUnit.SECONDS.sleep(10);
		uploadMaterialPage.Waitloader();
		fileDocumentPage.clickInspectSidemenu();
		fileDocumentPage.clickRequestInspection();

	}
	@Then("Enter the case the number and click on search")
	public void enter_case_number_and_click_search() {
		String number = properties.getProperty("Inspectcasenumber");
		fileDocumentPage.enterCaseNumber(number);
		fileDocumentPage.clickSubmitCN();
	}

	@Then("Select the Subpoena check box and click on inspect")
	public void select_subpoena_checkbox_and_click_inspect() {
		fileDocumentPage.clickSubpoenaCheckbox();
		fileDocumentPage.clickInspect();

	}

	@When("Provide Additional information and Select the i agree check box")
	public void provide_additional_information_and_select_i_agree_checkbox() {
		fileDocumentPage.enterAdditionalInformation("Test information");
		fileDocumentPage.clickIAgreeCheck();
	}

	@Then("Select My inspection is urgent and provide date of order made")
	public void select_urgent_and_provide_date_of_order_made() {
		fileDocumentPage.clickUrgentCheck();
		fileDocumentPage.clickDateOfOrder();
		fileDocumentPage.selectTodayDate();


	}

	@Then("click on Submit and click on ok on the confirmation pop-up")
	public void click_on_submit_and_confirmation_ok() throws InterruptedException {
		fileDocumentPage.clickSubmitInspection();
		fileDocumentPage.clickConfirmationOK();

	}
	  @Then("Navigate to Responses from other")
	    public void navigate_to_responses_from_other() throws InterruptedException {
		  TimeUnit.SECONDS.sleep(10);
			uploadMaterialPage.Waitloader();
			fileDocumentPage.clickResponsesfromotherPage();
			
	  }
	   @Given("navigate to the case party objection")

	    public void navigate_to_the_case_party_objection() {

	       navigateObjectionPage.clickCasePartyObjections();

	    }

	    @When("select the File an objection tab is select")

	    public void select_the_file_an_objection_tab_is_select() {

	      casePartyObjectionPage.clickFileObjectionTab();

	    }

	    @Then("enter the case number for objection and click the search button")

	    public void enter_the_case_number_for_objection_and_click_the_search_button() {

	        String caseNumber = properties.getProperty("Objectioncasenumber");

	        casePartyObjectionPage.enterCaseNumber(caseNumber);

	        casePartyObjectionPage.clickSearchButton();

	    }

	    @And("click the select button upload a supporting letter")

	    public void click_the_select_button_upload_a_supporting_letter() throws InterruptedException {

	    	casePartyObjectionPage.clickSelectButton();

	    	casePartyObjectionPage.uploadSupportingLetter(filePath);

	    }

	    @And("select the reason for objection")

	    public void select_the_reason_for_objection() {

	        casePartyObjectionPage.objectionReason();

	        

	    }

	    @And("select the I am lodging my objection on the correct subpoena checkbox")

	    public void select_the_i_am_lodging_my_objection_on_the_correct_subpoena_checkbox() {

	       casePartyObjectionPage.checkbox();

	    }

	    @And("click the submit button and ok button")

	    public void click_the_submit_button_and_ok_button() throws InterruptedException {

	      casePartyObjectionPage.submit();

	      quitDriver();	

	    }

	    

}


