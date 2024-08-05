package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadMaterialPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By uploadInput = By.xpath("//input[@onclick='this.value=null;']");
    private By descriptionField = By.xpath("(//*[@placeholder='enter description'])[2]");
    private By noRedactedCheckBox = By.xpath("(//input[@type='checkbox'])[2]");
    private By nextButton = By.xpath("//input[@value='Next']");
    private By completeButton = By.xpath("//input[@value='Complete']");
    private By objectionCheckbox = By.xpath("//input[@name='confirmObjection']");
    private By medicalYesMaterial = By.xpath("//input[@id='sq_119i_0']");

    public UploadMaterialPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void uploadRequestedMaterial(String filePath) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(uploadInput));
        element.sendKeys(filePath);
        TimeUnit.SECONDS.sleep(3);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void clickCompleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(completeButton)).click();
    }

    public void uploadSubpoenaedMaterial(String filePath) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(uploadInput));
        element.sendKeys(filePath);
    }

    public void enterDescription(String description) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionField)).sendKeys(description);
    }

    public void selectNoRedactedVersions() {
        wait.until(ExpectedConditions.elementToBeClickable(noRedactedCheckBox)).click();
    }

    public void selectNoObjectionToInspection() {
        wait.until(ExpectedConditions.elementToBeClickable(objectionCheckbox)).click();
    }

    public void selectYesOnMedicalMaterial() {
        wait.until(ExpectedConditions.elementToBeClickable(medicalYesMaterial)).click();
    }
}
