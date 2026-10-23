package GETRequests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * free_user_3KmKNKAYHTnsbb4I1cQzCNmA4g4
given()
    content type, set cookies, add auth, add param, set headers info, etc.

when()
    get, post, put, delete

then()
    validate status code, extract response,
    extract headers, cookies & response body.
*/

public class HTTPRequests {
	
	@Test
	void getUser()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200);
//			.log().all();
		
	}
	
	@Test
	void createUser()
	{
		given()
			.contentType("application/json")
			.body("{\n" +
				"  \"name\": \"morpheus\",\n" +
				"  \"job\": \"leader\"\n" +
				"}")
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
//			.log().all();
	}
			
}