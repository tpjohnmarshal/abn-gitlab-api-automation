package protocoldrivers.httpclient;

import dsl.configuration.Tokens;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.java.Log;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.rest;

@Log
public class HttpClient {
    private final transient String uri;
    private transient RequestSpecification request;


    public HttpClient(String uri) {
        this.uri = uri;
        request = initRequest(this.uri);
    }

    public RequestSpecification initRequest(String uri) {
        return rest().baseUri(uri).given();
    }

    public void setTokenHeader() {
        request = initRequest(this.uri);
        request.header("PRIVATE-TOKEN", Tokens.AUTH_TOKEN.getValue());
    }

    public void setWrongTokenHeader() {
        request.header("PRIVATE-TOKEN", Tokens.WRONG_AUTH_TOKEN.getValue());
    }

    public Response call(Method method, String endpoint) {
        log.info(String.format("Calling: %s %s", method, endpoint));
        Response response = executeCall(method, endpoint);
        return handleResponse(response);
    }

    private Response executeCall(Method method, String endpoint) {
        switch (method) {
            case GET:
                return handleResponse(request.get(endpoint));
            case POST:
                return handleResponse(request.post(endpoint));
            case PATCH:
                return handleResponse(request.patch(endpoint));
            case PUT:
                return handleResponse(request.put(endpoint));
            case DELETE:
                return handleResponse(request.delete(endpoint));
            default:
                throw new IllegalArgumentException("You tried to call a non-existing HTTP method");
        }
    }

    public Response handleResponse(Response response) {
        log.info(
                String.format("Response with status %d and body %s", response.statusCode(), response.body().prettyPrint())
        );
        return response;
    }

    public void setParams(Map<String, String> formParams) {
        for (Map.Entry<String, String> entry : formParams.entrySet()) {
            request.queryParam(entry.getKey(), entry.getValue());
        }
    }
}
