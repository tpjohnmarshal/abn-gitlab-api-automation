package protocoldrivers.curdoperations.extractors;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class ResponseExtractor {
    public Integer extractStatusCode(Response response) {
        return response.getStatusCode();
    }

    public Integer extractSIssueId(Response response) {
        return JsonPath.given(response.asString()).get("iid");
    }

    public String extractTitle(Response response) {
        return JsonPath.given(response.asString()).get("title");
    }

    public String extractMessage(Response response) {
        try {
            return JsonPath.given(response.asString()).get("message");
        } catch (NullPointerException | JsonPathException e) {
            return null;
        }
    }

    public List<String> extractIssueState(Response response){
        JsonPath jsonPathEvaluator = response.jsonPath();
        return new ArrayList<>(jsonPathEvaluator.getList("state"));
    }

    public String extractErrorMessage(Response response) {
        return JsonPath.given(response.asString()).get("error");
    }
}
