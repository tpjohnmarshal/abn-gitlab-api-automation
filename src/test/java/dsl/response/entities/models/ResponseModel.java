package dsl.response.entities.models;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ResponseModel {
    Integer statusCode;
    Integer issueId;
    String title;
    String message;
    List<String> issueState;
    String errorMessage;
}
