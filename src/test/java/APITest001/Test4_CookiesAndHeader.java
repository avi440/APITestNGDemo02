package APITest001;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Test4_CookiesAndHeader {
	
	// For Cookies
	@Test(priority=1)
	void cookiesInfo() {
	Response res = given()
			.when()  
				.get("https://www.google.com");
	
	// get single cookie
	String Cookies_Value = res.getCookie("AEC");
	System.out.println("%%%%%%%%%%%%%%%%"+Cookies_Value );
	
	// get all cookies 
//	Map<String, String> allCookies = res.getCookies();
//	for(int i=0;i<allCookies.size();i++ ){
//		System.out.println(allCookies.keySet()+"::"+allCookies);
//		
//	}
	Map<String, String> allCookies = res.getCookies();
	for (Map.Entry<String, String> entry : allCookies.entrySet()) {
	    String key = entry.getKey();
	    String value = entry.getValue();
	    System.out.println(key + "::" + value);
	}
		
	}
	
	@Test(priority=2)
	void headerTest001() {
		
		given()
		.when()  
			.get("https://www.google.com")
		.then()
		.header("Expires", "-1")
		.and()// not require
		.header("Content-Type","text/html; charset=ISO-8859-1");
		
		
	}
	
	//All Header
		@Test(priority=3)
		void AllHeader() {
		Response res = given()
				.when()  
					.get("https://www.google.com");
		
		// get single cookie
		String Cookies_Value = res.getHeader("Content-Type");
		System.out.println("%%%%%%%%%%%%%%%%"+Cookies_Value );
		
		
		// All Headers
		Headers allHeader = res.getHeaders();
		for (Header entry:allHeader) {
		    String key = entry.getName();
		    String value = entry.getValue();
		    System.out.println(key + "::" + value);
		}
			
		}
		
		
		@Test(priority=4)
		void testLogs() {
			
			given()
			.when()  
				.get("https://www.google.com")
			.then()
			 .log().body()  // it will give only response
			 .log().headers()  // only headers
			 .log().cookies()  // only cookies
			 .log().all(); // All values
		
			
			
		}

}
