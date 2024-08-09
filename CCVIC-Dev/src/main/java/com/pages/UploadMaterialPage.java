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
    private By Redactedfile  = By.xpath("//input[@onclick='this.value=null']");
    private By Redactedfiledescription  = By.xpath("(//input[@maxlength=\"100\"])[2]");
    private By ObjectionCheck  = By.xpath("(//input[@type=\"checkbox\"])[4]");
    private By objectionreasonDPD  = By.xpath("//*[@id='sq_113i']");
    private By objectionreasonDPDOP1  = By.xpath("//option[contains(text(),'The subpoena is too vague and/or broad')]");
    private By FileStorage  = By.xpath("//a[contains(text(),'File Storage ')]");
	private By Uploadfile   = By.xpath("(//*[@class='links'])[1]");
	private By Fileupload   = By.xpath("//*[@onclick='this.value = null']");
	private By Closeicon   = By.xpath("(//button[@class=\"close\" ])[2]");
	private By loder       = By.id("loader");
    
    public UploadMaterialPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void uploadRequestedMaterial(String filePath) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(uploadInput));
        element.sendKeys(filePath);
        TimeUnit.SECONDS.sleep(3);
    }
    public void uploadRedactedfile(String filePath) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Redactedfile));
        element.sendKeys(filePath);
        TimeUnit.SECONDS.sleep(3);
    }
    public void Waitloader() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loder));
	}
	

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    public void clickobjectionreasonDPDOP1() {
        wait.until(ExpectedConditions.elementToBeClickable(objectionreasonDPDOP1)).click();
    }
    public void clickobjectionreasonDPD() {
        wait.until(ExpectedConditions.elementToBeClickable(objectionreasonDPD)).click();
    }
    public void clickObjectionCheck() {
        wait.until(ExpectedConditions.elementToBeClickable(ObjectionCheck)).click();
    }
    public void clickRedactedfiledescription() {
        wait.until(ExpectedConditions.elementToBeClickable(Redactedfiledescription)).sendKeys("TEST Description");
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
