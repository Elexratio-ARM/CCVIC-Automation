Feature: User Login

  Background: 
    Given Launch the url in Chrome
    Then Enter the credentials and click the signin button
    When Click the Respond Application tab

  @CrimeSubpoenaedNotFound
  Scenario: Subpoenaed Material NOT Found in Respond to Subpoena using crime case number
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then provide review response and click submit

  @CivilSubpoenaedNotFound
  Scenario: Subpoenaed Material Not Found using civil case number
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeObjectToComplyWithTheSubpoena
  Scenario: Object to comply with the Subpoena in Respond to Subpoena using crime case number
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Select the reason for the objection
    And upload a supporting letter
    Then provide review response and click submit

  @CivilObjectToComplyWithTheSubpoena
  Scenario: Object to comply with the Subpoena using civil case number
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Select the reason for the objection
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeRespondTo32CApplication
  Scenario: Respond to 32c Application using crime case number
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit

  @CivilSubmitSubpoenaedMaterial
  Scenario: Submit Subpoenaed Material
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Upload Subpoenaed Material and enter the subpoenaed Description
    And select I do not wish to upload any redacted versions
    When select I do not object to inspection
    And upload a supporting letter
    Then Select yes on Medical Material and click on compleate
    Then provide review response and click submit

  @AppealSubpoenaedNotFound
  Scenario: Subpoenaed Material NOT Found in Respond to Subpoena using appeal case number
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then provide review response and click submit

  @AppealRespondTo32CApplication
  Scenario: Respond to 32c Application using appeal case number
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit

  @AppealObjectToComplyWithTheSubpoena
  Scenario: Object to comply with the Subpoena in Respond to Subpoena using crime case number
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Select the reason for the objection
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeSubmitSubpoenaedMaterial
  Scenario: Submit Subpoenaed Material
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit
