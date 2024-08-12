package com.hooks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class hooks {
	@FindBy(xpath =  "//button[@class='ant-btn ant-btn-default']")
	public static WebElement b2c;
	
	
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement email;
	 
	@FindBy(xpath = "//input[@id='password']")
	public static WebElement password;
	
	@FindBy(xpath = "//button[@id='next']")
	public static WebElement sigin;
}
