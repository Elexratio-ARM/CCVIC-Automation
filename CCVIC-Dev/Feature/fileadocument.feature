Feature: User Login

  Background: 
    Given Launch the url in Chrome
    Then Enter the credentials and click the signin button
   

  @CrimeSubpoenaedNotFound
  Scenario: Subpoenaed Material NOT Found in Respond to Subpoena using crime case number
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then provide review response and click submit

  @CivilSubpoenaedNotFound
  Scenario: Subpoenaed Material Not Found using civil case number
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeObjectToComplyWithTheSubpoena
  Scenario: Object to comply with the Subpoena in Respond to Subpoena using crime case number
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Select the reason for the objection
    And upload a supporting letter
    Then provide review response and click submit

  @CivilRespondTo32CApplication
  Scenario: Respond to 32c Application using civil case number
   When Click the Respond Application tab
    When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeSubmitSubpoenaedMaterial
  Scenario: Submit Subpoenaed Material
   When Click the Respond Application tab
    When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeSubpoenaedNotFound
  Scenario: Subpoenaed Material NOT Found in Respond to Subpoena using crime case number
   When Click the Respond Application tab
    When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeObjectToComplyWithTheSubpoena
  Scenario: Object to comply with the Subpoena in Respond to Subpoena using crime case number
   When Click the Respond Application tab
    When Click the Respond Application tab
   Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Select the reason for the objection
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeRespondTo32CApplication
  Scenario: Respond to 32c Application using crime case number
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit

  @CivilSubmitSubpoenaedMaterial
  Scenario: Submit Subpoenaed Material
   When Click the Respond Application tab
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
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    And upload a supporting letter
    Then provide review response and click submit

  @AppealRespondTo32CApplication
  Scenario: Respond to 32c Application using appeal case number
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit

  @AppealObjectToComplyWithTheSubpoena
  Scenario: Object to comply with the Subpoena in Respond to Subpoena using crime case number
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Select the reason for the objection
    And upload a supporting letter
    Then provide review response and click submit

  @CrimeSubmitSubpoenaedMaterial
  Scenario: Submit Subpoenaed Material
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Upload Subpoenaed Material and enter the subpoenaed Description
    And select I do not wish to upload any redacted versions
    When select I do not object to inspection
    And upload a supporting letter
    Then Select yes on Medical Material and click on compleate
    Then provide review response and click submit

@CrimeSubmitSubpoenaedMaterialWithRedactedfile
  Scenario: Submit Subpoenaed Material
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Upload Subpoenaed Material and enter the subpoenaed Description
     And select I do not wish to upload any redacted versions
    When select I do not object to inspection
    And upload a supporting letter
    Then Select yes on Medical Material and click on compleate
    Then provide review response and click submit
  @CivilRespondTo32CApplication
  Scenario: Respond to 32c Application using civil case number
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the next button
    And choose the judicial order
    Then upload the requested material
    And upload a supporting letter
    Then provide review response and click submit

  @AppealSubmitSubpoenaedMaterial
  Scenario: Submit Subpoenaed Material
   When Click the Respond Application tab
    Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given select the Responsetype
    Then Upload Subpoenaed Material and enter the subpoenaed Description
    And select I do not wish to upload any redacted versions
    When select I do not object to inspection
    And upload a supporting letter
    Then Select yes on Medical Material and click on compleate
    Then provide review response and click submit
  @FileADocumentCoverletter
  Scenario: File a document for coverletter scenarion
    When select case number
    Then Click on file a document
    And upload file on the choose file option
    Then Select document type and provide document name
    But Select medical materials and click on submit

  @FileADocumentObjection
  Scenario: File a document for Objection scenarion
    When select case number
    Then Click on file a document
    And upload file on the choose file option
    Then Select document type and provide document name
    But Select medical materials and click on submit

  @FileADocumentSubpoenaMaterial
  Scenario: File a document for SubpoenaMaterial scenarion
    When select case number
    Then Click on file a document
    And upload file on the choose file option
    Then Select document type and provide document name
    But Select medical materials and click on submit

  @FileADocumentWithdrawal
  Scenario: File a document for Withdrawal scenarion
    When select case number
    Then Click on file a document
    And upload file on the choose file option
    Then Select document type and provide document name
    But Select medical materials and click on submit

  @RequestInspection
  Scenario: Requesting inspection on portal
    When navigate to inspection and click on inspection
    Then Enter the case the number and click on search
    And Select the Subpoena check box and click on inspect
    When Provide Additional information and Select the i agree check box
    Then Select My inspection is urgent and provide date of order made
    And click on Submit and click on ok on the confirmation pop-up

  @FileADocumentforOtherUserinMYOrganazition
  Scenario: Fiel a document for Other user in MY organiation
    Then Navigate to Responses from other
    When select case number
    Then Click on file a document
    And upload file on the choose file option
    Then Select document type and provide document name
    But Select medical materials and click on submit
  #@FileStorageUploadCheck
  #Scenario: Upload file on file storage and check the the fiels get populated on the manage files
    #When click on File storage dropdown and click on upload
    #Then Upload file from local storage
    #And Navigate to file storage, Cofirm the uploaded file is available
