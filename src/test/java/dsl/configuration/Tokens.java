package dsl.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Tokens {
    AUTH_TOKEN("glpat-dgAQPJxuj5XBaERoMFdx"),
    WRONG_AUTH_TOKEN("invalid-token");

    @Getter
    private String value;

    @Override
    public String toString() {
        return value;
    }
}
