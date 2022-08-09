package dsl.curdoperations;

import dsl.response.entities.models.ResponseModel;

public interface CurdProtocol {
    ResponseModel addNewIssueToGitLab(String title);
    ResponseModel searchIssue();
    ResponseModel unauthorizedAccess();
    ResponseModel searchIssueWithSpecificState(String issueState);
    ResponseModel addNewIssueWithoutTitle();
    ResponseModel editIssues(String issueId, String editEvents);
    ResponseModel deleteIssue(String issueId);
}
