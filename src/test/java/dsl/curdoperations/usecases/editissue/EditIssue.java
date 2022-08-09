package dsl.curdoperations.usecases.editissue;

import dsl.configuration.StatusCodes;
import dsl.curdoperations.CurdFactory;
import dsl.curdoperations.CurdProtocol;
import dsl.curdoperations.usecases.deleteissue.DeleteIssue;
import dsl.response.entities.models.ResponseModel;
import org.junit.Assert;

public class EditIssue {
    public static transient ResponseModel responseModel;
    transient CurdProtocol curdOperations = CurdFactory.getProtocol();

    public void editIssue(String issueId, String editEvents){
        responseModel = curdOperations.editIssues(issueId, editEvents);
    }

    public void verifyEditIssueResponseStatus(String responseStatus, String event){
        switch (responseStatus) {
            case "SUCCESS":
                Assert.assertEquals("Edit issue failed", StatusCodes.SUCCESS.getValue(), responseModel.getStatusCode());
                break;
            case "NOT_FOUND":
                switch (event) {
                    case "EDIT":
                        Assert.assertEquals("Edit issue failed", StatusCodes.NOT_FOUND.getValue(), EditIssue.responseModel.getStatusCode());
                        break;
                    case "DELETE":
                        Assert.assertEquals("Edit issue failed", StatusCodes.NOT_FOUND.getValue(), DeleteIssue.responseModel.getStatusCode());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid event called");
                }
                break;
            case "DELETE_SUCCESS":
                Assert.assertEquals("Edit issue failed", StatusCodes.DELETE_SUCCESS.getValue(), DeleteIssue.responseModel.getStatusCode());
                break;
            default:
                throw new IllegalArgumentException("Edit Issue: Invalid response status");
        }
    }

    public void verifyEditIssueResponseMessage(String message, String event){
        switch (message) {
            case "SUCCESS":
                break;
            case "404 Not found":
                switch (event){
                    case "EDIT":
                        Assert.assertEquals("Edit Issue: Invalid message displayed", message, EditIssue.responseModel.getMessage());
                        break;
                    case "DELETE":
                        Assert.assertEquals("Edit Issue: Invalid message displayed", "404 Issue Not Found", DeleteIssue.responseModel.getMessage());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid event called");
                }
                break;
            default:
                throw new IllegalArgumentException("Edit Issue: Invalid response error message");
        }
    }
}
