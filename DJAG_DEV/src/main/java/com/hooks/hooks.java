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

	@FindBy(xpath = "//span[contains(text(),'Next')]/parent::button")
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

	@FindBy(xpath = "//span[contains(text(),'Individual')]/parent::span")
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
	
	@FindBy(xpath = "//span[contains(text(),'Submit')]/parent::button")
	public static WebElement Submit ;
	
	@FindBy(xpath = "//span[contains(text(),'OK')]/parent::button")
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

	@FindBy(xpath="//span[text()='Submit']/parent::button")

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



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//h3[text()='How to join']/parent::a")
	public static WebElement joinacase;
	@FindBy(xpath="//input[@placeholder='Search your Case']")
	public static WebElement joinacasesearch;
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement searchbutton;
	@FindBy(xpath = "(//button[@type='button'])[2]")
	public static WebElement actionselect;
	@FindBy(xpath = "//input[@id='false']/parent::span")
	public static WebElement noforjoincase;
	@FindBy(xpath  = "//input[@aria-label='ApplicantFIrstName ApplicantLastName']")
	public static WebElement ApplicantFIrstNameApplicantLastName;
	@FindBy(xpath = "//input[@name='DefName sdf']")
	public static WebElement Defname;
	@FindBy(xpath = "//input[@id='DocumentType']")
	public static WebElement doctypejoincase;
	@FindBy(xpath = "//div[@title='QCAT Case Access Request']")
	public static WebElement Qcatform;
	@FindBy(xpath = "//div[@title='Form 45 - Application to be joined to a proceeding']")
	public static WebElement Form45form;
	@FindBy(xpath = "//input[@id='FormType']/parent::span/parent::div")
	public static WebElement formtypeQcat;
	@FindBy(xpath = "//div[text()='QCAT Case access request']")
	public static WebElement formforformtypeQcat;
	@FindBy(xpath = "(//button[@type='button'])[10]")
	public static WebElement submitjoinacase;
	@FindBy(xpath = "//input[@id='brfdyn_partiesi_0']")
	public static WebElement ApplicantNameAddressforService;
	@FindBy(xpath = "//button[@aria-label='Choose file']")
	public static WebElement uploadaffidavit;
	@FindBy(xpath = "//input[@id='txtSearchbrfdyn_addressLookup']")
	public static WebElement Addresslookupjoinacase;
	@FindBy(xpath = "//button[@type='button']/parent::span")
	public static WebElement Addresslookupjoinacaseicon;
	@FindBy(xpath = "(//span[text()='Select'])[50]")
	public static WebElement AddressforQCATCaseaccessrequest;
	@FindBy(xpath = "(//span[text()='Review application']/parent::button)")
	public static WebElement reviewapplicationforqcatajc;
	@FindBy(xpath = "(//button[@aria-label='Submit'])[1]")
	public static WebElement  submitforjoinacase;

	@FindBy(xpath = "//span[text()='OK']/parent::button")
	public static WebElement  okforjoinacase;
	
	@FindBy(xpath = "//button[@aria-label='Applicant']")
	public static WebElement Applicantforjoinacase;
	@FindBy(xpath = "//textarea[@autocomplete='stop']")
	public static WebElement textareajoinacase;
	@FindBy(xpath = "//input[@id='txtSearchbrfdyn_addressSearchOfPlaintiff']")
	public static WebElement Addresslookupforjoinacase;
	@FindBy(xpath = "(//button[@type='button'])[8]")
	public static WebElement Addressiconforjoinacase;
	@FindBy(xpath = "(//span[text()='Select'])[5]")
	public static WebElement Addresscjoincase ;
	@FindBy(xpath = "(//input[@value='item1'])[1]")
	public static WebElement informationtrue;
	@FindBy(xpath = "(//input[@value='item1'])[2]")
	public static WebElement informationtrue2;
	
	@FindBy(xpath = "//b[text()='ApplicantFIrstName ApplicantLastName']/parent::span")
	public static WebElement selectrelaventpartyApp;
	
	@FindBy(xpath = "//b[text()='DefName sdf']/parent::span")
	public static WebElement selectrelaventpartyDef;
	
}
