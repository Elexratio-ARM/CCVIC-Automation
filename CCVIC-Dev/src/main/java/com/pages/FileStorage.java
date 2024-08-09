package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileStorage {

	private WebDriver driver;
	private WebDriverWait wait;
	public FileStorage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}


	public void clickFileStorage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='File Storage ']")));
		js.executeScript("arguments[0].click()", element);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='dropdown-menu']/li)[1]"))).click();
	}

public void uploadfile(String filePath)
{
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cin"))).sendKeys(filePath);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='×'])[2]"))).click();
}
public void navigateToFileStorage()
{
	wait.until(ExpectedConditions.elementToBeClickable(By.id("sideMenuMyFile"))).click();
}

}
