package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RespondApplicationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By respondApplicationTab = By.xpath("//a[(text()='Respond to a Subpoena/s.32C Application')]");
    private By caseNumberField = By.xpath("//label[text()='Enter the case number']/following::input");
    private By searchButton = By.xpath("//button[text()='Search']");
    private By selectButton = By.xpath("//button[text()=' Select ']");
    private By respondsubpoena = By.xpath("//label/strong[text()='Respond to Subpoena']/preceding-sibling::input");
    private By application32c = By.xpath("//label/strong[text()='32c Application']/preceding-sibling::input");
    public RespondApplicationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickRespondApplicationTab() throws InterruptedException {
    	TimeUnit.SECONDS.sleep(10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
        wait.until(ExpectedConditions.elementToBeClickable(respondApplicationTab)).click();
		
    }

    public void enterCaseNumber(String caseNumber) {
        WebElement caseSearchBox = wait.until(ExpectedConditions.presenceOfElementLocated(caseNumberField));
        caseSearchBox.sendKeys(caseNumber);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void clickSelectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(selectButton)).click();
    }
    public void clickRespondToSubpoena()
    {
		wait.until(ExpectedConditions.elementToBeClickable(respondsubpoena)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();

    }
    public void click32cApplication()
    {

		wait.until(ExpectedConditions.elementToBeClickable(application32c)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Next ']"))).click();
    }
}
