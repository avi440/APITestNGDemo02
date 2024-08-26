package APITest001;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Test8_Authentication {
	
//	@Test(priority = 1)
    void testBasicAuthentication() {
        given()
            .auth().basic("postman", "password")
        .when()
            .get("https://postman-echo.com/basic-auth")
        .then()
            .statusCode(200)
            .body("authenticated", equalTo(true))
            .log().all();
    }

//    @Test(priority = 2)
    void testDigestAuthentication() {
        given()
            .auth().digest("postman", "password")
        .when()
            .get("https://postman-echo.com/basic-auth")
        .then()
            .statusCode(200)
            .body("authenticated", equalTo(true))
            .log().all();
    }
    
//    @Test(priority = 3)
    void testpreemptiveAuthentication() {
        given()
            .auth().preemptive().basic("postman", "password")
        .when()
            .get("https://postman-echo.com/basic-auth")
        .then()
            .statusCode(200)
            .body("authenticated", equalTo(true))
            .log().all();
    }
    
//    @Test(priority = 4)
    void testBearerTokenAuthentication() {
    	
    	String token = "Beare token value was remove , giving error on pushing code";
        given()
            .headers("Authorization","Bearer "+token)
        .when()
            .get("https://api.github.com/user/repos")
        .then()
            .statusCode(200)
            .log().all();
    }
    
//    @Test(priority = 5)
    void testOAuth1Authentication() {
        given()
            .auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret") // OAuth1.0 authentication this one old give's by devloper
        .when()
            .get("url")
        .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    void testOAuth2Authentication() {
        given()
            .auth().oauth2("Beare token value was remove , giving error on pushing code") // OAuth2.0 authentication (it's almost like bearer token generate this hit another API) 
        .when()
            .get("https://api.github.com/user/repos")
        .then()
            .statusCode(200)
            .log().all();
    }
    
//    @Test
    void testAPIKeyAuthentication() {
        given()
            .queryParam("appid", "XXXXXXXXXXXXXXXsendAuthentication") //appid is APIKey
        .when()
            .get("url")
        .then()
            .statusCode(200)
            .log().all();
    }
	
	

}
