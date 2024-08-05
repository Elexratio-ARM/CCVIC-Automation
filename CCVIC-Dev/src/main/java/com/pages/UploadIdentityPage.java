package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadIdentityPage {
    private WebDriverWait wait;

    private By uploadInput = By.xpath("//button[text()=' Upload from Local Storage ']/preceding-sibling::input");
    private By declarationCheckBox = By.xpath("//label[text()='I confirm that I have completed the ‘Declaration by Addressee’ contained in the subpoena uploaded.']/input");
    private By nextButton = By.xpath("//button[text()=' Next ']");

    public UploadIdentityPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
    }

    public void uploadFile(String filePath) {
       wait.until(ExpectedConditions.presenceOfElementLocated(uploadInput))
        .sendKeys(filePath);
    }

    public void clickDeclarationCheckBox() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
        wait.until(ExpectedConditions.elementToBeClickable(declarationCheckBox)).click();
    }

    public void clickNextButton() throws InterruptedException {
    	TimeUnit.SECONDS.sleep(3);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
