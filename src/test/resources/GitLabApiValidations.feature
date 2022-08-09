@REQ_GIT_LAB_API
Feature: Validate Git Lab API CURD Operations

  @TEST_ABN_1001 @automated
  Scenario: Verify that the unauthorized user is not allowed to access the gitLab API
    Given the unauthorized user is try to access the gitlab API
    Then the user is not allowed to access the API
    And the user can see the error message "401 Unauthorized" in the response

  @TEST_ABN_1002 @automated
  Scenario: Verify that the authorized user is able to see the list of issues he has access to
    Given the authorized user is searching for the list of issues
    Then the search is successful

  @TEST_ABN_1003 @automated
  Scenario Outline: Verify that the authorized user is able to see the list of issues with specific state
    Given the authorized user is searching for the list of issues with specific "<status>"
    Then the search is successful
    And the user can able to see the list of "<status>" issues

    Examples:
      | status  |
      | closed  |
      | opened  |

  @TEST_ABN_1004 @automated
  Scenario: Verify that the authorized user is able to create a new issue
    Given the authorized user is trying to create a new issue with  title "ABN_Create_a_test issue"
    Then the user is able to create the issue successfully
    And the user can see the issue id in the response

  @TEST_ABN_1005 @automated
  Scenario: Verify that the authorized user is not allowed to create an issue without title
    Given the authorized user is trying to create a new issue without title
    Then the user is not allowed to create the issue
    And the error message "title is missing" is displayed in the response

  @TEST_ABN_1006 @automated
  Scenario Outline: Verify that the authorized user is able to update an issue
    Given the authorized user is trying to update the issue "<issue_id>" with "<edit_events>"
    Then the user is getting the response as "<response_status>" during "EDIT"
    And the "<message>" is displayed in the response during "EDIT"

    Examples:
      | issue_id | edit_events                  | response_status | message       |
      | 1        | state_event=close,labels=bug | SUCCESS         | SUCCESS       |
      | 100      | state_event=close            | NOT_FOUND       | 404 Not found |

  @TEST_ABN_1007 @automated
  Scenario Outline: Verify that the authorized user is able to delete an issue
    Given the authorized user is trying to delete the issue "<issue_id>"
    Then the user is getting the response as "<response_status>" during "DELETE"
    And the "<message>" is displayed in the response during "DELETE"

    Examples:
      | issue_id | response_status | message       |
      | 12        | DELETE_SUCCESS  | SUCCESS       |
      | 100      | NOT_FOUND       | 404 Not found |