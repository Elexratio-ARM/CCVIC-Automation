Feature: User Login
  Background: 
    Given Launch the url in Chrome
    And Click on use B2C button
    Then Enter the credentials and click the signin button
  @FileaDocumentForMagistrate
  Scenario: file a document for Qcat case number
    Then Search the case number and click file a document tab
    And Select the document group and type and form type and click proceed
    And fill the details of document information
    And click submit and click ok
