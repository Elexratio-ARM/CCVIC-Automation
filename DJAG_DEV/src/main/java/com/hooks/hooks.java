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
	
	@FindBy(xpath = "//h3[text()='Start case']")
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
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	public static WebElement ChecklistNext ;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public static WebElement creditcardcheckbox ;
	
	@FindBy(xpath = "(//span[contains(text(),'Yes')])[1]")
	public static WebElement YES1 ;
	
	@FindBy(xpath = "(//span[contains(text(),'Yes')])[2]")
	public static WebElement YES2 ;
	
	@FindBy(xpath = "(//span[contains(text(),'No')])[2]")
	public static WebElement No2 ;
	
	@FindBy(xpath = "(//input[@class='ant-input'])[1]")
	public static WebElement Fromdate ;
	
	@FindBy(xpath = "(//input[@class='ant-input'])[2]")
	public static WebElement TODate ;
	
	@FindBy(xpath = "(//input[@class='ant-input'])[3]")
	public static WebElement Suburb ;
	
	@FindBy(xpath = "(//input[@role='spinbutton'])[1]")
	public static WebElement claiming1 ;
	
	@FindBy(xpath = "(//input[@role='spinbutton'])[2]")
	public static WebElement claiming2 ;
	
	@FindBy(xpath = "(//span[contains(text(),'Yes')])[3]")
	public static WebElement Yes3 ;
	
	@FindBy(xpath = "(//span[contains(text(),'No')])[4]")
	public static WebElement No4 ;
	
	@FindBy(xpath = "//span[contains(text(),'Next ')]")
	public static WebElement next ;
	
	@FindBy(xpath = "//span[contains(text(),'No')]")
	public static WebElement No ;
	
	@FindBy(xpath = "//textarea[@class='ant-input textarea-Width']")
	public static WebElement ClaimPact ;
	
	@FindBy(xpath = "(//input[@class='ant-input'])[1]")
	public static WebElement Incapacity ;
	
	@FindBy(xpath = "//span[contains(text(),'Individual')]")
	public static WebElement Individual ;
	
	@FindBy(xpath = "(//input[@placeholder='Address look-up'])[1]")
	public static WebElement Serachaddress1 ;
	
	@FindBy(xpath = "(//*[@data-icon='search'])[2]")
	public static WebElement Searchicon2 ;
	
	@FindBy(xpath = "(//span[contains(text(),'Select')])[5]")
	public static WebElement AddressA ;
	
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_AgentFirstName']")
	public static WebElement LPFname ;
	
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_AgentFamilyName']")
	public static WebElement LPLname ;
		
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_AgentFamilyName']")
	public static WebElement Serachaddress2 ;

	@FindBy(xpath = "(//*[@data-icon='search'])[3]")
	public static WebElement Searchicon3 ;
	
	

	

}
