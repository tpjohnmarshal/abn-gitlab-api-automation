package dsl.curdoperations.usecases.editissue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EditIssueFlow {
    private final transient EditIssue editIssue = new EditIssue();

    @Given("the authorized user is trying to update the issue {string} with {string}")
    public void theAuthenticatedUserCreatesAnIssue(String issueId, String editEvents){
        editIssue.editIssue(issueId, editEvents);
    }

    @Then("the user is getting the response as {string} during {string}")
    public void verifyEditIssueStatus(String responseStatus, String event) {
        editIssue.verifyEditIssueResponseStatus(responseStatus, event);
    }

    @And("the {string} is displayed in the response during {string}")
    public void verifyEditIssueMessage(String message, String event) {
        editIssue.verifyEditIssueResponseMessage(message, event);
    }
}
