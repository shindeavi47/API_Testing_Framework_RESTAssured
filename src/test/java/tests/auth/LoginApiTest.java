package tests.auth;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginApiTest {

	
    @Test
    void shouldLoginSuccessfullyAndReturnAccessToken() {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", "emilys");
        requestBody.put("password", "emilyspass");

        given()
            .baseUri("https://dummyjson.com")
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/auth/login")
        .then()
            .statusCode(200)
            .body("username", equalTo("emilys"))
            .body("accessToken", not(empty()))
        	.log().all();
    }
}
