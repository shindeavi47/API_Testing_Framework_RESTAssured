
package framework.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import framework.RequestSpecFactory;

public class ApiClient {

    public static Response get(String endpoint) {

        return given()
                .spec(RequestSpecFactory.getRequestSpecification())
            .when()
                .get(endpoint);
    }
    
    public static Response post(String endpoint, Object requestBody) {

        return given()
                .spec(RequestSpecFactory.getRequestSpecification())
                .body(requestBody)
            .when()
                .post(endpoint);
    }
}

