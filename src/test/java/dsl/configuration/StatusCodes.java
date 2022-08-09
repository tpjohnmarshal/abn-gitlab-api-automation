package dsl.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusCodes {

    SUCCESS_CREATED(201),
    UNAUTHORIZED(401),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    DELETE_SUCCESS(204),
    SUCCESS(200);

    @Getter
    private Integer value;
}
