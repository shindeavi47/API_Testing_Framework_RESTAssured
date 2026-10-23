package tests.posts;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GETApiTest {
	
	@Test
	void statusCodeTest()
	{
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.statusCode(200);
//			.log().all();
		
	}
	
	@Test
	void contentTypeTest()
	{
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.contentType("application/json; charset=utf-8");
//			.log().all();
		
	}
	
	@Test
	void responseBodyTest()
	{
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.statusCode(200)
			.body("$", not(empty()))
			.body("size()", greaterThan(0));
	}
	
	@Test
	void responseBodyContentTest()
	{
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.statusCode(200)
			.body("size()", equalTo(100));
	}
	
	@Test
	void responseBodyContentTest2() {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.statusCode(200)
			.body("userId", everyItem(notNullValue()))
			.body("id", everyItem(notNullValue()))
			.body("title", everyItem(notNullValue()))
			.body("body", everyItem(notNullValue()));
	}
	
	@Test
	void responseBodyContentTest3() {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.statusCode(200)
			.body("userId", everyItem(instanceOf(Integer.class)))
			.body("id", everyItem(instanceOf(Integer.class)))
			.body("title", everyItem(instanceOf(String.class)))
			.body("body", everyItem(instanceOf(String.class)));
	}
	
	@Test
	void responseBodyContentTest4() {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/1")
			
		.then()
			.statusCode(200)
			.body("userId", equalTo(1));
	}
	
	@Test
	void responseBodyContentTest5() {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/1")
		
		.then()
			.statusCode(200)
			.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
	}
}
