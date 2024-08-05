package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectionPage {
    private WebDriver driver;
    private WebDriverWait wait;

   
    private By nextButton = By.xpath("//input[@value='Next']");

    public ObjectionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectReasonForObjection() throws InterruptedException {
       
    	TimeUnit.SECONDS.sleep(3);
		WebElement reason = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[@aria-label='Please select the reason for your objection']/parent::div/following-sibling::div/div[2]/select")));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h5[@aria-label='Please select the reason for your objection']/parent::div/following-sibling::div/div[2]/select/option"), 1));
		new Select(reason).selectByIndex(3);
		TimeUnit.SECONDS.sleep(3);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
