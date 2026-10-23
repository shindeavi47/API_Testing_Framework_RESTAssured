package tests.posts;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FilterApiTest {
	
	@Test
	void PostsByUserId() {
		
		given()
			.queryParam("userId", 1)
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
		
		.then()
			.statusCode(200);
//			.log().all();
	
	}
	
	@Test
	void OnlyPostsForRequestedUser() {
		
		given()
			.queryParam("userId", 1)
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")	
			
		.then()
			.statusCode(200)
			.body("[0].userId", equalTo(1))
			.body("userId", everyItem(equalTo(1)));
	}
	
	@Test
	void ExpectedNumberOfFilteredPosts() {
		
		given()
			.queryParam("userId", 1)
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")	
			
		.then()
			.statusCode(200)
			.body("size()", equalTo(10))
			.body("userId", everyItem(equalTo(1)));
		
	}
	
	@Test
	void EmptyListForUnknownUser() {
		
		given()
			.queryParam("userId", 999)
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")	
			
		.then()
			.statusCode(200)
			.body("size()", equalTo(0));
	}
}
