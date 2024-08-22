package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FileDocumentPage{
	private WebDriver driver;
	private WebDriverWait wait;

	/* LOCATORS */
	private By CaseNoPo1 = By.xpath("(//td[@class='number_td'])[1]");
	private By FileAdocument = By.xpath("//button[@class='btn btn-success']");
	private By ChooseFile = By.xpath("(//input[@onclick=\"this.value = null\"])[2]");
	private By DocumentType = By.xpath("(//select[@class=\"form-control ng-pristine ng-invalid ng-touched\"])");
	private By CoverletterOP = By.xpath("//Option[contains(text(),'Cover Letter')]");
	private By Objectionop = By.xpath("(//Option[contains(text(),'Objection')])[1]");
	private By SubpoenaMaterialOP = By.xpath("//Option[contains(text(),'Subpoena material')]");
	private By Withdrawalop = By.xpath("//Option[contains(text(),'Withdrawal')]");
	private By DocumentName = By.xpath("//input[@type='text']");
	private By MedicRadio = By.xpath("(//input[@type=\"radio\"])[4]");
	private By Submit = By.xpath("(//button[@class=\"lato btn btn-primary\"])[2]");
	private By Ok = By.xpath("(//button[contains(text(),' Ok ')])");
	private By inspectSidemenu = By.xpath("//span[@class='glyphicon glyphicon-search']");
	private By RequestInspection = By.xpath("//a[@class='join_btn white']");
	private By casenumberfield = By.xpath("//input[@name='externalCaseNumber']");
	private By SubmitCN = By.xpath("//button[@type='submit']");
	private By SubpoenaCheckbox = By.xpath("(//input[@type='checkbox'])[2]");
	private By inspect = By.xpath("(//button[@type='button'])[5]");
	private By AdditionalInformation = By.xpath("//textarea[@maxlength='2000']");
	private By IAgreecheck = By.xpath("(//input[@type='checkbox'])[3]");
	private By urgentcheck = By.xpath("(//input[@type='checkbox'])[4]");
	private By DateOfOrder = By.xpath("//input[@name='date-of-order']");
	private By Todaydate = By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']");
	private By SubmitInpection = By.xpath("(//button[@type='submit'])[2]");
	private By ConfirmationOK = By.xpath("(//button[@data-dismiss='modal'])[2]");
	private By ResponsesfromotherPage       = By.xpath("//span[@class='glyphicon glyphicon-list']");



	public FileDocumentPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	public void uploadChooseFile(String filePath) throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(ChooseFile));
		element.sendKeys(filePath);
		TimeUnit.SECONDS.sleep(3);
	}
	public void clickCaseNoPo1() {
		wait.until(ExpectedConditions.elementToBeClickable(CaseNoPo1)).click();
	}
	public void clickFileAdocument() {
		wait.until(ExpectedConditions.elementToBeClickable(FileAdocument)).click();
	}
	public void clickDocumentType() {
		wait.until(ExpectedConditions.elementToBeClickable(DocumentType)).click();
	}
	public void clickCoverletterOP() {
		wait.until(ExpectedConditions.elementToBeClickable(CoverletterOP)).click();
	}
	public void clickObjectionop() {
		wait.until(ExpectedConditions.elementToBeClickable(Objectionop)).click();
	}
	public void clickSubpoenaMaterialOP() {
		wait.until(ExpectedConditions.elementToBeClickable(SubpoenaMaterialOP)).click();
	}
	public void clickWithdrawalop() {
		wait.until(ExpectedConditions.elementToBeClickable(Withdrawalop)).click();
	}
	public void clickDocumentName() {
		wait.until(ExpectedConditions.elementToBeClickable(DocumentName)).sendKeys("Test Document");
	}
	public void clickMedicRadio() {
		wait.until(ExpectedConditions.elementToBeClickable(MedicRadio)).click();
	}
	public void clickSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();
	}
	public void clickOk() {
		wait.until(ExpectedConditions.elementToBeClickable(Ok)).click();
	}
	public void clickInspectSidemenu() {
		wait.until(ExpectedConditions.elementToBeClickable(inspectSidemenu)).click();
	}

	public void clickRequestInspection() {
		wait.until(ExpectedConditions.elementToBeClickable(RequestInspection)).click();
	}


	public void enterCaseNumber(String Number) {
		WebElement caseSearchBox = wait.until(ExpectedConditions.presenceOfElementLocated(casenumberfield));
		caseSearchBox.sendKeys(Number);

	}
	public void clickSubmitCN() {
		wait.until(ExpectedConditions.elementToBeClickable(SubmitCN)).click();
	}

	public void clickSubpoenaCheckbox() {
		wait.until(ExpectedConditions.elementToBeClickable(SubpoenaCheckbox)).click();
	}

	public void clickInspect() {
		wait.until(ExpectedConditions.elementToBeClickable(inspect)).click();
	}

	public void enterAdditionalInformation(String info) {
		wait.until(ExpectedConditions.presenceOfElementLocated(AdditionalInformation)).sendKeys(info);
	}

	public void clickIAgreeCheck() {
		wait.until(ExpectedConditions.elementToBeClickable(IAgreecheck)).click();
	}

	public void clickUrgentCheck() {
		wait.until(ExpectedConditions.elementToBeClickable(urgentcheck)).click();
	}
	public void clickDateOfOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(DateOfOrder)).click();
	}
	public void selectTodayDate() {
		wait.until(ExpectedConditions.elementToBeClickable(Todaydate)).click();
	}

	public void clickSubmitInspection() {
		wait.until(ExpectedConditions.elementToBeClickable(SubmitInpection)).click();
	}
	public void clickResponsesfromotherPage() {
		wait.until(ExpectedConditions.elementToBeClickable(ResponsesfromotherPage)).click();
	}


	public void clickConfirmationOK() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3); // Wait for confirmation pop-up
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmationOK)).click();
	}			



}

