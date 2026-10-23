package tests.posts;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class NegativeApiTest {
	
	@Test
	void return404forNonExistencePost() {
		
		given()
	
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/999")	
		
		.then()
			.statusCode(404);
	}
	
	@Test
	void return404forNegativePostId() {
		
		given()
	
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/-1")	
		
		.then()
			.statusCode(404);
	}
	
	@Test
	void return404forNonNumericPostId() {
		
		given()
	
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/abc")	
		
		.then()
			.statusCode(404);
	}

}
