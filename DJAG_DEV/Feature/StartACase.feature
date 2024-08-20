Feature: User Login

  Background: 
    Given Launch the url in Chrome
    And Click on use B2C button
    Then Enter the credentials and click the signin button

  @MagistratesCourtStartACase
  Scenario: Verify the user can able to create a guided claim case
    Given Ckick on start case
    Then Select court type
    And Select the case type
    Then Slect the form type
    But Select next on the Checklist page
    When Provide Claim information
    Then Enter the amount and interest claiming
    And select No on claim any other costs and click on next
    When select yes on  claim settled by Counsel and Enter one fact for claim
    Then Enter  relief being claimed and click on next
    And select yes on Plaintiff legally represented and provide the Plaintiff infomartion
    But Select yes on the defendant sued and provide defendant details
    Then Select the heard Magistrates Court
    When review the cost and click on next
    And Click on review the application and submit

  @Originatingapplication
  Scenario: Verify the user can able to create a case for originatingapplication
    Given Ckick on start case
    Then Select court type
    And Select the case type
    But Select next on the Checklist page
    And click next button on the about you
    And provide the requirements for originating application page
    And select the applicant type provide the  Applicant information
    And select the party type and provide the respondent information
    Then select the court location and upload the document and click review button
    Then click submit button and click ok button and click pay later button

  @QCATResidentialTenancyDisputes
  Scenario: Verify the user can able to create a Residential tenancy disputes case in QCAT
    Given Ckick on start case
    Then Select court type
    And Select the case type
    But Select next on the Checklist page
    Then Select tenant on making the application
    And Select Tribunal order on orders and Yes on form20
    When provide date the Notice and upload form20 file
    Then Enter the reason you are applying and click next
    Then Enter the date lease agreement and click on next
    When select yes on seeking cost and upload the supporting file
    Then select yes on property information and provide properties details
    And Select the court location on click on next
    When Fill the applicant details
    Then Fill the respondent details
    And Select Yes on lodge and pay and review the application
    Then click on submit

  @JoinACaseQCAT
  Scenario: join a case no to Are you already a party or a representative to the case checkbox
    And click join a case tab and enter LodNumber and click search button
    And click select button and click are you already a party or not
    And select the document type and form type
    And select parties in address for service page
    And upload affidavit for address for service page
    And provide address for address for service page and click review application button

  @JoinACaseForm45
  Scenario: join a case no to Are you already a party or a representative to the case checkbox
    And click join a case tab and enter LodNumber and click search button
    And click select button and click are you already a party or not
    And select the document type and form type
    But Select next on the Checklist page
    And select the role and provide the address
    And select the interpreter required or not
    And select the checkboxes for acknowledgement
    And click reviewapplication and click submit and then click ok

  @JoinACaseApplicant
  Scenario: join a case no to Are you already a party or a representative to the case checkbox
    And click join a case tab and enter LodNumber and click search button
    And click select button and click are you already a party or not
    And select relevant party
    And click submit and click ok

  @JoinACaseDefantant
  Scenario: join a case no to Are you already a party or a representative to the case checkbox
    And click join a case tab and enter LodNumber and click search button
    And click select button and click are you already a party or not
    And select relevant party
    And click submit and click ok
