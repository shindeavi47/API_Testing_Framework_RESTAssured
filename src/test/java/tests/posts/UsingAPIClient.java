
package tests.posts;

import org.testng.annotations.Test;

import framework.client.ApiClient;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.response.Response;

public class UsingAPIClient {

	@Test
	void shouldReturnExpectedPostId() {

	    Response response = ApiClient.get("/posts/1");

	    assertThat(response.statusCode(), equalTo(200));
	    assertThat(response.jsonPath().getInt("id"), equalTo(1));
	}
	
	@Test
	void titleShouldNotBeEmpty() {

	    Response response = ApiClient.get("/posts/1");

	    assertThat(response.statusCode(), equalTo(200));
	    assertThat(response.jsonPath().getString("title"), equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
	}
	
	@Test
	void shouldReturnExpectedPostIdwithBDD() {

	    Response response = ApiClient.get("/posts/1");

	    response.then()
	        .statusCode(200)
	        .body("id", equalTo(1));
	}

}
