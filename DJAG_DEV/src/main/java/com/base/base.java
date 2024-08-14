package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base extends hooks {
	protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;
    protected String projectPath = System.getProperty("user.dir");
    
    public void initializeDriver() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-application-cache");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        properties = new Properties();
        properties.load(new FileInputStream(projectPath + "./FileStorage/credential.file"));
    }
    
    public void sendKeysToElement(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Element not found or not visible: " + e.getMessage());
            
        }
    }
    public void clickElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            System.out.println("Element not clickable or not found: " + e.getMessage());
         
            
        }
        
    }
    public void sleep(int text) throws InterruptedException {
    	TimeUnit.SECONDS.sleep(text);
		
	}

}
