package dsl.curdoperations.usecases.search;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchIssueFlow {
    private final transient SearchIssue searchIssue = new SearchIssue();

    @Given("the authorized user is searching for the list of issues")
    public void theAuthenticatedUserSearchAnIssue(){
        searchIssue.searchIssue();
    }

    @Then("the search is successful")
    public void searchIssueIsSuccessful() {
        searchIssue.validateSearchIssueStatus();
    }

    @Given("the unauthorized user is try to access the gitlab API")
    public void theUnauthorizedUserCheck(){
        searchIssue.unauthorizedAccess();
    }

    @Then("the user is not allowed to access the API")
    public void unauthorizedStatusCheck() {
        searchIssue.unauthorizedStatusCode();
    }

    @And("the user can see the error message {string} in the response")
    public void unauthorizedMessage(String errorMessage){
        searchIssue.unauthorizedErrorMessageCheck(errorMessage);
    }

    @Given("the authorized user is searching for the list of issues with specific {string}")
    public void searchIssueWithSpecificState(String issueState){
        searchIssue.searchIssueWithSpecificState(issueState);
    }

    @And("the user can able to see the list of {string} issues")
    public void checkIssueState(String issueState){
        searchIssue.verifyIssueState(issueState);
    }


}
