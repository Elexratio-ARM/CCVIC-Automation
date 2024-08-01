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
	WebDriver driver;
	WebDriverWait wait;
	Properties properties;
	private Scenario scenario;
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@SuppressWarnings("deprecation")
	@Given("Launch the url in Chrome")
	public void launch_the_url_in_chrome() throws IOException {

		WebDriverManager.chromedriver().setup(); // Automatically downloads and manages the WebDriver
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver,Duration.ofSeconds(30));

		// Apply global implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Set your desired wait time
		FileInputStream input = new FileInputStream("./File/Credentials.file");
		properties = new Properties();
		properties.load(input);
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
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		TimeUnit.SECONDS.sleep(2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Respond to a Subpoena/s.32C Application')]"))).click();





	}
	@Then("Enter the case number and click the search button and click the select button")
	public void enter_the_case_number_and_click_the_search_button_and_click_the_select_button() {
		if (scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound") || 
				scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena") || 
				scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial")) {

			WebElement caseSearchbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Enter the case number']/following::input")));
			caseSearchbox.sendKeys(properties.getProperty("civilcasenumber"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Search']")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']"))).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Select ']"))).click();
		} else if (scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || 
				scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena") || 
				scenario.getSourceTagNames().contains("@CrimeRespondTo32CApplication")) {

			WebElement caseSearchbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Enter the case number']/following::input")));
			caseSearchbox.sendKeys(properties.getProperty("crimecasenumber"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Search']")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']"))).click();

			if (scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound") || 
					scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label/strong[text()='Respond to Subpoena']/preceding-sibling::input"))).click();
			} else {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label/strong[text()='32c Application']/preceding-sibling::input"))).click();
			}

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();
		}
	}


	@Then("Upload your identity and click the declaration check box and next button")
	public void upload_your_identity_and_click_the_declaration_check_box_and_next_button() {

		String ProjectPath = System.getProperty("user.dir");
		String Filepath = ProjectPath + "/File/Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=' Upload from Local Storage ']/preceding-sibling::input"))).sendKeys(Filepath);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='I confirm that I have completed the ‘Declaration by Addressee’ contained in the subpoena uploaded.']/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();


	}

	@Given("select the Responsetype")
	public void select_the_responsetype() {
		if(scenario.getSourceTagNames().contains("@CrimeSubpoenaedNotFound"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='432680001']"))).click();

		}
		if(scenario.getSourceTagNames().contains("@CrimeObjectToComplyWithTheSubpoena")||scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena"))
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
	public void upload_a_supporting_letter() {
		String ProjectPath = System.getProperty("user.dir");
		String Filepath = ProjectPath + "/File/Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Upload from Local Storage']/preceding-sibling::input")));
		element.sendKeys(Filepath);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		if(scenario.getSourceTagNames().contains("@CivilSubmitSubpoenaedMaterial"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();

		}
		else 
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Complete']"))).click();
	}

	@Then("click the checkbox of My submission is urgent due to an order made by the Court")
	public void click_the_checkbox_of_my_submission_is_urgent_due_to_an_order_made_by_the_court() {

		wait.until(ExpectedConditions.elementToBeClickable(By.name("isUrgent"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("date-of-order"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr/td[2]/span[text()='1']"))).click();

	}

	@Then("provide review response and click submit")
	public void provide_review_response_and_click_submit() {
		if(scenario.getSourceTagNames().contains("@CivilSubpoenaedNotFound")||scenario.getSourceTagNames().contains("@CivilObjectToComplyWithTheSubpoena"))
		{
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Submit ']"))).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()=' Ok '])[2]")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()=' Ok '])[2]"))).click();

		}

		
		String mainTag = scenario.getSourceTagNames().stream()
				.filter(tag -> tag.equals("@CrimeSubpoenaedNotFound") || 
						tag.equals("@CrimeObjectToComplyWithTheSubpoena") || 
						tag.equals("@CrimeRespondTo32CApplication") || 
						tag.equals("@CivilSubmitSubpoenaedMaterial"))
				.findFirst()
				.orElse(null);

		if (mainTag != null) {
			switch (mainTag) {
			case "@CrimeSubpoenaedNotFound":
			case "@CrimeObjectToComplyWithTheSubpoena":
			case "@CrimeRespondTo32CApplication":
				if (mainTag.equals("@CrimeSubpoenaedNotFound") || mainTag.equals("@CrimeObjectToComplyWithTheSubpoena")) {
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
					wait.until(ExpectedConditions.elementToBeClickable(By.name("production-date"))).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr/td[2]/span[text()='1']"))).click();
				}
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
				wait.until(ExpectedConditions.elementToBeClickable(By.name("date-of-judgement"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr/td[2]/span[text()='1']"))).click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("applicant-party"))).sendKeys("victoria");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("defendant-party"))).sendKeys("victoria");
				String element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("defendant-party"))).getText();
				if (element != null) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Submit ']"))).click();
				}
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html")));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[text()=' Ok '])[2]")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()=' Ok '])[2]"))).click();
				break;

			case "@CivilSubmitSubpoenaedMaterial":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='button' and contains(text(),'Submit')]"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button' and contains(text(),'Ok')])[2]"))).click();
				break;

			default:
				// Handle the default case if necessary
				break;
			}
		}


	}
	@Then("Select the reason for the objection")
	public void select_the_reason_for_the_objection() {
		WebElement reason = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[@aria-label='Please select the reason for your objection']/parent::div/following-sibling::div/div[2]/select")));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h5[@aria-label='Please select the reason for your objection']/parent::div/following-sibling::div/div[2]/select/option"), 1));
		Select dropdown = new Select(reason);
		dropdown.selectByIndex(3);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();
	}
	@Then("Upload your identity and click the next button")
	public void upload_your_identity_and_click_the_next_button() {

		String ProjectPath = System.getProperty("user.dir");
		String Filepath = ProjectPath + "/File/Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=' Upload from Local Storage ']/preceding-sibling::input"))).sendKeys(Filepath);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();
	}

	@Then("choose the judicial order")
	public void choose_the_judicial_order() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='true']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']"))).click();
	}

	@Then("upload the requested material")
	public void upload_the_requested_material() {

		String ProjectPath = System.getProperty("user.dir");
		String Filepath = ProjectPath + "./File/Get_Started_With_Smallpdf_DP6_2024.07.26.05.16.51.pdf";
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@onclick='this.value=null;']")));
		element.sendKeys(Filepath);
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

