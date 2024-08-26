package APITest001;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test7_schemaValidation {
	
	@Test
	void jsonSchema() {
		given()
		.when()  
		.get("https://reqres.in/api/users?page=2")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema001.json"));
//		.statusCode(200)
//        .body("page", isA(Integer.class))
//        .body("per_page", isA(Integer.class))
//        .body("total", isA(Integer.class))
//        .body("total_pages", isA(Integer.class))
//        .body("data", hasSize(greaterThan(0)))
//        .body("data.id", everyItem(isA(Integer.class)))
//        .body("data.email", everyItem(isA(String.class)))
//        .body("data.first_name", everyItem(isA(String.class)))
//        .body("data.last_name", everyItem(isA(String.class)))
//        .body("data.avatar", everyItem(isA(String.class)))
//        .body("support.url", isA(String.class))
//        .body("support.text", isA(String.class));
	}

}
