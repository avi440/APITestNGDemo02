package APITest001;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.UUID;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


//// 1))))) If you run not work but bushing the knowledge 

public class Test2_PostrequestTypes {
	
	// using HashMap 
	
	@Test(priority=1)
	void updateUsers() {  
		
		HashMap data = new HashMap();
		String randomName =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 8);
		String randomJob =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 5);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%: "+randomName+"&&&&:"+randomJob);
		data.put("title", randomName);
		data.put("userId", randomJob);
		
		String name[] = {"Avi","ravi","sai"};
		data.put("user", name);
		given()
			.contentType("application/json")
			.body(data)
		.when()  
			.post("https://dummyjson.com/posts/add")
		.then()
			.statusCode(200)
				.body("page",equalTo(2))
			.body("title", equalTo(randomName))
			.body("userId", equalTo(randomJob))
			.body("name[0]", equalTo("Avi"))
			.body("name[1]", equalTo("ravi"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
	//2)))) sending Data in org.json libray 
	@Test(priority=1)
	void updateUsersJson() {  
		
		JSONObject data = new JSONObject();
		String randomName =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 8);
		String randomJob =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 5);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%: "+randomName+"&&&&:"+randomJob);
		data.put("title", randomName);
		data.put("userId", randomJob);
		
		String name[] = {"Avi","ravi","sai"};
		data.put("user", name);
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()  
			.post("https://dummyjson.com/posts/add")
		.then()
			.statusCode(200)
				.body("page",equalTo(2))
			.body("title", equalTo(randomName))
			.body("userId", equalTo(randomJob))
			.body("name[0]", equalTo("Avi"))
			.body("name[1]", equalTo("ravi"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
	
	//3)))) sending Data in pojo class 
		@Test(priority=1)
		void updateUsersPojo() {  
			
			Pojo_Postcall data = new Pojo_Postcall();
			String randomName =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 8);
			String randomJob =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 5);
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%: "+randomName+"&&&&:"+randomJob);
			data.setTitle(randomName);
			data.setUserId(randomJob);
			
			String name[] = {"Avi","ravi","sai"};
			data.setName(name);
			given()
				.contentType("application/json")
				.body(data)
			.when()  
				.post("https://dummyjson.com/posts/add")
			.then()
				.statusCode(200)
					.body("page",equalTo(2))
				.body("title", equalTo(randomName))
				.body("userId", equalTo(randomJob))
				.body("name[0]", equalTo("Avi"))
				.body("name[1]", equalTo("ravi"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();
		}
		
		//4)))) sending Data in json file
				@Test(priority=1)
				void updateUsersJsonFile() throws Exception {  
					
					File f = new File(".\\body.json");
					FileReader fr = new FileReader(f);
					JSONTokener jt = new JSONTokener(fr);
					JSONObject data = new JSONObject(jt);
					given()
						.contentType("application/json")
						.body(data.toString())
					.when()  
						.post("https://dummyjson.com/posts/add")
					.then()
						.statusCode(200)
							.body("page",equalTo(2))
						.body("title", equalTo("All is well"))
						.body("userId", equalTo("Avi123"))
						.body("name[0]", equalTo("Avi"))
						.body("name[1]", equalTo("ravi"))
						.header("Content-Type", "application/json; charset=utf-8")
						.log().all();
				}
		
	

}
