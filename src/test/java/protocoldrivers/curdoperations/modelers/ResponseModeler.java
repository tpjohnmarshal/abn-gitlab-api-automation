package protocoldrivers.curdoperations.modelers;

import dsl.response.entities.models.ResponseModel;
import io.restassured.response.Response;
import lombok.extern.java.Log;
import protocoldrivers.curdoperations.extractors.ResponseExtractor;

@Log
public class ResponseModeler {
    transient ResponseExtractor responseExtractor = new ResponseExtractor();
    public ResponseModel prepareResponseModelForAddIssue(Response response){
            return ResponseModel
                    .builder()
                    .statusCode(responseExtractor.extractStatusCode(response))
                    .issueId(responseExtractor.extractSIssueId(response))
                    .title(responseExtractor.extractTitle(response))
                    .build();
    }

    public ResponseModel prepareResponseModelForSearchIssue(Response response){
        return ResponseModel
                .builder()
                .statusCode(responseExtractor.extractStatusCode(response))
                .build();
    }

    public ResponseModel prepareResponseModelForUnauthorized(Response response){
        return ResponseModel
                .builder()
                .statusCode(responseExtractor.extractStatusCode(response))
                .message(responseExtractor.extractMessage(response))
                .build();
    }

    public ResponseModel prepareResponseModelForSearchSpecificStateIssue(Response response){
        return ResponseModel
                .builder()
                .statusCode(responseExtractor.extractStatusCode(response))
                .issueState(responseExtractor.extractIssueState(response))
                .build();
    }

    public ResponseModel prepareResponseModelForAddIssueWithoutTitle(Response response){
        return ResponseModel
                .builder()
                .statusCode(responseExtractor.extractStatusCode(response))
                .errorMessage(responseExtractor.extractErrorMessage(response))
                .build();
    }

    public ResponseModel prepareResponseModelForEditIssue(Response response){
        return ResponseModel
                .builder()
                .statusCode(responseExtractor.extractStatusCode(response))
                .message(responseExtractor.extractMessage(response))
                .build();
    }

    public ResponseModel prepareResponseModelForDeleteIssue(Response response){
        return ResponseModel
                .builder()
                .statusCode(responseExtractor.extractStatusCode(response))
                .message(responseExtractor.extractMessage(response))
                .build();
    }
}
