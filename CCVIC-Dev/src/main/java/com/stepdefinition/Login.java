package com.stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties properties;
	private Scenario scenario;
	private String projectPath = System.getProperty("user.dir");
	private String filePath = projectPath + "/File/Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("Launch the url in Chrome")
	public void launch_the_url_in_chrome() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-application-cache");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();

		properties = new Properties();
		properties.load(new FileInputStream(projectPath + "/File/Credentials.file"));
		driver.get(properties.getProperty("url"));
	}

	@Then("Enter the credentials and click the signin button")
	public void enter_the_credentials_and_click_the_signin_button() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Login']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logonIdentifier"))).sendKeys(properties.getProperty("username"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(properties.getProperty("password"));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("next"))).click();
	}

	@When("Click the Respond Application tab")
	public void click_the_respond_application_tab() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html")));
		TimeUnit.SECONDS.sleep(10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Respond to a Subpoena/s.32C Application')]"))).click();
	}

	@Then("Enter the case number and click the search button and click the select button")
	public void enter_the_case_number_and_click_the_search_button_and_click_the_select_button() throws InterruptedException
	{

		if(scenario.getSourceTagNames().stream().anyMatch(tag-> tag.contains("Appeal")))
		{
			String caseNumber = scenario.getSourceTagNames().stream().anyMatch(tag-> tag.contains("Appeal"))? properties.getProperty("Appealcasenumber"):null;

			WebElement caseSearchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Enter the case number']/following::input")));
			caseSearchBox.sendKeys(caseNumber);
		}
		else
		{
			String caseNumber = scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("Crime")) ? properties.getProperty("crimecasenumber") : properties.getProperty("civilcasenumber");
			TimeUnit.SECONDS.sleep(3);

			WebElement caseSearchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Enter the case number']/following::input")));
			caseSearchBox.sendKeys(caseNumber);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		if (scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("Crime"))) {
			String optionXpath = scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena") ? 
					"//label/strong[text()='Respond to Subpoena']/preceding-sibling::input" : 
						"//label/strong[text()='32c Application']/preceding-sibling::input";      
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();
		}

		else if (scenario.getSourceTagNames().stream().anyMatch(tag -> tag.contains("Appeal"))) {
			String optionXpath = scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena") ? 
					"//label/strong[text()='Respond to Subpoena']/preceding-sibling::input" : 
						"//label/strong[text()='32c Application']/preceding-sibling::input";      
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Select ']"))).click();
		}
	}


	@Then("Upload your identity and click the declaration check box and next button")
	public void upload_your_identity_and_click_the_declaration_check_box_and_next_button() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=' Upload from Local Storage ']/preceding-sibling::input")));
		element.sendKeys(filePath);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='I confirm that I have completed the ‘Declaration by Addressee’ contained in the subpoena uploaded.']/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();
	}

	@Given("select the Responsetype")
	public void select_the_responsetype() {
		if(scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound")||scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound")||scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='432680001']"))).click();

		}
		if(scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena")||scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena")||scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='432680002']"))).click();
		}
		if(scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='432680000']"))).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();
	}

	@Given("upload a supporting letter")
	public void upload_a_supporting_letter() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Upload from Local Storage']/preceding-sibling::input")));
		TimeUnit.SECONDS.sleep(3);
		element.sendKeys(filePath);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		if(scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='Next']"))).click();

		}
		else
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Complete']"))).click();
	}

	

	@Then("provide review response and click submit")
	public void provide_review_response_and_click_submit() throws InterruptedException {
		if (scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena")) {
			submitResponse();
		} else if (scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena") || scenario.getSourceTagNames().contains("@CrimeRespondTo32CApplication")||scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena") || scenario.getSourceTagNames().contains("@AppealRespondTo32CApplication")) {
			if (scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena")||scenario.getSourceTagNames().contains("@AppealSubpoenaedNotFound") || scenario.getSourceTagNames().contains("@AppealObjectToComplyWithTheSubpoena")) {


				wait.until(ExpectedConditions.elementToBeClickable(By.name("production-date"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr/td[2]/span[text()='5']"))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.name("date-of-judgement"))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']"))).click();
			} else if (scenario.getSourceTagNames().contains("@CrimeRespondTo32CApplication")|| scenario.getSourceTagNames().contains("@AppealRespondTo32CApplication")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.name("date-of-judgement"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']"))).click();
			}
			TimeUnit.SECONDS.sleep(3);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("applicant-party"))).sendKeys("victoria");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("defendant-party"))).sendKeys("victoria");
			submitResponse();
		} else if (scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial")) {
			submitResponse();
		}
	}

	private void submitResponse() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Submit ']"))).click();
		TimeUnit.SECONDS.sleep(10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()=' Ok '])[2]"))).click();
	}





	@Then("Select the reason for the objection")
	public void select_the_reason_for_the_objection() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		WebElement reason = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[@aria-label='Please select the reason for your objection']/parent::div/following-sibling::div/div[2]/select")));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h5[@aria-label='Please select the reason for your objection']/parent::div/following-sibling::div/div[2]/select/option"), 1));
		new Select(reason).selectByIndex(3);
		TimeUnit.SECONDS.sleep(3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();
	}

	@Then("Upload your identity and click the next button")
	public void upload_your_identity_and_click_the_next_button() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=' Upload from Local Storage ']/preceding-sibling::input")));
		TimeUnit.SECONDS.sleep(3);
		element.sendKeys(filePath);
		TimeUnit.SECONDS.sleep(3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();
	}

	@Then("choose the judicial order")
	public void choose_the_judicial_order() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='true']"))).click();
		TimeUnit.SECONDS.sleep(3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();
	}

	@Then("upload the requested material")
	public void upload_the_requested_material() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@onclick='this.value=null;']")));
		TimeUnit.SECONDS.sleep(3);
		element.sendKeys(filePath);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();
	}



	@Then("Upload Subpoenaed Material and enter the subpoenaed Description")
	public void upload_subpoenaed_material_and_enter_the_subpoenaed_description() {

		String ProjectPath = System.getProperty("user.dir");
		String Filepath = ProjectPath + "/File/Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@onclick='this.value=null;']")));
		element.sendKeys(Filepath);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@placeholder='enter description'])[2]"))).sendKeys("Test description");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();


	}



	@Then("select I do not wish to upload any redacted versions")
	public void select_i_do_not_wish_to_upload_any_redacted_versions() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();

	}

	@When("select I do not object to inspection")
	public void select_i_do_not_object_to_inspection() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='confirmObjection']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();
	}

	@Then("Select yes on Medical Material and click on compleate")
	public void select_yes_on_medical_material_and_click_on_compleate() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sq_119i_0']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Complete']"))).click();
	}
}
