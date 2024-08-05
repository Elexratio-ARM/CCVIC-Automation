package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JudicialOrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By judicialOrderCheckBox = By.xpath("//input[@value='true']");
    private By nextButton = By.xpath("//*[@value='Next']");

    public JudicialOrderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void chooseJudicialOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(judicialOrderCheckBox)).click();
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
