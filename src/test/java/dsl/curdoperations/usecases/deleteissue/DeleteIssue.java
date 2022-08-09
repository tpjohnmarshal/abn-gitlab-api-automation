package dsl.curdoperations.usecases.deleteissue;

import dsl.curdoperations.CurdFactory;
import dsl.curdoperations.CurdProtocol;
import dsl.response.entities.models.ResponseModel;

public class DeleteIssue {
    public static transient ResponseModel responseModel;
    transient CurdProtocol curdOperations = CurdFactory.getProtocol();

    public void deleteIssue(String issueId){
        responseModel = curdOperations.deleteIssue(issueId);
    }
}
