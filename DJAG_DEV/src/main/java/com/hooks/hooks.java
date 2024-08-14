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

	@FindBy(xpath = "//span[contains(text(),'Next')]")
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

	@FindBy(xpath = "//input[@id='txtinputbrfdyn_FirstNamePlaintiff']")
	public static WebElement LPFname ;

	@FindBy(xpath = "//input[@id='txtinputbrfdyn_LastNamebusinessPlaintiff']")
	public static WebElement LPLname ;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	public static WebElement Email1 ;

	@FindBy(xpath = "//input[@id='txtinputbrfdyn_phoneNoPlaintiff']")
	public static WebElement plaintifPHNO ;

	@FindBy(xpath = "//input[@id='txtinputbrfdyn_AgentFirstName']")
	public static WebElement LPFirstname ;

	@FindBy(xpath = "//input[@id='txtinputbrfdyn_AgentFamilyName']")
	public static WebElement LPlastname ;


	@FindBy(xpath = "//input[@id='txtSearchbrfdyn_AddressSearchRep']")
	public static WebElement Serachaddress2 ;

	@FindBy(xpath = "(//*[@data-icon='search'])[3]")
	public static WebElement Searchicon3 ;

	@FindBy(xpath = "(//span[contains(text(),'Select')])[60]")
	public static WebElement AddressB ;

	@FindBy(xpath = "(//input[@type='email'])[2]")
	public static WebElement Email2 ;

	@FindBy(xpath = "//input[@id='txtinputbrfdyn_question37']")
	public static WebElement PractitionerPhNo ;
	
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_DefendantName']")
	public static WebElement DefName ;
	
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_LastNamedefendant']")
	public static WebElement DeLName ;
	
	@FindBy(xpath = "//input[@id='txtSearchbrfdyn_addressSearchOfDefendant']")
	public static WebElement DefAddressSearch ;
	
	@FindBy(xpath = "//input[@id='rc_select_11']")
	public static WebElement heardingcourt ;
	
	@FindBy(xpath = "//div[contains(text(),'Atherton Magistrates Court')]")
	public static WebElement heardingcourtop1 ;
	

	@FindBy(xpath = "//span[contains(text(),'Review application')]")
	public static WebElement Reviewapplication ;
	
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	public static WebElement Submit ;
	
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	public static WebElement Ok ;
	@FindBy(xpath = "//div[text()='Originating application']")

	public  static WebElement OriginatingApp;

	

	@FindBy(xpath = "//span[text()='No']")

	public static WebElement AboutYouNo ;

	

	@FindBy(xpath = "//label[@id='drpbrfdyn_AppType']/following-sibling::div")

	public static WebElement selectorigiapp;

	

	@FindBy(xpath = "//div[@title='Births, Deaths and Marriages Registration Act (QLD)']/div")

	public static WebElement birth;



	@FindBy(xpath = "(//input[@class='ant-input'])[1]")

    public static WebElement firstname;

	@FindBy(xpath = "(//input[@class='ant-input'])[3]")

	public static WebElement lastname;

	@FindBy(xpath = "(//input[@class='ant-input'])[5]")

	public static WebElement address;
	
	@FindBy(xpath = "(//input[@class='ant-input'])[4]")

	public static WebElement address4;
	
	@FindBy(xpath = "(//input[@class='ant-input'])[8]")

	public static WebElement suburb;

	@FindBy(xpath = "//div[@name='stateOfPlaintiff']")

	public static WebElement state;

	@FindBy(xpath = "//div[text()='Victoria']")

	public static WebElement victoria; 

	@FindBy(xpath = "//div[@name='postalOfPlaintiff']")

	public static WebElement postal;

	@FindBy(xpath = "(//input[@class='ant-input'])[9]")

	public static WebElement mail;

	@FindBy(xpath="(//input[@class='ant-input'])[10]")

	public static WebElement phnumber;
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_question16']")

	public static WebElement PetitionerPhNo ;
	@FindBy(xpath = "(//input[@placeholder='Address search'])[1]")

	public static WebElement respondentaddress ;
	@FindBy(xpath ="(//input[@role='combobox'])[4]")

	public static WebElement courtlocation;

	@FindBy(xpath="//div[@title='Atherton Magistrates Court']")

	public static WebElement courtinul;

	@FindBy(xpath = "//*[@id='brfdyn_form2ClaimFile']/div[2]/div/div/div[1]/div/button")

	public static WebElement form5;

	@FindBy(xpath = "//span[text()='Review application']")

	public static WebElement reviewapp;

	@FindBy(xpath="//span[text()='Submit']")

	public static WebElement submit;

	@FindBy(xpath="//span[text()='OK']")

	public static WebElement ok;

	@FindBy(xpath="//span[text()='Pay later']/parent::button")

	public static WebElement paylater;

	@FindBy(xpath="//span[text()='Pay']")

	public static WebElement pay;

	@FindBy(xpath = "(//span[contains(text(),'Select')])[6]")

	public static WebElement AddressC ;
	
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_AgentFirstName']")

	public static WebElement LPeFname ;
	
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_AgentFamilyName']")

	public static WebElement LPeLname ;
	
	@FindBy(xpath = "//div[contains(text(),'Queensland Civil and Administrative Tribunal')]")

	public static WebElement QCAT ;
	
	@FindBy(xpath = "//div[contains(text(),'Residential tenancy disputes')]")

	public static WebElement RTD ;
	
	@FindBy(xpath = "//span[contains(text(),'Tenant')]")

	public static WebElement Tenant ;
	
	@FindBy(xpath = "(//button[@tabindex='-1\'])[1]")
	public static WebElement others ;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public static WebElement Checkbox1 ;
	
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_expiryDateForNoticeToLeave']")
	public static WebElement interestDate ;
	
	@FindBy(xpath = "//textarea[@class='ant-input textarea-Width']")
	public static WebElement ReasonFA ;
	
	@FindBy(xpath = "(//span[contains(text(),'No')])[8]")
	public static WebElement No8 ;
	
	@FindBy(xpath = "(//button[@aria-label='Choose file'])[1]")
	public static WebElement choosefile ;
	
	@FindBy(xpath = "//span[contains(text(),'Fixed term (eg: 6 months)')]")
	public static WebElement typeofLease ;
	
	@FindBy(xpath = "//input[@id='txtinputbrfdyn_dateOfLeaseAgreement']")
	public static WebElement leaseDate ;
	
	@FindBy(xpath = "(//span[contains(text(),'No')])[1]")
	public static WebElement No1 ;
	
	@FindBy(xpath = "//input[@id='txtSearchbrfdyn_propertyAddressSearch']")
	public static WebElement propertyAddress ;
	
	@FindBy(xpath = "(//input[@id='rc_select_9'])[1]")
	public static WebElement courtLocation ;
	
	@FindBy(xpath = "//div[contains(text(),'4805 Bowen Magistrates Court')]")
	public static WebElement courtLocationop1 ;
	
	@FindBy(xpath = "(//span[@unselectable=\"on\"])[11]")
	public static WebElement straitIslander ;
	
	@FindBy(xpath = "(//div[contains(text(),'No')])[3]")
	public static WebElement straitIslanderop1 ;
	
	
	
	
	



	
}
