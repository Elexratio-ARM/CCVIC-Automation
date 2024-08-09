package com.caseparty.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CasePartyObjectionPage {

	private WebDriverWait wait;
	private WebDriver driver;

	private By fileobjection = By.xpath("//a[text()='File an Objection']");
	private By caseNumberField = By.name("externalCaseNumber");
	private By searchButton = By.xpath("//button[text()='Search']");
	private By selectButton = By.xpath("//button[text()=' Select ']");
	private By uploadInput = By.xpath("(//input[@onclick='this.value = null'])[2]");
	public CasePartyObjectionPage(WebDriverWait wait, WebDriver driver)
	{
		this.wait = wait;
		this.driver = driver;
	}
	

	public void clickFileObjectionTab()
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fileobjection));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void enterCaseNumber(String caseNumber) {
		WebElement caseSearchBox = wait.until(ExpectedConditions.presenceOfElementLocated(caseNumberField));
		caseSearchBox.sendKeys(caseNumber);
	}
	public void clickSearchButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
    }
	public void clickSelectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(selectButton)).click();
    }
	public void uploadSupportingLetter(String filePath) throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(uploadInput));
		TimeUnit.SECONDS.sleep(3);
		element.sendKeys(filePath);
	}
	public void objectionReason()
	{
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='Registry']")));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@name='Registry']/option"),1));
		Select dropdown = new Select(element);
		dropdown.selectByIndex(2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok ']"))).click();
	}
	public void checkbox()
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.name("CheckTandC"))).click();
	}
	public void submit() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit ']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()=' Ok '])[2]"))).click();
		TimeUnit.SECONDS.sleep(5);
	}
}
