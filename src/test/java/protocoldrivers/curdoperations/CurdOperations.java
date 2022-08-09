package protocoldrivers.curdoperations;

import dsl.configuration.ConfigurationFactory;
import dsl.curdoperations.CurdProtocol;
import dsl.response.entities.models.ResponseModel;
import io.restassured.http.Method;
import io.restassured.response.Response;
import protocoldrivers.curdoperations.modelers.ResponseModeler;
import protocoldrivers.httpclient.HttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CurdOperations implements CurdProtocol {
    transient ResponseModeler responseModeler;
    transient HttpClient client;
    static String gitlabEndpoint = "/api/v4/projects/38435806/issues";

    public CurdOperations(ConfigurationFactory.AutomationURLs automationURLs){
        client = new HttpClient(automationURLs.getGitLabURL());
        responseModeler = new ResponseModeler();
    }

    @Override
    public ResponseModel addNewIssueToGitLab(String title){
        Response response = addIssuePayload(title);
        return responseModeler.prepareResponseModelForAddIssue(response);
    }

    public Response addIssuePayload(String title){
        client.setTokenHeader();
        Map<String, String> params = new HashMap<>();
        params.put("title", title);
        client.setParams(params);
        return client.call(Method.POST, gitlabEndpoint);
    }

    @Override
    public ResponseModel searchIssue(){
        Response response = searchIssuePayload();
        return responseModeler.prepareResponseModelForSearchIssue(response);
    }

    public Response searchIssuePayload(){
        client.setTokenHeader();
        return client.call(Method.GET, gitlabEndpoint);
    }

    @Override
    public ResponseModel unauthorizedAccess(){
        Response response = unauthorizedAccessPayload();
        return responseModeler.prepareResponseModelForUnauthorized(response);
    }

    public Response unauthorizedAccessPayload(){
        client.setWrongTokenHeader();
        return client.call(Method.GET, gitlabEndpoint);
    }

    public ResponseModel searchIssueWithSpecificState(String issueState){
        Response response = searchIssueWithSpecificStatePayload(issueState);
        return responseModeler.prepareResponseModelForSearchSpecificStateIssue(response);
    }

    public Response searchIssueWithSpecificStatePayload(String issueState){
        client.setTokenHeader();
        Map<String, String> params = new HashMap<>();
        params.put("state", issueState);
        client.setParams(params);
        return client.call(Method.GET, gitlabEndpoint);
    }

    @Override
    public ResponseModel addNewIssueWithoutTitle(){
        Response response = addNewIssueWithoutTitlePayload();
        return responseModeler.prepareResponseModelForAddIssueWithoutTitle(response);
    }

    public Response addNewIssueWithoutTitlePayload(){
        client.setTokenHeader();
        return client.call(Method.POST, gitlabEndpoint);
    }

    @Override
    public ResponseModel editIssues(String issueId, String editEvents){
        Response response = editIssuePayload(issueId, editEvents);
        return responseModeler.prepareResponseModelForEditIssue(response);
    }

    public Response editIssuePayload(String issueId, String editEvents){
        client.setTokenHeader();
        List<String> editEventsList = stringToList(editEvents, ",");
        Map<String, String> params = new HashMap<>();
        for(String s: editEventsList){
            params.put(stringToList(s, "=").get(0),stringToList(s, "=").get(1));
        }
        client.setParams(params);
        return client.call(Method.PUT, String.format(gitlabEndpoint+"/%s", issueId));
    }

    public List<String> stringToList(String str, String separator){
        return Stream.of(str.split(separator))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseModel deleteIssue(String issueId){
        Response response = deleteIssuePayload(issueId);
        return responseModeler.prepareResponseModelForDeleteIssue(response);
    }

    public Response deleteIssuePayload(String issueId){
        client.setTokenHeader();
        return client.call(Method.DELETE, String.format(gitlabEndpoint+"/%s", issueId));
    }
}
