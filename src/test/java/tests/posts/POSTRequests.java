
package tests.posts;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import framework.client.ApiClient;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class POSTRequests {
    @Test
    void shouldCreateNewPost() {

        Map<String, Object> requestBody = new HashMap<>();
        
        requestBody.put("userId", 1);
        requestBody.put("title", "REST Assured Practice");
        requestBody.put("body", "Learning API automation");

        Response response = ApiClient.post("/posts", requestBody);

        response.then()
            .statusCode(201)
            .body("userId", equalTo(1))
            .body("title", equalTo("REST Assured Practice"))
            .body("body", equalTo("Learning API automation"))
            .body("id", notNullValue())
        	.log().all();
    }
}
