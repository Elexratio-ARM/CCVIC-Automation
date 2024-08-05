package com.pages;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class ResponseTypePage {
	    private WebDriver driver;
	    private WebDriverWait wait;

	    private By nextButton = By.xpath("//input[@value='Next']");

	    public ResponseTypePage(WebDriver driver, WebDriverWait wait) {
	        this.driver = driver;
	        this.wait = wait;
	    }

	    public void selectResponseType(String value) {
	        By responseType = By.xpath("//*[@value='" + value + "']");
	        wait.until(ExpectedConditions.elementToBeClickable(responseType)).click();
	    }

	    public void clickNextButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
	    }
	}


