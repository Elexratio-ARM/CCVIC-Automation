Feature: User Login

  Background: 
    Given Launch the url in Chrome
    Then Enter the credentials and click the signin button
    When Click the Respond Application tab

  @CrimeSubpoenaedNotFound
  Scenario: Subpoenaed Material NOT Found in Respond to Subpoena
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then click the checkbox of My submission is urgent due to an order made by the Court
    Then provide review response and click submit

  @CivilSubpoenaedNotFound
  Scenario: Subpoenaed Material Not Found
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then click the checkbox of My submission is urgent due to an order made by the Court
    Then provide review response and click submit

  @CrimeObjectToComplyWithTheSubpoena
  Scenario: Object to comply with the Subpoena in Respond to Subpoena
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Select the reason for the objection
    And upload a supporting letter
    Then provide review response and click submit

  @CivilObjectToComplyWithTheSubpoena
  Scenario: Object to comply with the Subpoena
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Select the reason for the objection
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeRespondTo32CApplication
  Scenario: Respond to 32c Application
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit
