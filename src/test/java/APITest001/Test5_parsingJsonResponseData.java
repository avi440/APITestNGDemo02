package APITest001;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test5_parsingJsonResponseData {
	
	
	//Approach001(find the response by path without storing )
	@Test(priority=1)
	void jsonResponse() {
		given()
			.contentType("ContentType.JSON")
		.when()  
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data[5].last_name",equalTo("Howell"));
	}
	
	
	//Approach002 (find the response by path with storing in Response variable and with path of only single element)
		@Test(priority=2)
		void jsonResponseAll() {
			Response res =  given()
				.contentType(ContentType.JSON)
			.when()  
				.get("https://reqres.in/api/users?page=2");
			
			Assert.assertEquals(res.getStatusCode(), 200);
			Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
			String name = res.jsonPath().get("data[5].last_name").toString();
			Assert.assertEquals(name,"Howell");
			
	
		}
		
		//Approach003(001) (find the response by path with storing in Response variable and with path of All with single element and find json object)
				@Test(priority=3)
				void jsonResponseAllPathJSONObject() {
					Response res =  given()
						.contentType(ContentType.JSON)
					.when()  
						.get("https://reqres.in/api/users?page=2");
					
					Assert.assertEquals(res.getStatusCode(), 200);
					Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
					String name = res.jsonPath().get("data[5].last_name").toString();
					Assert.assertEquals(name,"Howell");
					
					JSONObject obj = new JSONObject(res.asString()); // convert to String
					for(int i=1;i<obj.getJSONArray("data").length();i++) {
						
						String ele = obj.getJSONArray("data").getJSONObject(i).get("first_name").toString();	// it'll go to data and jsonArray and element
						System.out.println("AAAAAAAAA:  "+ele);
					}
					
			
				}
				
				//Approach003(002) (find the response by path with storing in Response variable and with path of All with single element and find json object)
//				@Test(priority=3)
				void jsonResponseAllPathJsonArray() {
					Response res =  given()
						.contentType(ContentType.JSON)
					.when()  
						.get("https://jsonplaceholder.typicode.com/todos");
					
			
					
					JSONArray obj = new JSONArray(res.asString()); // convert to String
					for(int i=1;i<obj.getJSONObject(0).length();i++) {
						
						String ele = obj.getJSONObject(i).get("userId").toString();	// it'll go to data and jsonObject and element(it'll not work but showing purposes add this one) 
						System.out.println("AAAAAAAAA:  "+ele);
					}
					
			
				}

}
