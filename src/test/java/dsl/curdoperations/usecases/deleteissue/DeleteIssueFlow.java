package dsl.curdoperations.usecases.deleteissue;

import io.cucumber.java.en.Given;

public class DeleteIssueFlow {
    private final transient DeleteIssue deleteIssue = new DeleteIssue();

    @Given("the authorized user is trying to delete the issue {string}")
    public void theAuthenticatedUserCreatesAnIssue(String issueId){
        deleteIssue.deleteIssue(issueId);
    }
}
