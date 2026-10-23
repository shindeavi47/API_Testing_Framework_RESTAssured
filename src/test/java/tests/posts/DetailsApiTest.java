
package tests.posts;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import framework.RequestSpecFactory;

public class DetailsApiTest {

    @Test
    void shouldReturnExpectedPostId() {

        given()
            .spec(RequestSpecFactory.getRequestSpecification())
            
        .when()
            .get("/posts/1")
            
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }

    @Test
    void shouldReturnExpectedUserId() {

        given()
            .spec(RequestSpecFactory.getRequestSpecification())
            
        .when()
            .get("/posts/1")
            
        .then()
            .statusCode(200)
            .body("userId", equalTo(1));
    }

    @Test
    void shouldReturnNonEmptyTitleAndBody() {

        given()
            .spec(RequestSpecFactory.getRequestSpecification())
            
        .when()
            .get("/posts/1")
            
        .then()
            .statusCode(200)
            .body("title", not(empty()))
            .body("body", not(empty()));
    }
}
