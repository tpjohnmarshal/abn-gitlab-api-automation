package dsl.curdoperations.usecases.addissue;

import dsl.configuration.StatusCodes;
import dsl.curdoperations.CurdFactory;
import dsl.curdoperations.CurdProtocol;
import dsl.response.entities.models.ResponseModel;
import org.junit.Assert;

public class AddIssue {
    public static transient ResponseModel responseModel;
    transient CurdProtocol curdOperations = CurdFactory.getProtocol();

    public void addNewIssue(String title){
        responseModel = curdOperations.addNewIssueToGitLab(title);
    }

    public void validateAddIssueStatus(){
        Assert.assertEquals("Add issue failed", StatusCodes.SUCCESS_CREATED.getValue(), responseModel.getStatusCode());
    }

    public void validateExistenceOfIssueId(){
        Assert.assertNotNull("Issue id is null",responseModel.getIssueId());
    }

    public void addIssueWithoutTitle(){
        responseModel = curdOperations.addNewIssueWithoutTitle();
    }

    public void verifyIssueWithoutTitleStatusCode(){
        Assert.assertEquals("Issue added without title", StatusCodes.BAD_REQUEST.getValue(), responseModel.getStatusCode());
    }

    public void verifyIssueWithoutTitleErrorMessage(String errorMessage){
        Assert.assertEquals("Invalid message displayed for issue without title", errorMessage, responseModel.getErrorMessage());
    }
}
