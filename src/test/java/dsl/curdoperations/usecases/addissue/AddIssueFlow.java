package dsl.curdoperations.usecases.addissue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddIssueFlow {
    private final transient AddIssue addIssue = new AddIssue();

    @Given("the authorized user is trying to create a new issue with  title {string}")
    public void theAuthenticatedUserCreatesAnIssue(String title){
        addIssue.addNewIssue(title);
    }

    @Then("the user is able to create the issue successfully")
    public void addIssueIsSuccessful() {
        addIssue.validateAddIssueStatus();
    }

    @And("the user can see the issue id in the response")
    public void aCustomerIsRegisteredWithAddresses() {
        addIssue.validateExistenceOfIssueId();
    }

    @Given("the authorized user is trying to create a new issue without title")
    public void createIssueWithoutTitle(){
        addIssue.addIssueWithoutTitle();
    }

    @Then("the user is not allowed to create the issue")
    public void verifyAddIssueWithoutTitleStatusCode() {
        addIssue.verifyIssueWithoutTitleStatusCode();
    }

    @And("the error message {string} is displayed in the response")
    public void verifyAddIssueWithoutTitleErrorMessage(String errorMessage) {
        addIssue.verifyIssueWithoutTitleErrorMessage(errorMessage);
    }

}
