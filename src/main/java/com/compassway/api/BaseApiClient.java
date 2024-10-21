package com.compassway.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseApiClient {

    private final RequestSpecification requestSpecification;

    public BaseApiClient(String baseUri) {
        RestAssured.baseURI = baseUri;
        requestSpecification = given()
                .contentType("application/json")
                .log().all();
    }

    public void setHeaders(Map<String, String> headers) {
        requestSpecification.headers(headers);
    }

    public void setBasicAuth(String username, String password) {
        requestSpecification.auth().basic(username, password);
    }

    public void setAuthToken(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    public <T> T get(String endpoint, Class<T> responseClass, int expectedStatusCode) {
        Response response = requestSpecification
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();

        assertThat(response.getStatusCode())
                .describedAs("Invalid status code. Expected %s but was %s. Response:\n%s",
                        expectedStatusCode, response.getStatusCode(), response.asString())
                .isEqualTo(expectedStatusCode);
        return response.as(responseClass);
    }

    public <T, R> R post(String endpoint, T payload, Class<R> responseClass, int expectedStatusCode) {
        Response response = requestSpecification
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();

        assertThat(response.getStatusCode())
                .describedAs("Invalid status code. Expected %s but was %s. Response:\n%s",
                        expectedStatusCode, response.getStatusCode(), response.asString())
                .isEqualTo(expectedStatusCode);
        return response.as(responseClass);
    }

    public <T, R> R put(String endpoint, T payload, Class<R> responseClass, int expectedStatusCode) {
        Response response = requestSpecification
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();

        assertThat(response.getStatusCode())
                .describedAs("Invalid status code. Expected %s but was %s. Response:\n%s",
                        expectedStatusCode, response.getStatusCode(), response.asString())
                .isEqualTo(expectedStatusCode);
        return response.as(responseClass);
    }

    public <R> R delete(String endpoint, Class<R> responseClass, int expectedStatusCode) {
        Response response = requestSpecification
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();

        assertThat(response.getStatusCode())
                .describedAs("Invalid status code. Expected %s but was %s. Response:\n%s",
                        expectedStatusCode, response.getStatusCode(), response.asString())
                .isEqualTo(expectedStatusCode);
        return response.as(responseClass);
    }

    public void delete(String endpoint, int expectedStatusCode) {
        Response response = requestSpecification
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();

        assertThat(response.getStatusCode())
                .describedAs("Invalid status code. Expected %s but was %s. Response:\n%s",
                        expectedStatusCode, response.getStatusCode(), response.asString())
                .isEqualTo(expectedStatusCode);
    }
}