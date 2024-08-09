package com.caseparty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateObjectionPage {

	private WebDriverWait wait;
	private WebDriver driver;

	private By objections = By.xpath("//*[@id='sideMenuMyObjections']");
	public NavigateObjectionPage(WebDriverWait wait, WebDriver driver) {
		this.wait = wait;
		this.driver = driver;
	}



	public void clickCasePartyObjections()
	{
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(objections));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",element );
	}

}
