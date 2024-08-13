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
	
	@FindBy(xpath = "//h3[text()='Start case'")
	public static WebElement startCase;
	
	@FindBy(xpath = "//input[@id='registry']")
	public static WebElement CourtType;
	
	@FindBy(xpath = "//div[text()='Magistrates Court']")
	public static WebElement MagistratesCourt;
	
	@FindBy(xpath = "//input[@id='caseType']")
	public static WebElement CaseType;
	
	@FindBy(xpath = "//*[text()='Claim']")
	public static WebElement ClaimCase ;

	@FindBy(xpath = "//input[@aria-owns='formType_list']")
	public static WebElement FormTypedropdown ;
	
	@FindBy(xpath = "//div[text()='Guided process - Form 2 Claim and Form 16 Statement of claim']")
	public static WebElement GuidedForm ;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed ')]")
	public static WebElement Proceed ;

	

}
