
package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupportingLetterPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private By uploadInput = By.xpath("//button[text()='Upload from Local Storage']/preceding-sibling::input");
	private By nextButton = By.xpath("//*[@value='Next']");
	private By completeButton = By.xpath("//input[@value='Complete']");

	public SupportingLetterPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void uploadSupportingLetter(String filePath) throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(uploadInput));
		TimeUnit.SECONDS.sleep(3);
		element.sendKeys(filePath);
	}

	public void clickNextButton() {
		wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
	}

	public void clickCompleteButton() {
		wait.until(ExpectedConditions.elementToBeClickable(completeButton)).click();
	}
}


