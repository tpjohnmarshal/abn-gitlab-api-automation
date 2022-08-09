$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/GitLabApiValidations.feature");
formatter.feature({
  "name": "Validate Git Lab API CURD Operations",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    }
  ]
});
formatter.scenario({
  "name": "Verify that the unauthorized user is not allowed to access the gitLab API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1001"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the unauthorized user is try to access the gitlab API",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchIssueFlow.theUnauthorizedUserCheck()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is not allowed to access the API",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchIssueFlow.unauthorizedStatusCheck()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user can see the error message \"401 Unauthorized\" in the response",
  "keyword": "And "
});
formatter.match({
  "location": "SearchIssueFlow.unauthorizedMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that the authorized user is able to see the list of issues he has access to",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1002"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is searching for the list of issues",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchIssueFlow.theAuthenticatedUserSearchAnIssue()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the search is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchIssueFlow.searchIssueIsSuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify that the authorized user is able to see the list of issues with specific state",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TEST_ABN_1003"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is searching for the list of issues with specific \"\u003cstatus\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "the search is successful",
  "keyword": "Then "
});
formatter.step({
  "name": "the user can able to see the list of \"\u003cstatus\u003e\" issues",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "status"
      ]
    },
    {
      "cells": [
        "closed"
      ]
    },
    {
      "cells": [
        "opened"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify that the authorized user is able to see the list of issues with specific state",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1003"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is searching for the list of issues with specific \"closed\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchIssueFlow.searchIssueWithSpecificState(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the search is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchIssueFlow.searchIssueIsSuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user can able to see the list of \"closed\" issues",
  "keyword": "And "
});
formatter.match({
  "location": "SearchIssueFlow.checkIssueState(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that the authorized user is able to see the list of issues with specific state",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1003"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is searching for the list of issues with specific \"opened\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchIssueFlow.searchIssueWithSpecificState(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the search is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchIssueFlow.searchIssueIsSuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user can able to see the list of \"opened\" issues",
  "keyword": "And "
});
formatter.match({
  "location": "SearchIssueFlow.checkIssueState(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that the authorized user is able to create a new issue",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1004"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is trying to create a new issue with  title \"ABN_Create_a_test issue\"",
  "keyword": "Given "
});
formatter.match({
  "location": "AddIssueFlow.theAuthenticatedUserCreatesAnIssue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is able to create the issue successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AddIssueFlow.addIssueIsSuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user can see the issue id in the response",
  "keyword": "And "
});
formatter.match({
  "location": "AddIssueFlow.aCustomerIsRegisteredWithAddresses()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that the authorized user is not allowed to create an issue without title",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1005"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is trying to create a new issue without title",
  "keyword": "Given "
});
formatter.match({
  "location": "AddIssueFlow.createIssueWithoutTitle()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is not allowed to create the issue",
  "keyword": "Then "
});
formatter.match({
  "location": "AddIssueFlow.verifyAddIssueWithoutTitleStatusCode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"title is missing\" is displayed in the response",
  "keyword": "And "
});
formatter.match({
  "location": "AddIssueFlow.verifyAddIssueWithoutTitleErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify that the authorized user is able to update an issue",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TEST_ABN_1006"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is trying to update the issue \"\u003cissue_id\u003e\" with \"\u003cedit_events\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "the user is getting the response as \"\u003cresponse_status\u003e\" during \"EDIT\"",
  "keyword": "Then "
});
formatter.step({
  "name": "the \"\u003cmessage\u003e\" is displayed in the response during \"EDIT\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "issue_id",
        "edit_events",
        "response_status",
        "message"
      ]
    },
    {
      "cells": [
        "1",
        "state_event\u003dclose,labels\u003dbug",
        "SUCCESS",
        "SUCCESS"
      ]
    },
    {
      "cells": [
        "100",
        "state_event\u003dclose",
        "NOT_FOUND",
        "404 Not found"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify that the authorized user is able to update an issue",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1006"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is trying to update the issue \"1\" with \"state_event\u003dclose,labels\u003dbug\"",
  "keyword": "Given "
});
formatter.match({
  "location": "EditIssueFlow.theAuthenticatedUserCreatesAnIssue(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is getting the response as \"SUCCESS\" during \"EDIT\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditIssueFlow.verifyEditIssueStatus(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"SUCCESS\" is displayed in the response during \"EDIT\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditIssueFlow.verifyEditIssueMessage(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that the authorized user is able to update an issue",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1006"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is trying to update the issue \"100\" with \"state_event\u003dclose\"",
  "keyword": "Given "
});
formatter.match({
  "location": "EditIssueFlow.theAuthenticatedUserCreatesAnIssue(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is getting the response as \"NOT_FOUND\" during \"EDIT\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditIssueFlow.verifyEditIssueStatus(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"404 Not found\" is displayed in the response during \"EDIT\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditIssueFlow.verifyEditIssueMessage(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify that the authorized user is able to delete an issue",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TEST_ABN_1007"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is trying to delete the issue \"\u003cissue_id\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "the user is getting the response as \"\u003cresponse_status\u003e\" during \"DELETE\"",
  "keyword": "Then "
});
formatter.step({
  "name": "the \"\u003cmessage\u003e\" is displayed in the response during \"DELETE\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "issue_id",
        "response_status",
        "message"
      ]
    },
    {
      "cells": [
        "12",
        "DELETE_SUCCESS",
        "SUCCESS"
      ]
    },
    {
      "cells": [
        "100",
        "NOT_FOUND",
        "404 Not found"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify that the authorized user is able to delete an issue",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1007"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is trying to delete the issue \"12\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DeleteIssueFlow.theAuthenticatedUserCreatesAnIssue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is getting the response as \"DELETE_SUCCESS\" during \"DELETE\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditIssueFlow.verifyEditIssueStatus(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"SUCCESS\" is displayed in the response during \"DELETE\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditIssueFlow.verifyEditIssueMessage(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that the authorized user is able to delete an issue",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@REQ_GIT_LAB_API"
    },
    {
      "name": "@TEST_ABN_1007"
    },
    {
      "name": "@automated"
    }
  ]
});
formatter.step({
  "name": "the authorized user is trying to delete the issue \"100\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DeleteIssueFlow.theAuthenticatedUserCreatesAnIssue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is getting the response as \"NOT_FOUND\" during \"DELETE\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditIssueFlow.verifyEditIssueStatus(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"404 Not found\" is displayed in the response during \"DELETE\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditIssueFlow.verifyEditIssueMessage(String,String)"
});
formatter.result({
  "status": "passed"
});
});