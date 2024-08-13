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
    And select yes on claim any other costs and click on next
