package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body.loading-indicator")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html")));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(text);

	}
	public void clickElement(WebElement element) {


		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body.loading-indicator")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html")));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
	public void sleep(int text) throws InterruptedException {
		TimeUnit.SECONDS.sleep(text);

	}


}
