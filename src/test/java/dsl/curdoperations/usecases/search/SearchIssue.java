package dsl.curdoperations.usecases.search;

import dsl.configuration.StatusCodes;
import dsl.curdoperations.CurdFactory;
import dsl.curdoperations.CurdProtocol;
import dsl.response.entities.models.ResponseModel;
import org.junit.Assert;

public class SearchIssue {
    public static transient ResponseModel responseModel;
    transient CurdProtocol curdOperations = CurdFactory.getProtocol();

    public void searchIssue(){
        responseModel = curdOperations.searchIssue();
    }

    public void validateSearchIssueStatus(){
        Assert.assertEquals("Add issue failed", StatusCodes.SUCCESS.getValue(), responseModel.getStatusCode());
    }

    public void unauthorizedAccess(){
        responseModel = curdOperations.unauthorizedAccess();
    }

    public void unauthorizedStatusCode(){
        Assert.assertEquals("Unauthorized access feature failed", StatusCodes.UNAUTHORIZED.getValue(), responseModel.getStatusCode());
    }

    public void unauthorizedErrorMessageCheck(String errorMessage){
        Assert.assertEquals("Invalid unauthorized error message", errorMessage, responseModel.getMessage());
    }

    public void searchIssueWithSpecificState(String issueState){
        responseModel = curdOperations.searchIssueWithSpecificState(issueState);
    }

    public void verifyIssueState(String issueState){
        if(!responseModel.getIssueState().isEmpty()){
            for(String s : responseModel.getIssueState()){
                Assert.assertEquals("Issue state not matched with the search query: ", issueState, s);
            }
        }
    }
}
